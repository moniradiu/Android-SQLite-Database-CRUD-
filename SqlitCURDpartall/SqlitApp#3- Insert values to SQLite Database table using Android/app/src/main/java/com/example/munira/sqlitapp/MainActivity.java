package com.example.munira.sqlitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*call datababse in this page*/
    DatabaseHelper myDb;

    private EditText name,surname,marks;
    private Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb=new DatabaseHelper(this);

        name=findViewById(R.id.nameET);
        surname=findViewById(R.id.surmaneET);
        marks=findViewById(R.id.marksET);
        addbtn=findViewById(R.id.buttonAdd);


        AddData();/*data add so call add function*/
    }

    //one click button add data

    public void AddData(){
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted= myDb.insertData(name.getText().toString(),
                        surname.getText().toString(),
                        marks.getText().toString());
               if (isInserted==true)
                   Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
               else
                   Toast.makeText(MainActivity.this,"Data can not Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
