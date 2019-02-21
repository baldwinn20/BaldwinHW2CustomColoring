package com.example.nicholasbaldwin.hw2customcoloring;

/**
 * <!-- class MasterController -->
 * <p>
 * This class sets up the master controller for all elements of the GUI
 *
 * @author Nicholas Baldwin
 * @version February 2019
 * <p>
 * Note: recieved help from Dylan Pascua with regard to organizing SeekBar and
 * SurfaceView methods within this and the SurfaceViewHandler classes
 */

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.rgb;

public class MasterController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    private TextView redValTV, greenValTV, blueValTV, imageTitle;
    private SeekBar redBar, greenBar, blueBar;
    private SurfaceViewHandler mySurfaceViewHandler;
    private CustomCircle leftWheel, rightWheel, brakeLight;
    private CustomRect truckBody, truckCab, truckSpoiler;
    private int red, green, blue;

    //MasterController constructor
    public MasterController(TextView redTV, TextView greenTV, TextView blueTV, TextView imageTV,
                            SeekBar redSB, SeekBar greenSB, SeekBar blueSB,
                            SurfaceViewHandler svh) {
        redValTV = redTV;
        greenValTV = greenTV;
        blueValTV = blueTV;
        imageTitle = imageTV;
        redBar = redSB;
        greenBar = greenSB;
        blueBar = blueSB;
        mySurfaceViewHandler = svh;
    }


    /** External Citation
     * Date:     18 February 2019
     * Problem:  Could not get TextViews to display SeekBar values
     * Resource: https://stackoverflow.com/questions/8956218/
     *           android-seekbar-setonseekbarchangelistener
     * Solution: I modified the replies from this post to fit my code
     */

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        String progString = Integer.toString(progress);

        //Sets class variables and color TextViews based on
        //which SeekBar is being used
        if (seekBar == redBar) {
            red = progress;
            redValTV.setText(progString);
        } else if (seekBar == greenBar) {
            green = progress;
            greenValTV.setText(progString);
        } else if (seekBar == blueBar) {
            blue = progress;
            blueValTV.setText(progString);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekbar) {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int xTouch = (int) event.getX();
        int yTouch = (int) event.getY();

        //Sets each class variable to one created in the SurfaceViewHandler
        truckBody = mySurfaceViewHandler.truckBody;
        truckCab = mySurfaceViewHandler.truckCab;
        leftWheel = mySurfaceViewHandler.leftWheel;
        rightWheel = mySurfaceViewHandler.rightWheel;
        truckSpoiler = mySurfaceViewHandler.truckSpoiler;
        brakeLight = mySurfaceViewHandler.brakeLight;

        //Defines criteria for whether or not user taps a certain element
        //and uses the boolean to set the label and seekbar values
        if (truckBody.containsPoint(xTouch, yTouch)) {
            imageTitle.setText(truckBody.getName());
            truckBody.setColor(rgb(red, green, blue));
        } else if (brakeLight.containsPoint(xTouch, yTouch)) {
            imageTitle.setText(brakeLight.getName());
            brakeLight.setColor(rgb(red, green, blue));
        } else if (truckCab.containsPoint(xTouch, yTouch)) {
            imageTitle.setText(truckCab.getName());
            truckCab.setColor(rgb(red, green, blue));
        } else if (leftWheel.containsPoint(xTouch, yTouch)) {
            imageTitle.setText(leftWheel.getName());
            leftWheel.setColor(rgb(red, green, blue));
        } else if (rightWheel.containsPoint(xTouch, yTouch)) {
            imageTitle.setText(rightWheel.getName());
            rightWheel.setColor(rgb(red, green, blue));
        } else if (truckSpoiler.containsPoint(xTouch, yTouch)) {
            imageTitle.setText(truckSpoiler.getName());
            truckSpoiler.setColor(rgb(red, green, blue));
        } else {
            imageTitle.setText("No Part Selected");
        }

        //NOTE: color only changes when you tap part after SeekBars
        //have been adjusted to desired color
        mySurfaceViewHandler.invalidate();
        return true;
    }
}
