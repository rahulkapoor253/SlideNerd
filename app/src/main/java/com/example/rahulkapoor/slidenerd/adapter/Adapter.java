package com.example.rahulkapoor.slidenerd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rahulkapoor.slidenerd.R;
import com.example.rahulkapoor.slidenerd.listitems.RecyclerViewItems;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by rahulkapoor on 23/04/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private static final String TAG = "info";
    private ArrayList<RecyclerViewItems> mDataArrayList;//memory allocated to array list to avoid null pointer exception;
private Context mContext;

    private LayoutInflater inflater;

    public Adapter(Context context, ArrayList<RecyclerViewItems> data){
        this.mContext = context;
        this.mDataArrayList = data;

       inflater = LayoutInflater.from(mContext);
    }


    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.activity_list_items, parent, false);

        Log.i("info", "onCreateViewHolder called;");//it gets stored in cache memory and doesnot get called always;
        MyViewHolder holder = new MyViewHolder(rootView);//it passes the root of the list items xml file to viewholder class;


        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {

        RecyclerViewItems items = mDataArrayList.get(position);
        Log.i("info", "onBindViewHolder called at position: " + position);

holder.mTextView.setText(items.getText());
        holder.mImageView.setImageResource(items.getImage());


    }

    private void deleteItem(int pos){
        
        mDataArrayList.remove(pos);
        notifyItemRemoved(pos);//if i dont use this method the recycler view wont get notified to delete the item;

    }

    @Override
    public int getItemCount() {
        return mDataArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;
        private TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_placeholderimage);
            mTextView = (TextView) itemView.findViewById(R.id.tv_text);
            mImageView.setOnClickListener(this);//here we made our color image to be clickable;

        }

        @Override
        public void onClick(View v) {

            Toast.makeText(mContext, "item deleted at position: " + getPosition(), Toast.LENGTH_SHORT).show();
            deleteItem(getPosition());//to delete an item in the recycler view and use notifyItemRemoved;

        }
    }
}
