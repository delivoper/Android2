package com.cas.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cas.main.Start;
import com.gelecegiyazanlar.navigationdrawer.R;

public class FragmentSinif4 extends Fragment {

	private ListView listView4;
	private String[] dersler4;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.layout_sinif4, container,false);
		
		listView4 = (ListView) view.findViewById(R.id.listView4);
		dersler4 = getResources().getStringArray(R.array.my_data_list4);
		ArrayAdapter<String> objAdapter = new ArrayAdapter<String> (this.getActivity(),android.R.layout.simple_list_item_1,dersler4);
		listView4.setAdapter(objAdapter);
		
		listView4.setOnItemClickListener(new OnItemClickListener() {
			//@Override
			public void onItemClick(AdapterView<?> parent, View view ,int position,long id){
				if(position == 0){
					//Intent i = new Intent(FragmentSinif4.this ,Start.class);
					//startActivity(i);
				}
				else if(position == 1){
					
				}
				else if(position == 2){
									
				}
				else if(position == 3){
					
				}
				else if(position == 4){
									
				}
			}

		});
		
		return view;
	}
}
