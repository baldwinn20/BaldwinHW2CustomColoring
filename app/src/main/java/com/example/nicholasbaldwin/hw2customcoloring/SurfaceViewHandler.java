package com.example.nicholasbaldwin.hw2customcoloring;

/**
 * <!-- class SurfaceViewHandler -->
 * <p>
 * This class defines each shape within the drawing and draws it on the canvas
 *
 * @author Nicholas Baldwin
 * @version February 2019
 */

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

//SurfaceViewHandler constructor
public class SurfaceViewHandler extends SurfaceView {

    //create each shape needed to draw a rudimentary truck
    CustomCircle leftWheel = new CustomCircle("Left Wheel", 0xFF7e7e82, 350,
            700, 100);
    CustomCircle rightWheel = new CustomCircle("Right Wheel", 0xFF7e7e82, 900,
            700, 100);
    CustomCircle brakeLight = new CustomCircle("Brake Light", 0xFFFF0000, 250,
            375, 50);
    CustomRect truckBody = new CustomRect("Body", 0xFF013b99,
            200, 450, 1100, 700);
    CustomRect truckCab = new CustomRect("Cab", 0xFFcc5d08,
            700, 250, 1050, 450);
    CustomRect truckSpoiler = new CustomRect("Spoiler", 0xFF42f462,
            200, 250, 300, 450);


    public SurfaceViewHandler(Context context) {
        super(context);
        init();
    }

    public SurfaceViewHandler(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SurfaceViewHandler(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //draw shapes on canvas
        truckBody.drawMe(canvas);
        truckCab.drawMe(canvas);
        truckSpoiler.drawMe(canvas);
        brakeLight.drawMe(canvas);
        leftWheel.drawMe(canvas);
        rightWheel.drawMe(canvas);
    }
}

