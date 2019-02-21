package com.example.nicholasbaldwin.hw2customcoloring;


import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarHandler implements SeekBar.OnSeekBarChangeListener {

    protected TextView myTextView;
    //SeekBarController mySeekBarController;

    public SeekBarHandler(TextView tv) {
        myTextView = tv;
        //mySeekBarController = sbc;
    }

    /**
     * External Citation
     * Date: 10 February 2019
     * Problem: Get to SeekBar to range from 0 to 255
     * Resource:
     * https://stackoverflow.com/questions/20762001
     * /how-to-set-seekbar-min-and-max-value
     * Solution: Used method from this post to set range
     */


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        String progString = Integer.toString(progress);
        myTextView.setText(progString);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekbar) {
    }
}

