package com.cas.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gelecegiyazanlar.navigationdrawer.R;

public class FragmentSinif2 extends Fragment{

	private ListView listView2;
	private String[] dersler2;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.layout_sinif2, container,false);
		
		listView2 = (ListView) view.findViewById(R.id.listView2);
		dersler2 = getResources().getStringArray(R.array.my_data_list2);
		ArrayAdapter<String> objAdapter = new ArrayAdapter<String> (this.getActivity(),android.R.layout.simple_list_item_1,dersler2);
		listView2.setAdapter(objAdapter);
		
		
		return view;
	}
}
