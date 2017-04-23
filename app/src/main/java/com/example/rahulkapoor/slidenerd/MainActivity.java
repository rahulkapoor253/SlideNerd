package com.example.rahulkapoor.slidenerd;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rahulkapoor.slidenerd.listitems.RecyclerViewItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar appToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        appToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(appToolbar);
        //appToolbar.setTitle("Home Page");

        //to type cast into fragment manager;


        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationFragmentClass navigationFragmentClass = (NavigationFragmentClass) getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
        navigationFragmentClass.setUp(drawerLayout, appToolbar);

        //getData();



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);//to type cast the item into Menu;


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        if (item.getItemId() == R.id.menu_item_icon)
        {
            Toast.makeText( this, "successful",Toast.LENGTH_LONG ).show();

        }


        return super.onOptionsItemSelected(item);
    }
}
