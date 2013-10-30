package com.mobileapp.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HttpUrlConnectionActivity extends Activity {
	private String urlString = "http://liispapps.uncc.edu/mobileapps/index.php";
	private Handler handler;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        handler = new Handler(new Handler.Callback() {			
			public boolean handleMessage(Message msg) {			
				if(msg.getData().containsKey("ERROR")){
					Toast.makeText(getBaseContext(), msg.getData().getString("ERROR"), Toast.LENGTH_LONG).show();
				} else{
					Toast.makeText(getBaseContext(), msg.getData().getString("RESULT"), Toast.LENGTH_LONG).show();
				}
				return true;
			}
		});        
        ((Button) findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new Thread(getData).start();
			}
		});
    }
	
	private Runnable getData = new Runnable() {
		public void run() {
			Bundle bundle = new Bundle();
			Message msg = new Message();
			try {
				URL url = new URL(urlString);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.connect();
				int statusCode = con.getResponseCode();
				if ( statusCode == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));				
					String result = "", line;
					while((line = in.readLine()) != null){					
						result = result + "\n" + line;
					}
					in.close();
					con.disconnect();
					bundle.putString("RESULT", result);				
				}
			} catch (MalformedURLException e) {
				bundle.putString("ERROR", "Problem with URL");
			} catch (IOException e) {
				bundle.putString("ERROR", "Problem with connection");
			}
			msg.setData(bundle);
			handler.sendMessage(msg);
		}
	};
}
