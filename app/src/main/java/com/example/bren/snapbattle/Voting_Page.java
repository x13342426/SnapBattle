package com.example.bren.snapbattle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class Voting_Page extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
 /*   static {
        System.loadLibrary("native-lib");
    }*/


    Button like1;
    Button like2;
    Button like3;
    Button like4;
    Button Camera;


    TextView selfie1;
    TextView selfie2;
    TextView selfie3;
    TextView selfie4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting);

        // Example of a call to a native method

        selfie1 = findViewById(R.id.vote_count_1);

        selfie2 = findViewById(R.id.vote_count_2);

        selfie3 = findViewById(R.id.vote_count_3);

        selfie4 = findViewById(R.id.vote_count_4);

        Button like1 = findViewById(R.id.btn_like_1);
        Button like2 = findViewById(R.id.btn_like_2);
        Button like3 = findViewById(R.id.btn_like_3);
        Button like4 = findViewById(R.id.btn_like_4);
        Button Camera = findViewById(R.id.Btncamera);


    }

    public void onLikeClicked1(View v) {
        String countLike1 = selfie1.getText().toString().trim(); /*accessing selfie1 text, getting what ever is inside the textview, converting ti to string then,  trimming removes spaces at the end, when later converted there will be no issue, safety measure*/
        int count = Integer.parseInt(countLike1);/*convert the string into an integer, so you can increment it in INT form*/
        count++; /*incrementing the integer*/

        selfie1.setText(String.valueOf(count)); /*setting the text back,  the set text will only take a string, valueOF will take an integer or a double and give you back a string, setting the string in the selie1 text*/
    }

    public void onLikeClicked2(View v) {
        String countLike2 = selfie2.getText().toString().trim();
        int count = Integer.parseInt(countLike2);
        count++; /*incrementing the integer*/

        selfie2.setText(String.valueOf(count));
    }

    public void onLikeClicked3(View v) {
        String countLike3 = selfie3.getText().toString().trim();
        int count = Integer.parseInt(countLike3);
        count++; /*incrementing the integer*/

        selfie3.setText(String.valueOf(count));
    }

    public void onLikeClicked4(View v) {
        String countLike4 = selfie4.getText().toString().trim();
        int count = Integer.parseInt(countLike4);
        count++; /*incrementing the integer*/

        selfie4.setText(String.valueOf(count));
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Btncamera) {
            Intent i = new Intent(Voting_Page.this, Camera.class);
            startActivity(i);
        }

    }
}
