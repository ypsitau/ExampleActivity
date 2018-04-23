package io.github.ypsitau.exampl44eactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import io.github.ypsitau.exampleactivity.R;

public class MainActivity extends AppCompatActivity {
	private enum Key {
		cntClickFruit,
		cntClickColor,
	}
	int cntClickFruit;
	int cntClickColor;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		LogPrintf("onCreate()");
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
				LogPrintf("onCheckedChanged(): fruit=%s",
						((RadioButton)group.findViewById(checkedId)).getText());
				cntClickFruit++;
			}
		});
		radioGroup_color.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// Check if the change is caused by user input, not the device rotation.
				if (!group.findViewById(checkedId).isPressed()) return;
				LogPrintf("onCheckedChanged(): color=%s",
						((RadioButton)group.findViewById(checkedId)).getText());
				cntClickColor++;
			}
		});
		if (savedInstanceState == null) {
			LogPrintf("savedInstanceState == null");
			cntClickFruit = 0;
			cntClickColor = 0;
		} else {
		}
		super.onCreate(savedInstanceState);
	}
	@Override
	protected void onStart() {
		super.onStart();
		LogPrintf("onStart()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		LogPrintf("onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		LogPrintf("onPause()");

	}

	@Override
	protected void onStop() {
		super.onStop();
		LogPrintf("onStop()");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		LogPrintf("onDestroy()");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		LogPrintf("onSaveInstanceState()");
		outState.putInt(Key.cntClickFruit.name(), cntClickFruit);
		outState.putInt(Key.cntClickColor.name(), cntClickColor);
	}
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		cntClickFruit = savedInstanceState.getInt(Key.cntClickFruit.name());
		cntClickColor = savedInstanceState.getInt(Key.cntClickColor.name());
		LogPrintf("savedInstanceState != null; fruit:%d color:%d",
				cntClickFruit, cntClickColor);
	}
	public void LogPrintf(String format, Object... args) {
		Log.i(getString(R.string.app_name), String.format(format, args));
	}
}
