package com.example.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra("orderMessage","Order details from MainActivity");
                startActivity(intent);
            }
                               });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void displayToast(String mOrderMessage) {
        Toast.makeText(getApplicationContext(), mOrderMessage, Toast.LENGTH_SHORT).show();
    }

    public void startOrder(View view){
        mOrderMessage="Order has been started!";
        Toast.makeText(this,mOrderMessage,Toast.LENGTH_SHORT).show();
    }
    public void showDonutOrder(View view){
        mOrderMessage="You ordered a donut.";
        displayToast(mOrderMessage);
    }
    public void showIceCreamOrder(View view){
        mOrderMessage="You ordered an ice cream sandwich.";
        displayToast(mOrderMessage);
    }
    public void showFroyoOrder(View view){
        mOrderMessage="You ordered a Froyo.";
        displayToast(mOrderMessage);
    }



}