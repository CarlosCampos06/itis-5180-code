package com.example.testgridview;

import java.util.ArrayList;
import java.util.Collections;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private Integer[] mThumbIds = { R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4};
	ImageAdapter myImageAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridView = (GridView) findViewById(R.id.gridView1);
		ArrayList<Integer> icons = new ArrayList<Integer>();
		for(int thumb : mThumbIds){
			for(int i=0; i<4;i++){
				icons.add(thumb);
			}
		}
		myImageAdapter = new ImageAdapter(this, icons);
		myImageAdapter.shuffleIcons();
		gridView.setAdapter(myImageAdapter);	
		
		
	}

	public class ImageAdapter extends BaseAdapter {
		private Context mContext;
		ArrayList<Integer> icons;

		public void shuffleIcons(){
			Collections.shuffle(icons);
			notifyDataSetChanged();
		}
		
		public ImageAdapter(Context c, ArrayList<Integer> icons) {
			this.icons = icons;
			mContext = c;
		}

		public int getCount() {
			return icons.size();
			//return mThumbIds.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		// create a new ImageView for each item referenced by the Adapter
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) { // if it's not recycled, initialize some
										// attributes
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}

			//imageView.setImageResource(mThumbIds[position]);
			imageView.setImageResource(icons.get(position));
			return imageView;
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() == R.id.action_settings){
			this.myImageAdapter.shuffleIcons();
		}
		
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	
	
}
