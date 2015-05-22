package com.cas.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.gelecegiyazanlar.navigationdrawer.R;

public class Start extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		
		Button button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new OnClickListener(){
			
			public void onClick(View v){
				Intent i = new Intent(Start.this,HttpExample.class);
				startActivity(i);
				
			}
		});
		
		// İlk bastaki uyarı

				final AlertDialog.Builder builder = new AlertDialog.Builder(this);

				builder.setTitle("Uyarı");
				builder.setMessage("Lütfen duyurularını almak istediğiniz dersi seçin");
				builder.setCancelable(false);

				builder.setPositiveButton("Tamam",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								Toast.makeText(Start.this,
										"Eyvole kaaşim.Yukarıya bak", Toast.LENGTH_LONG)
										.show();
							}
						});

				AlertDialog dialog = builder.create();
				dialog.show();
	}

}
