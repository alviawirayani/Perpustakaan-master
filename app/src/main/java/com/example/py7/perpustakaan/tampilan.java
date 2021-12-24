package com.example.py7.perpustakaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class tampilan extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan);

        txt1 = findViewById(R.id.tampilannama);
        txt2 = findViewById(R.id.tampilanemail);
        txt3 = findViewById(R.id.tampilannim);
        txt4 = findViewById(R.id.tampilanno);
        txt5 = findViewById(R.id.tampilanstatus);
        txt6 = findViewById(R.id.tampilanjenis);
        txt7 = findViewById(R.id.tampilanusia);
        txt8 = findViewById(R.id.tampilanprogram);

        String nama = getIntent().getExtras().getString("nama");
        String email = getIntent().getExtras().getString("email");
        String nim = getIntent().getExtras().getString("nim");
        String no = getIntent().getExtras().getString("no");
        String status = getIntent().getExtras().getString("status");
        String jenis = getIntent().getExtras().getString("jeniskelamin");
        String usia = getIntent().getExtras().getString("usia");
        String program = getIntent().getExtras().getString("program");

        txt1.setText(nama);
        txt2.setText(email);
        txt3.setText(nim);
        txt4.setText(no);
        txt5.setText(status);
        txt6.setText(jenis);
        txt7.setText(usia);
        txt8.setText(program);
    }

    public void list(View view) {
        Intent i2 = new Intent(this, PeminjamanActivity.class);
        startActivity(i2);
    }
}