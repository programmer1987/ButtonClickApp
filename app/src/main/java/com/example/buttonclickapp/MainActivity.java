package com.example.buttonclickapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //link or reference to the widgets in the main layout
    private EditText userInput;
    //private Button button;
    private TextView textView;
    //for the logging template
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //call the template for the logging start log with in
        Log.d(TAG, "onCreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //the text in Brackets is the widget name
        //findViewById(R.id.editText) -> the element which was created
        userInput = (EditText) findViewById(R.id.editText);
        //set the text empty no defined txt from the layout in the field
        userInput.setText("");
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        /*replace the text with a new Text, blank string to replace the existing text with no text
        /this is only for the text view, not for the outcome section */
        textView.setText("");
        //for scroll of the text view if the text is going longer, only working with vertical scroll set in the design view
        textView.setMovementMethod(new ScrollingMovementMethod());

        //Click listener for the button click
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //.toString needed to display the getText() method
                String result = userInput.getText().toString();
                result = result + "\n";
                textView.append(result);
                userInput.setText("");
            }
        };
        //using the created object with the method setOnClickListener
        button.setOnClickListener(ourOnClickListener);
        //close log with out
        Log.d(TAG, "onCreate: out");
    }

    //following methods logging the information in the run window while the app is running
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        // String saveString = savedInstanceState.getString(TEXT_CONTENTS);
        // textView.setText(saveString);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

}
