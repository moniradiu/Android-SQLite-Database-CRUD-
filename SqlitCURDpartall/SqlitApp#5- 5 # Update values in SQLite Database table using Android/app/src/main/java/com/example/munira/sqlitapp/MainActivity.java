package com.example.munira.sqlitapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*call datababse in this page*/
    DatabaseHelper myDb;

    private EditText name,surname,marks,updateEditId;
    private Button addbtn;
    private Button viewbtn;
    private Button updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb=new DatabaseHelper(this);

        name=findViewById(R.id.nameET);
        surname=findViewById(R.id.surmaneET);
        marks=findViewById(R.id.marksET);
        updateEditId=findViewById(R.id.updateIdET);
        addbtn=findViewById(R.id.buttonAdd);
        viewbtn=findViewById(R.id.buttonview);
        updatebtn=findViewById(R.id.buttonUpdate);


        AddData();/*data add so call add function*/
        ViewData();/*data all view call add function*/
        UpdateData();/*data update call add function*/
    }

    /*one click button add data*/

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

    /*one click and all data show*/

    public void ViewData(){
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Cursor res= myDb.getAllData();
               if (res.getCount()== 0){
                   /*show message*/
                   showMessage("Error","Nothing found");
                   return;

               }
                StringBuffer buffer = new StringBuffer();
               while (res.moveToNext()){
                   buffer.append("ID :"+res.getString(0)+"\n");
                   buffer.append("Name :"+res.getString(1)+"\n");
                   buffer.append("Surname :"+res.getString(2)+"\n");
                   buffer.append("Marks :"+res.getString(3)+"\n\n");
               }
               /*show all Data*/
               showMessage("Data",buffer.toString());
            }
        });
    }
    /*show messages so create*/
   public void showMessage(String title,String Message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    /*update data*/
    public void UpdateData(){
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated= myDb.UpdateData(updateEditId.getText().toString(),
                        name.getText().toString(),surname.getText().toString(),marks.getText().toString());

                if (isUpdated==true)
                    Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data can not Updated",Toast.LENGTH_LONG).show();
            }
        });
    }

}
