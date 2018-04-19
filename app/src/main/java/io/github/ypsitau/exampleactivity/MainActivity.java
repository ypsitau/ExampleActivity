package io.github.ypsitau.exampleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    final static String KEY_FRUIT = "fruit";
    final static String KEY_COLOR = "color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(getString(R.string.app_name), "onCreate()");
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup_fruit = findViewById(R.id.radioGroup_fruit);
        RadioGroup radioGroup_color = findViewById(R.id.radioGroup_color);
/*
        radioGroup_fruit.check(R.id.radioButton_banana);
        radioGroup_color.check(R.id.radioButton_blue);
*/
        if (savedInstanceState == null) {
            Log.i(getString(R.string.app_name), "savedInstanceState == null");
            radioGroup_fruit.check(R.id.radioButton_banana);
            radioGroup_color.check(R.id.radioButton_blue);
        } else {
            Log.i(getString(R.string.app_name), String.format("savedInstanceState != null; fruit:%d color:%d",
                    savedInstanceState.getInt(KEY_FRUIT), savedInstanceState.getInt(KEY_COLOR)));
            radioGroup_fruit.check(savedInstanceState.getInt(KEY_FRUIT));
            radioGroup_color.check(savedInstanceState.getInt(KEY_COLOR));
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(getString(R.string.app_name), "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getString(R.string.app_name), "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(getString(R.string.app_name), "onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(getString(R.string.app_name), "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getString(R.string.app_name), "onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(getString(R.string.app_name), "onSaveInstanceState()");

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        RadioGroup radioGroup_fruit = findViewById(R.id.radioGroup_fruit);
        RadioGroup radioGroup_color = findViewById(R.id.radioGroup_color);
        Log.i(getString(R.string.app_name), String.format("onRestoreInstanceState(); fruit:%d color:%d",
                radioGroup_fruit.getCheckedRadioButtonId(), radioGroup_color.getCheckedRadioButtonId()));
        savedInstanceState.putInt(KEY_FRUIT, radioGroup_fruit.getCheckedRadioButtonId());
        savedInstanceState.putInt(KEY_COLOR, radioGroup_color.getCheckedRadioButtonId());
        Log.i(getString(R.string.app_name), String.format("immediately fruit:%d color:%d",
                savedInstanceState.getInt(KEY_FRUIT), savedInstanceState.getInt(KEY_COLOR)));
    }
}
