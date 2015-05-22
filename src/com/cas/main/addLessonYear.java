package com.cas.main;

import lessons.year1;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.gelecegiyazanlar.navigationdrawer.R;


public class addLessonYear extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.addlessonyear);

		Button button1 = (Button) findViewById(R.id.button_year1);

		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(addLessonYear.this, year1.class);
				startActivity(i);

			}
		});

	}

}
