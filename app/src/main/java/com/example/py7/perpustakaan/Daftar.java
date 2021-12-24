package com.example.py7.perpustakaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;



public class Daftar extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText nama;
    EditText nim;
    EditText email;
    EditText no;
    CheckBox reguler,paralel;
    RadioGroup rg;
    RadioButton perempuan;
    SeekBar usia;
    Spinner program;
    TextView us,ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        //inputan
        nama =findViewById(R.id.nama);
        nim =findViewById(R.id.nim);
        email =findViewById(R.id.email);
        no =findViewById(R.id.no);

        //status
        reguler= findViewById(R.id.reguler);
        paralel= findViewById(R.id.paralel);

        //jeniskelamin
        rg =findViewById(R.id.rg);

        //usia
        usia= findViewById(R.id.usia);
        us =findViewById(R.id.us);
        usia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                us.setText(String.valueOf(progress + "Tahun"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //Program Studi
        program =findViewById(R.id.program);
        ps =findViewById(R.id.ps);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.prodi, android.R.layout.simple_spinner_dropdown_item);
        program.setAdapter(adapter);
        program.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String programstudi = parent.getItemAtPosition(position).toString();
        ps.setText(String.valueOf(programstudi));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }


    public void kirim(View view) {
            int idradio = rg.getCheckedRadioButtonId();
            perempuan =findViewById(idradio);

            //kondisi status
            String status = "";

            if (reguler.isChecked()) {
                status = "Reguler";
            }else{
                status = "Paralel";
            }

            //Pop Up
            Toast.makeText(this,"Selamat! Anda Telah Terdaftar", LENGTH_SHORT).show();

            Intent i1 = new Intent(this, tampilan.class);
            i1.putExtra("nama", nama.getText().toString());
            i1.putExtra("nim", nim.getText().toString());
            i1.putExtra("email", email.getText().toString());
            i1.putExtra("no", no.getText().toString());
            i1.putExtra("usia", us.getText().toString());
            i1.putExtra("jeniskelamin", perempuan.getText().toString());
            i1.putExtra("program", ps.getText().toString());
            i1.putExtra("status", status);
            startActivity(i1);



        }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}