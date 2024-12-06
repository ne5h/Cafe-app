package com.example.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String orderMessage = intent.getStringExtra("orderMessage");

        if (orderMessage != null) {
            Toast.makeText(this, orderMessage, Toast.LENGTH_LONG).show();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onRadioButtonClicked(View view) {
        // Check if the button is checked
        boolean checked = ((RadioButton) view).isChecked();

        // Use if-else statements instead of switch-case
        if (view.getId() == R.id.sameday && checked) {
            Toast.makeText(this, "Selected: Same Day Delivery", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.nextday && checked) {
            Toast.makeText(this, "Selected: Next Day Delivery", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.pickup && checked) {
            Toast.makeText(this, "Selected: Pick Up", Toast.LENGTH_SHORT).show();
        }
    }
}


