package com.studiographene.lawyerly.basecode.utilities;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.studiographene.lawyerly.R;

/**
 * Created by ashu on 24/02/17.
 */

public class ImageBindingAdapter {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.businessman);
        requestOptions.error(R.drawable.businessman);

        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .into(imageView);

//        if (url != null && !url.equals("")) {
//
//            Picasso.with(imageView.getContext()).load(url).placeholder(R.drawable.user).error(R.drawable.user).transform(new com.charpixel.baseandroidproject.Utilities.imagetransforms.CircleTransform()).into(imageView);
//        }else {
//
//            Picasso.with(imageView.getContext()).load(R.drawable.user).transform(new com.charpixel.baseandroidproject.Utilities.imagetransforms.CircleTransform()).into(imageView);
//        }
    }






    @BindingAdapter("app:srcCompat")
    public static void bindSrcCompat(ImageView imageView, Drawable drawable){

        imageView.setImageDrawable(drawable);
        // Your setter code goes here, like setDrawable or similar
    }


    @BindingAdapter({"bind:imageProfilePicUrl"})
    public static void loadProfilePicImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);


    }


}
