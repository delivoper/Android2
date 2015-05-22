package com.cas.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gelecegiyazanlar.navigationdrawer.R;

public class FragmentSinif1 extends Fragment {
	
	private ListView listView1;
	private String[] dersler1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.layout_sinif1, container,false);
		
		listView1 = (ListView) view.findViewById(R.id.listView1);
		dersler1 = getResources().getStringArray(R.array.my_data_list1);
		ArrayAdapter<String> objAdapter = new ArrayAdapter<String> (this.getActivity(),android.R.layout.simple_list_item_1,dersler1);
		listView1.setAdapter(objAdapter);
		
		
		return view;
		
		
	}
	
	
}
