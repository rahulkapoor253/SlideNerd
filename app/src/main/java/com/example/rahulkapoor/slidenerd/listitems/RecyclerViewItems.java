package com.example.rahulkapoor.slidenerd.listitems;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rahulkapoor on 23/04/17.
 */

public class RecyclerViewItems {
    private int mImage;
    private String mText;//image is stored as in form of ID and text in form of string;


    public RecyclerViewItems(int ImageId, String data) {
    this.mImage = ImageId;
        this.mText = data;
    }

    public int getImage(){

        return mImage;
    }

    public String getText(){

        return mText;
    }



}
