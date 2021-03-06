package com.mobileapps.mch1;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MatchingDemo1Activity extends Activity {
	public int[] iconIds = new int[] {R.drawable.icon0, R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5, R.drawable.icon6, R.drawable.icon7};	
	private final Handler handler = new Handler();	
	private boolean touchEnabled = true;
	private int count;
	private int size = 4;
	public ArrayList<MatchingDemo1Activity.Card> Cards = new ArrayList<MatchingDemo1Activity.Card>();
	public Card c1, c2;

	public class Card implements View.OnClickListener{
		public ImageView iv;
		public int imageId;
		public boolean isDone;
		public boolean isCovered;

		public Card(Context cx, int imageId, int h, int w){
			this.imageId = imageId;
			this.iv = new ImageView(cx);			
			this.iv.setLayoutParams(new TableRow.LayoutParams(h, w));
			this.iv.setOnClickListener(this);			
			this.isDone = false;
			cover();
		}

		public void cover(){
			this.iv.setImageResource(R.drawable.empty);
			this.isCovered = true;
		}

		public void uncover(){
			this.iv.setImageResource(this.imageId);
			this.isCovered = false;
		}

		public boolean match(Card c){
			return this.imageId == c.imageId;
		}

		@Override
		public void onClick(View v) {			
			if(touchEnabled){
				if(isCovered){				
					if(c1 == null){ //first clicked
						c1 = this;
						uncover();
					}else{ //second clicked				
						if(isCovered){
							if(match(c1)){
								uncover();
								isDone = true;
								c1.isDone = true;
								c1 = null;
								count = count - 2;
								if(count <=0){
									TextView tv = (TextView) findViewById(R.id.textView1);
									tv.setText("Well Done !!");
								}
							} else{
								touchEnabled = false;
								uncover();
								c2 = this;
								handler.postDelayed(new Runnable() {
									public void run() {
										c1.cover();
										c2.cover();
										c1 = null;
										touchEnabled = true;
									}
								}, 1000);
							}
						}
					}
				}				
			}
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); 	
		
		newGameSetup();

		Button b = (Button) findViewById(R.id.button_exit);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

		b = (Button) findViewById(R.id.button_newgame);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				newGameSetup();
			}
		});
	}

	public void newGameSetup(){
		TextView msg = (TextView) findViewById(R.id.textView1);
		msg.setText("");		
		count = size*size;

		Cards.clear();		
		for(int i: iconIds){
			Cards.add(new Card(this, i, getResources().getDimensionPixelSize(R.dimen.imageHeight), getResources().getDimensionPixelSize(R.dimen.imageWidth)));
			Cards.add(new Card(this, i, getResources().getDimensionPixelSize(R.dimen.imageHeight), getResources().getDimensionPixelSize(R.dimen.imageWidth)));
		}
		Collections.shuffle(Cards);
		TableLayout tbl = (TableLayout) findViewById(R.id.tableLayout1);
		tbl.removeAllViews();
		for(int i=0; i< size; i++){
			TableRow tr = new TableRow(this);
			tr.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			for(int j=0; j<size; j++){
				tr.addView(Cards.get(i*size + j).iv);
			}
			tbl.addView(tr);
		}
	}
}