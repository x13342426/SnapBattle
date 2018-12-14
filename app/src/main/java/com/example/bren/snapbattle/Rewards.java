package com.example.bren.snapbattle;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Rewards extends MainActivity {

    Dialog epicDialog;

    Button positivePopupBtn, negativePopupBtn, btnAccept, btnRetry;
    TextView titleTv, messageTv, titleTv2, messageTv2;
    ImageView closePopUpPositiveImage, closePopUpNegativeImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reward);


        epicDialog = new Dialog(this);


        positivePopupBtn = (Button) findViewById(R.id.positivePopupBtn);
        negativePopupBtn = (Button) findViewById(R.id.negativePopupBtn);

        negativePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowNegativePopup();
            }
        });
        positivePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPositivePopup();
            }
        });
    }


    public void ShowPositivePopup() {

        epicDialog.setContentView(R.layout.positive);
        closePopUpPositiveImage = (ImageView) epicDialog.findViewById(R.id.closePopUpPositiveImage);
        btnAccept = (Button) epicDialog.findViewById(R.id.btnAccept);
        titleTv = (TextView) epicDialog.findViewById(R.id.titleTv);
        messageTv = (TextView) epicDialog.findViewById(R.id.messageTv);

        closePopUpPositiveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

    }


    public void ShowNegativePopup() {
        epicDialog.setContentView(R.layout.negative);
        closePopUpNegativeImage = (ImageView) epicDialog.findViewById(R.id.closePopUpNegativeImage);
        btnRetry = (Button) epicDialog.findViewById(R.id.btnRetry);
        titleTv2 = (TextView) epicDialog.findViewById(R.id.titleTv2);
        messageTv2 = (TextView) epicDialog.findViewById(R.id.messageTv2);

        closePopUpNegativeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

    }


}
