package io.github.ypsitau.exampleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getString(R.string.app_name), "onCreate()");
        setContentView(R.layout.activity_main);
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
}
