package com.example.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	ExecutorService threadPool;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		threadPool = Executors.newFixedThreadPool(4);
		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				threadPool.execute(new DoWork());					
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class DoWork implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<100000;i++){
				for(int j=0; j<100000; j++){
				}
			}
		}
	}
	

}
