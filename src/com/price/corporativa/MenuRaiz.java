package com.price.corporativa;


import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class MenuRaiz extends ActionBarActivity {
	 //El drawerLayout es el que se desplega y
    //contiene dentro el menœ, normalmente un listview
    private DrawerLayout mDrawerLayout;
    //Declaremos el ListView
    private ListView mDrawerList;
    //ActionBarDrawerToggle es donde aparecer‡ el boton
    //para desplegar el menœ
    private ActionBarDrawerToggle mDrawerToggle;
    
	@
	Override
	protected void	onCreate(Bundle savedInstanceState)  {
		super.onCreate	(savedInstanceState);
		setContentView(R.layout.menuraiz);
		//Cambia el color del ActionBar
		getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color
				.parseColor("#103664")));
		//Se elimina el desplegar el nombre de al app
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		//Habilita el volver a la actionBar
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		//
		getSupportActionBar().setHomeButtonEnabled(true);
		
		
		//relacionamos con el XML
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        
        List<NavigationItem> navigationItems = new ArrayList<NavigationItem>();
        navigationItems.add(new NavigationItem(R.drawable.ic_action_accept, "Checklist"));
        //navigationItems.add(new NavigationItem(R.drawable.ic_action_help, "Help"));
        //navigationItems.add(new NavigationItem(R.drawable.ic_action_about, "About"));
        final ListView navigation = (ListView) findViewById(R.id.left_drawer);
        NavigationListAdapter adapter = new NavigationListAdapter(this, R.layout.item_drawer_layout, navigationItems);
        navigation.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new  OnItemClickListener() {
        	
            @Override
            public void onItemClick(AdapterView parent, View view,
                    int position, long id) {
                mDrawerList.setItemChecked(position, true);
     
                //tituloSeccion = opcionesMenu[position];
                getSupportActionBar().setTitle("prueba");
     
                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });
       
    }
        
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}
	
	
	private void selectItem(int position) {
        // Get text from resources
        //mTitle = getResources().getStringArray(R.array.nav_options)[position];
        //se marca como seleciconado en la lista
      	mDrawerList.setItemChecked(	position, true);
      	//pone el titulo en la barra
      	mDrawerList.getItemAtPosition(position);
        
        //drawerLayout.closeDrawer(navList);
    }
	
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    Toast.makeText(this, "Pulsado ", Toast.LENGTH_SHORT).show();
		    mDrawerLayoutItemSelected(position);
		    getSupportActionBar().setTitle("Checklist");
		    mDrawerLayout.closeDrawers();
		}
	
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menuraiz, menu);
	    return true;
	  }
	
	private void mDrawerLayoutItemSelected(int position){
		//se marca como seleciconado en la lista
		mDrawerList.setItemChecked(	position, true);
		
		mDrawerList.getItemAtPosition(position);
	}
	
	@
	Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 Toast.makeText(this, "Pulsado ", Toast.LENGTH_SHORT).show();
		return true;
		
	}

}
