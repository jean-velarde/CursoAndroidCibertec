package com.jeancarlo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d("Ejercicio", "onCreate");

        btn = findViewById(R.id.btnMover);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Destino.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ejercicio", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ejercicio", "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ejercicio", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ejercicio", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ejercicio", "onDestroy");
    }
}