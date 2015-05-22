package com.cas.main;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cas.fragments.FragmentSinif1;
import com.cas.fragments.FragmentSinif2;
import com.cas.fragments.FragmentSinif3;
import com.cas.fragments.FragmentSinif4;
import com.gelecegiyazanlar.navigationdrawer.R;

public class HttpExample extends Activity {

	ActionBar actionBar;
	
	// Sol Slider i�in Yap�lm�� �zel layout android.support.v4 �n i�inde
	private DrawerLayout mDrawerLayout;

	// Sol Slider A��ld���nda G�r�necek ListView
	private ListView mDrawerList;

	// Navigation Drawer nesnesini ActionBar'da g�sterir.
	private ActionBarDrawerToggle mDrawerToggle;

	// ActionBar'�n titlesi dinamik olarak de�i�ecek draweri a��p kapatt�k�a
	private String mTitle = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);//actionbar başlığını saklar
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.icon);//actionbar ikon değiştirir.
		
		// Content alan�na fragment y�klemek i�in
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		FragmentSinif1 fragmentHome = new FragmentSinif1();
		ft.add(R.id.content_frame, fragmentHome);
		ft.commit();
		
		mTitle = "CAS";
		getActionBar().setTitle(mTitle);

		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.drawer_list);
		// iconu ve a��l�p kapand���nda g�r�necek texti veriyoruz.
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			// drawer kapat�ld���nda tetiklenen method
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu();

			}

			// drawer a��ld���nda tetiklenen method
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Sınıflar");
				invalidateOptionsMenu();
			}

		};

		// A��l�p kapanmay� dinlemek i�in register
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// Navigationdaki Drawer i�in listview adapteri
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
				R.layout.drawer_list_item, getResources().getStringArray(R.array.menu));

		// adapteri listviewe set ediyoruz
		mDrawerList.setAdapter(adapter);

		// actionbar home butonunu aktif ediyoruz
		getActionBar().setHomeButtonEnabled(true);

		// navigationu t�klanabilir hale getiriyoruz
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// sol slider a��ld���nda gelen listviewin t�klama eventi
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// itemleri arraya tekrar ald�k
				String[] menuItems = getResources().getStringArray(R.array.menu);

				// dinamik title yapmak i�in actionbarda t�klanan�n titlesi g�r�necek
				mTitle = menuItems[position];
				
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction ft = fragmentManager.beginTransaction();

				// fragmenti contente yerle�tirme.
				if(position==0){
					FragmentSinif1 fragmentHome = new FragmentSinif1();
					ft.replace(R.id.content_frame, fragmentHome);
					ft.commit();
				}else if(position==1){
					FragmentSinif2 fragmentAndroid = new FragmentSinif2();
					ft.replace(R.id.content_frame, fragmentAndroid);
					ft.commit();
				}else if(position==2){
					FragmentSinif3 fragmentIOS = new FragmentSinif3();
					ft.replace(R.id.content_frame, fragmentIOS);
					ft.commit();
				}else if(position==3){
					FragmentSinif4 fragmentWindowsPhone = new FragmentSinif4();
					ft.replace(R.id.content_frame, fragmentWindowsPhone);
					ft.commit();
				}
				
				// draweri kapat
				mDrawerLayout.closeDrawer(mDrawerList);

			}
		});
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//draweri sadece swipe ederek a�ma yerine sol tepedeki butona basarak a�mak i�in
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		
		int id = item.getItemId();
		
        switch(id){
            case R.id.action_arama://arama'yatıklandıgında
                //Toast.makeText(this, "Ders ekleme seçildi.", Toast.LENGTH_SHORT).show();
            	dersEkle();
                break;
           /* case R.id.action_sorma://sorma'ya tıklandıgında
                Toast.makeText(this, "Sorma seçildi.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_deneme://deneme'ye tıklandıgında
                Toast.makeText(this, "Deneme seçildi.", Toast.LENGTH_SHORT).show();
                break;*/
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
		
		
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		// navigationDrawer a��ld���nda ayarlar� gizlemek i�in
		menu.findItem(R.id.action_arama).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		//getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	public void onArticleSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
	}
	
	public void dersEkle(){
        Intent myIntent = new Intent(HttpExample.this, addLessonYear.class);
        startActivity(myIntent);
    }

	
}
