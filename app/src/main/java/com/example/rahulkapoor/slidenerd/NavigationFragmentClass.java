package com.example.rahulkapoor.slidenerd;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rahulkapoor.slidenerd.adapter.Adapter;
import com.example.rahulkapoor.slidenerd.listitems.RecyclerViewItems;

import java.util.ArrayList;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragmentClass extends Fragment {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ArrayList<RecyclerViewItems> mDataArrayList;
    private Adapter mAdapter;


    public NavigationFragmentClass() {
        // Required empty public constructor


    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_navigation, container, false);

        //to inflate the recycler view also;

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);//here we set the layout manager and adapter to the recycler view;


        mDataArrayList = new ArrayList<>();//memory allocated to arraylist;

        for(int i=0;i<10;i++) {
            mDataArrayList.add(new RecyclerViewItems(R.drawable.color_black, "black"));
            mDataArrayList.add(new RecyclerViewItems(R.drawable.color_brown, "brown"));
            mDataArrayList.add(new RecyclerViewItems(R.drawable.color_dusty_yellow, "yellow"));
            mDataArrayList.add(new RecyclerViewItems(R.drawable.color_gray, "gray"));
            mDataArrayList.add(new RecyclerViewItems(R.drawable.color_green, "green"));
            mDataArrayList.add(new RecyclerViewItems(R.drawable.color_red, "red"));
        }

        mAdapter = new Adapter(getContext(), mDataArrayList);//to pass current context and arraylist object to adapter;
        mRecyclerView.setAdapter(mAdapter);//to set the adapter
        //now to se tthe layout manager to the recycler view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return rootView;
    }


    public void setUp(DrawerLayout drawerLayout, final Toolbar toolbar) {
        this.mDrawerLayout = drawerLayout;
        this.mToolbar = toolbar;
        mDrawerToggle = new ActionBarDrawerToggle((Activity) getContext(), mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer ){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset<0.5) {
                    toolbar.setAlpha(1 - slideOffset);
                }
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {

                mDrawerToggle.syncState();

            }
        });



    }
}
