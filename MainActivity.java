package com.example.davidsyoun.fixedpricemeal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView appetizerStatus;
    TextView pastaStatus;
    TextView meatStatus;
    TextView dessertStatus ;

    public static String resultApp ="";
    public static String resultMeat ="";
    public static String resultPasta ="";
    public static String resultDessert ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appetizerStatus = (TextView) findViewById(R.id.appetizerStatus);
        pastaStatus = (TextView) findViewById(R.id.pastaStatus);
        meatStatus = (TextView) findViewById((R.id.meatStatus));
        dessertStatus = (TextView) findViewById((R.id.dessertStatus));

        appetizerStatus.setText("appetizer: ");
        pastaStatus.setText("pasta course: ");
        meatStatus.setText("meat/fish course: ");
        dessertStatus.setText("dessert course: ");

        Button appetizerBtn = (Button) findViewById(R.id.appetizer);
        appetizerBtn.setOnClickListener(this);
        Button pastaBtn = (Button) findViewById(R.id.pasta);
        pastaBtn.setOnClickListener(this);
        Button meatBtn = (Button) findViewById(R.id.meat);
        meatBtn.setOnClickListener(this);
        Button dessertBtn = (Button) findViewById(R.id.dessert);
        dessertBtn.setOnClickListener(this);

    }
    @Override

    public void onClick(View v){
        switch (v.getId()) {
            case (R.id.appetizer):
                Intent appetizerIntent = new Intent(MainActivity.this, ActivityAppetizer.class);
                startActivityForResult(appetizerIntent,102);
                break;
            case R.id.pasta:
                Intent pastaIntent = new Intent(MainActivity.this,ActivityPasta.class);
                startActivityForResult(pastaIntent, 103);
                break;
            case R.id.meat:
                Intent meatIntent = new Intent(MainActivity.this, ActivityMeat.class);
                startActivityForResult(meatIntent,104);
                break;
            case R.id.dessert:
                Intent dessertIntent = new Intent(MainActivity.this, ActivityDessert.class);
                startActivityForResult(dessertIntent,105);
                break;
        }
    }
    public void clearBtn(View view){
        TextView appetizerStatus = (TextView) findViewById(R.id.appetizerStatus);
        TextView pastaStatus = (TextView) findViewById(R.id.pastaStatus);
        TextView meatStatus = (TextView) findViewById((R.id.meatStatus));
        TextView dessertStatus = (TextView) findViewById((R.id.dessertStatus));

        appetizerStatus.setText("appetizer: ");
        pastaStatus.setText("pasta course: ");
        meatStatus.setText("meat/fish course: ");
        dessertStatus.setText("dessert course: ");
    }

    public void confirmBtn(View view){
        if (resultApp ==""|| resultPasta=="" || resultMeat =="" || resultDessert==""){
            Toast toast = Toast.makeText(getApplicationContext(),"please choose all course", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            Intent confirmIntent = new Intent(MainActivity.this, ActivityConfirm.class);
            startActivityForResult(confirmIntent, 106);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result;
        try	{
            if ((requestCode == 102 ) && (resultCode == Activity.RESULT_OK)){
                resultApp= data.getStringExtra("appetizer");
                //Log.d("test: ", result);
                appetizerStatus.setText("appetizer: "+ resultApp);
            }
            else if ((requestCode == 103 ) && (resultCode == Activity.RESULT_OK)){
                resultPasta = data.getStringExtra("pasta");
                pastaStatus.setText("pasta course: "+ resultPasta);
            }
            else if ((requestCode == 104 ) && (resultCode == Activity.RESULT_OK)){
                resultMeat = data.getStringExtra("meat");
                meatStatus.setText("meat/fish course: "+ resultMeat);
            }
            else if ((requestCode == 105 ) && (resultCode == Activity.RESULT_OK)) {
                resultDessert = data.getStringExtra("dessert");
                dessertStatus.setText("dessert course: " + resultDessert);
            }
//            else if ((requestCode == 105 ) && (resultCode == Activity.RESULT_OK)){
//                result = data.getStringExtra("confirm");
//            }
        }
        catch (Exception e) {
//            lblResult1.setText("Problems - " + requestCode + " " + resultCode);
        }
    }//onActivityResult
}
