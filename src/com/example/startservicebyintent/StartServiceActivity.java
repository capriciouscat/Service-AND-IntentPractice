package com.example.startservicebyintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;

public class StartServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_service);
		
		Button button1 = (Button) findViewById (R.id.button1);
		button1.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View view){
				Intent intent = new Intent(StartServiceActivity.this, MP3PlayService.class);
				startService(intent);
			}
		});
		
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View view){
				Intent intent = new Intent(StartServiceActivity.this, MP3PlayService.class);
				intent.putExtra("PAUSE", true);
				startService(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}
