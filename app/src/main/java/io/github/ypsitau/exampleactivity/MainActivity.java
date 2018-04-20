package io.github.ypsitau.exampleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private enum Key {
        CntClickFruit,
        CntClickColor,
    }
    int cntClickFruit;
    int cntClickColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(getString(R.string.app_name), "onCreate()");
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup_fruit = findViewById(R.id.radioGroup_fruit);
        RadioGroup radioGroup_color = findViewById(R.id.radioGroup_color);
        //radioGroup_fruit.check(R.id.radioButton_banana);
        //radioGroup_color.check(R.id.radioButton_blue);
        radioGroup_fruit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check if the change is caused by user input, not the device rotation.
                if (!group.findViewById(checkedId).isPressed()) return;
                Log.i(getString(R.string.app_name), String.format("onCheckedChanged(): fruit=%s",
                        ((RadioButton)group.findViewById(checkedId)).getText()));
                cntClickFruit++;
            }
        });
        radioGroup_color.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check if the change is caused by user input, not the device rotation.
                if (!group.findViewById(checkedId).isPressed()) return;
                Log.i(getString(R.string.app_name), String.format("onCheckedChanged(): color=%s",
                        ((RadioButton)group.findViewById(checkedId)).getText()));
                cntClickColor++;
            }
        });
        if (savedInstanceState == null) {
            Log.i(getString(R.string.app_name), "savedInstanceState == null");
            cntClickFruit = 0;
            cntClickColor = 0;
        } else {
            cntClickFruit = savedInstanceState.getInt(Key.CntClickFruit.name());
            cntClickColor = savedInstanceState.getInt(Key.CntClickColor.name());
            Log.i(getString(R.string.app_name), String.format("savedInstanceState != null; fruit:%d color:%d",
                    cntClickFruit, cntClickColor));
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
        outState.putInt(Key.CntClickFruit.name(), cntClickFruit);
        outState.putInt(Key.CntClickColor.name(), cntClickColor);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
