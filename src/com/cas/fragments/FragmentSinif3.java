package com.cas.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gelecegiyazanlar.navigationdrawer.R;

public class FragmentSinif3 extends Fragment {

	private ListView listView3;
	private String[] dersler3;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.layout_sinif3, container,false);
		
		listView3 = (ListView) view.findViewById(R.id.listView3);
		dersler3 = getResources().getStringArray(R.array.my_data_list3);
		ArrayAdapter<String> objAdapter = new ArrayAdapter<String> (this.getActivity(),android.R.layout.simple_list_item_1,dersler3);
		listView3.setAdapter(objAdapter);
		
		
		
		return view;
	}
}
