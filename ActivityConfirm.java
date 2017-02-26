package com.example.davidsyoun.fixedpricemeal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import org.w3c.dom.Text;

public class ActivityConfirm extends AppCompatActivity {

    EditText nameSlot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        nameSlot = (EditText) findViewById(R.id.name);
//        Intent myLocalIntent = getIntent();
//        name = myLocalIntent.getStringExtra();


    }

//    private void handleClick(int index) {
//        Intent intentConfirm = new Intent(this, MainActivity.class);
//        intentConfirm.putExtra("dessert", );
//        setResult(Activity.RESULT_OK, intentDessert);
//        finish();
//    }
    public void sendBtn(View view){
        String name = nameSlot.getText().toString();
        Toast toast = Toast.makeText(getApplicationContext(),
                "Order for " + name + ", just sent to kitchen!", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        //finish();
    }
}
