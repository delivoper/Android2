package lessons;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.gelecegiyazanlar.navigationdrawer.R;

public class year1 extends Activity {
	
	CheckBox COM252,COM240,COM287,COM255;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.year1);
	
		
		COM252=(CheckBox)findViewById(R.id.COM252);
		COM240=(CheckBox)findViewById(R.id.COM240);
		COM287=(CheckBox)findViewById(R.id.COM287);
		COM255=(CheckBox)findViewById(R.id.COM255);
		
		Button button1 = (Button) findViewById(R.id.save);

		/*button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(year1.this, year1.class);
				startActivity(i);

			}
		});*/
		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				
				String s="";
				
				if(COM252.isChecked())
					s += "COM252\n";
				if(COM240.isChecked())
					s += "COM240\n";
				if(COM255.isChecked())
					s += "COM255\n";
				if(COM287.isChecked())
					s += "COM287\n";
				
				Toast.makeText(year1.this, s , Toast.LENGTH_SHORT).show();

			}
			});
	
	}
}
