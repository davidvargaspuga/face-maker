package com.example.davidvargas.cs301_homework2;
//@David Vargas Puga
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener, SeekBar.OnSeekBarChangeListener, Spinner.OnItemSelectedListener{

    protected Face face;
    protected SeekBar redSeekBar, blueSeekBar, greenSeekBar;
    protected TextView redTextView, blueTextView, greenTextView;
    protected RadioButton hairButton, eyesButton, skinButton;
    int checkClicked;
    FaceView faceView;
    Spinner hairSpinner;
    ArrayAdapter<String> adapter;
    Button buttonRandom;
    String [] arraySpinner = new String[] {
            "No Selection",
            "Bowl Cut",
            "Long Hair",
            "Short Hair"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //following lines initialize the FaceView and a new Face
        faceView = (FaceView) findViewById(R.id.faceView);
        face = new Face ();
        faceView.setFace(face);

        //following lines initialize the drop-down spinner and calls its listener
        hairSpinner = (Spinner) findViewById(R.id.hairSpinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairSpinner.setAdapter(adapter);
        hairSpinner.setSelection(0);
        hairSpinner.setOnItemSelectedListener(this);

        //following lines initialize button and calls its listener
        buttonRandom = (Button) findViewById(R.id.randomFaceButton);
        buttonRandom.setOnClickListener(this);

        //following lines initialize the three radio buttons and calls their listeners
        hairButton = (RadioButton) findViewById(R.id.hairRadioButton);
        hairButton.setOnClickListener(this); // calling onClick() method
        eyesButton = (RadioButton) findViewById(R.id.eyesRadioButton);
        eyesButton.setOnClickListener(this); // calling onClick() method
        skinButton = (RadioButton) findViewById(R.id.skinRadioButton);
        skinButton.setOnClickListener(this); // calling onClick() method

        //following lines initialize the three SeekBars, sets the max of SeekBars to 255,
        //and calls their listeners.
        redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        redSeekBar.setMax(255);
        redSeekBar.setOnSeekBarChangeListener(this);
        redTextView = (TextView) findViewById(R.id.redTextView);
        blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        blueSeekBar.setMax(255);
        blueSeekBar.setOnSeekBarChangeListener(this);
        blueTextView = (TextView) findViewById(R.id.blueTextView);
        greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        greenSeekBar.setMax(255);
        greenSeekBar.setOnSeekBarChangeListener(this);
        greenTextView = (TextView) findViewById(R.id.greenTextView);
    }

    //following method creates listener for item selected on spinner
    @Override
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        //sets the position of the item selected to a specific hair style (1=bowl cut, 2=long hair, or 3=short hair)
        face.setHairStyle(position);
        faceView.invalidate();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parentView) {
        //is empty since no actions are done when nothing is selected
    }

    //the following method creates the listeners for the clicks of individual buttons
    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {

            case R.id.hairRadioButton: //if the hair button is clicked, the hair color is represented by the SeekBars
                redSeekBar.setProgress(this.face.getHairColor(0));
                greenSeekBar.setProgress(this.face.getHairColor(1));
                blueSeekBar.setProgress(this.face.getHairColor(2));
                checkClicked = 0; //equal to zero to record that hair button has been clicked
                break;

            case R.id.eyesRadioButton: //if the eyes button is clicked, the eye color is represented by the SeekBars
                redSeekBar.setProgress(this.face.getEyeColor(0));
                greenSeekBar.setProgress(this.face.getEyeColor(1));
                blueSeekBar.setProgress(this.face.getEyeColor(2));
                checkClicked = 1; //equal to one to record that eye button has been clicked
                break;

            case R.id.skinRadioButton: //if the skin button is clicked, the skin color is represented by the SeekBars
                redSeekBar.setProgress(this.face.getSkinColor(0));
                greenSeekBar.setProgress(this.face.getSkinColor(1));
                blueSeekBar.setProgress(this.face.getSkinColor(2));
                checkClicked = 2; //equal to two to record that skin button has been clicked
                break;
            case R.id.randomFaceButton: //if the random button is clicked, a new random face is drawn
               face.Randomize();
               faceView.invalidate();
               //faceView.invalidate(); //invalidates the faceView
                //call the randomize method
                //draw on the surface view
                break;
            default:
                break;
        }
    }

    //following method creates the listeners for the three SeekBars
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.redSeekBar:
                redTextView.setText("Red: " + progress);
                switch(checkClicked)
                {
                    case 0:
                        face.setHairColor(progress, 0);
                        break;
                    case 1:
                        face.setEyeColor(progress, 0);
                        break;
                    case 2:
                        face.setSkinColor(progress, 0);
                        break;
                }
                break;
            case R.id.blueSeekBar:
                blueTextView.setText("Blue: " + progress);
                switch(checkClicked)
                {
                    case 0:
                        face.setHairColor(progress, 2);
                        break;
                    case 1:
                        face.setEyeColor(progress, 2);
                        break;
                    case 2:
                        face.setSkinColor(progress, 2);
                        break;
                }
                break;
            case R.id.greenSeekBar:
                greenTextView.setText("Green: " + progress);
               // this.face.setColor(2, progress);
                switch(checkClicked)
                {
                    case 0:
                        face.setHairColor(progress, 1);
                        break;
                    case 1:
                        face.setEyeColor(progress, 1);
                        break;
                    case 2:
                        face.setSkinColor(progress, 1);
                        break;
                }
                break;

        }
       faceView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //does nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //does nothing
    }
}

