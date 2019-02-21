package com.example.nicholasbaldwin.hw2customcoloring;

/**
 * <!-- class MainActivity -->
 * <p>
 * This class creates and implements all other classes
 * and objects within the app
 *
 * @author Nicholas Baldwin
 * @version February 2019
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Create a TextView, SeekBar, and SeekBarHandler for each color
        //to be used in the MasterController
        TextView redValTV = findViewById(R.id.redValTV);
        TextView greenValTV = findViewById(R.id.greenValTV);
        TextView blueValTV = findViewById(R.id.blueValTV);
        TextView imageTV = findViewById(R.id.imageTitleTV);
        SeekBar redBar = findViewById(R.id.redSeekBar);
        SeekBar greenBar = findViewById(R.id.greenSeekBar);
        SeekBar blueBar = findViewById(R.id.blueSeekBar);
        SurfaceViewHandler mySVH = findViewById(R.id.drawingSV);

        //Create a MasterController to make the objects above functional
        MasterController masterController = new MasterController(redValTV, greenValTV, blueValTV,
                imageTV, redBar, greenBar, blueBar, mySVH);

        //Attach each object to the MasterController
        redBar.setOnSeekBarChangeListener(masterController);
        greenBar.setOnSeekBarChangeListener(masterController);
        blueBar.setOnSeekBarChangeListener(masterController);
        mySVH.setOnTouchListener(masterController);
    }
}
