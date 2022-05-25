package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class ProfileFragment extends Fragment {

    ImageView imageView1, imageView2;
    Button button;
    ObjectAnimator objectAnimator;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile,container,false);

        imageView1 = view.findViewById(R.id.cart);
        imageView2 = view.findViewById(R.id.doneShop);
        button = view.findViewById(R.id.buttonMove);

        objectAnimator = ObjectAnimator.ofFloat(imageView1,"x",900);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Added to cart",Toast.LENGTH_SHORT);
                objectAnimator.setDuration(1500);
                objectAnimator.start();
                view.clearAnimation();
                view.postDelayed(() -> {
                    imageView2.setVisibility(View.VISIBLE);
                    imageView1.setVisibility(View.INVISIBLE);
                },1600);
            }
        });



        return view;
    }
}