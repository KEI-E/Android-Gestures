package com.example.mymenustest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    TextView tv, tv2;
    GestureDetector gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the textview
        tv = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);

        //Getting the gesture
        gd = new GestureDetector(this, this);
        gd.setOnDoubleTapListener(this);

        //Register in context menu
        registerForContextMenu(tv);
        registerForContextMenu(tv2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId() == R.id.textView)
            getMenuInflater().inflate(R.menu.context1, menu);

        if(v.getId() == R.id.textView2)
            getMenuInflater().inflate(R.menu.context2, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.tv1a)
            Toast.makeText(getApplicationContext(), "tv1a pressed", Toast.LENGTH_LONG).show();

        if(item.getItemId() == R.id.tv1b)
            Toast.makeText(getApplicationContext(), "tv1b pressed", Toast.LENGTH_LONG).show();

        if(item.getItemId() == R.id.tv2a)
            Toast.makeText(getApplicationContext(), "tv2a pressed", Toast.LENGTH_LONG).show();

        if(item.getItemId() == R.id.tv2b)
            Toast.makeText(getApplicationContext(), "tv2b pressed", Toast.LENGTH_LONG).show();

        return true;
        //return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu); //inflate

        return true;

        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.settingsbutton)
            Toast.makeText(getApplicationContext(), "settings pressed", Toast.LENGTH_LONG).show();

        if(item.getTitle() == "search")
            Toast.makeText(getApplicationContext(), "search pressed", Toast.LENGTH_LONG).show();

        return true;

        //return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gd.onTouchEvent(event);    //Tap on gesture detector and make it a handler for the on touch event system
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        tv.setText("on single tap confirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        tv.setText("on double tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        tv.setText("on double tap event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        tv.setText("on down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        tv.setText("on single tap up");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        tv.setText("scroll " + distanceX + " " +distanceY);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        tv.setText("on longpress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        tv.setText("fling ");
        return false;
    }
}