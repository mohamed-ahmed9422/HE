package com.example.thanya;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class Adapter2 extends BaseAdapter {
	ArrayList<NewsItems> data;
	Context con;;
	public Adapter2(ArrayList<NewsItems> data, Context con) {
		this.data = data;
		this.con = con;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub

		LayoutInflater inflater = (LayoutInflater) con.getSystemService(con.LAYOUT_INFLATER_SERVICE);
	final 	NewsItems n = data.get(arg0);
		if (n.state.equals("new")) {



			View v = inflater.inflate(R.layout.newitem, null);
			//add_fav = (Button) v.findViewById(R.id.fav);
					TextView t1 = (TextView) v.findViewById(R.id.texttitle);
			TextView t3 = (TextView) v.findViewById(R.id.date);
			TextView t2 = (TextView) v.findViewById(R.id.textcon);
			ImageView m = (ImageView) v.findViewById(R.id.image);
			ImageView m2 = (ImageView) v.findViewById(R.id.logo);
//			Typeface type = Typeface.createFromAsset(con.getAssets(), "fonts/type.TTF");
			t1.setText(n.title);
			t2.setText(n.content);
			t3.setText(n.date);
//			t1.setTypeface(type);
//			t3.setTypeface(type);

m2.setImageResource(R.drawable.ic_logos);
Glide.with(con).load(n.imgurl).into(m);


			return v;
		}

		 else if (n.state.equals("loading")) {
			View v2 = inflater.inflate(R.layout.load,null);
			return v2;
		}
		else
		{
			return  null;
		}



	}


}