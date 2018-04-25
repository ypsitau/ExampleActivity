package io.github.ypsitau.exampleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import io.github.ypsitau.exampleactivity.R;

public class MainActivity extends AppCompatActivity {
	private enum Key {
		cntClickFruit,
		cntClickColor,
	}
	int cntFruit;
	int cntColor;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LogPrintf("onCreate()");
		setContentView(R.layout.activity_main);
		final RadioGroup radioGroup_fruit = findViewById(R.id.radioGroup_fruit);
		final RadioGroup radioGroup_color = findViewById(R.id.radioGroup_color);
		final TextView textView_cntFruit = findViewById(R.id.textView_cntFruit);
		final TextView textView_cntColor = findViewById(R.id.textView_cntColor);
		radioGroup_fruit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// Check if the change is caused by user input, not the device rotation.
				if (!group.findViewById(checkedId).isPressed()) return;
				LogPrintf("onCheckedChanged(): fruit=%s",
						((RadioButton)group.findViewById(checkedId)).getText());
				cntFruit++;
				textView_cntFruit.setText(String.format("%d", cntFruit));
			}
		});
		radioGroup_color.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// Check if the change is caused by user input, not the device rotation.
				if (!group.findViewById(checkedId).isPressed()) return;
				LogPrintf("onCheckedChanged(): color=%s",
						((RadioButton)group.findViewById(checkedId)).getText());
				cntColor++;
				textView_cntColor.setText(String.format("%d", cntColor));
			}
		});
		if (savedInstanceState == null) {
			LogPrintf("savedInstanceState == null");
			cntFruit = 0;
			cntColor = 0;
			textView_cntFruit.setText(String.format("%d", cntFruit));
			textView_cntColor.setText(String.format("%d", cntColor));
		}
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
		outState.putInt(Key.cntClickFruit.name(), cntFruit);
		outState.putInt(Key.cntClickColor.name(), cntColor);
	}
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		LogPrintf("onRestoreInstanceState()");
		cntFruit = savedInstanceState.getInt(Key.cntClickFruit.name());
		cntColor = savedInstanceState.getInt(Key.cntClickColor.name());
	}
	public void LogPrintf(String format, Object... args) {
		Log.i(getString(R.string.app_name), String.format(format, args));
	}
}
