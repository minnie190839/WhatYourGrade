package com.example.win8.whatyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText name =(EditText)findViewById(R.id.edit_Text_name);
        final EditText score =(EditText)findViewById(R.id.edit_Text_score);
        Button find =(Button)findViewById(R.id.button_findgrade);
        final Button exit =(Button)findViewById(R.id.button_exit);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.toString().length()<=0){
                    name.setError("ชื่อ");
                }
                if(score.toString().length()<=0){
                    score.setError("คะแนน");
                }
                double score1 = Double.valueOf(score.getText().toString());
                String name1 =String.valueOf(name.getText().toString());
                String GText;
                if (score1 >= 80){
                    GText = "A";
                }else if(score1>=70){
                    GText = "B";
                }else if (score1>=60) {
                    GText = "C";
                }else if(score1>=50){
                    GText = "D";
                }else{
                    GText="F";
                }
                Intent NewPage = new Intent(MainActivity.this,Main2Activity.class);

                NewPage.putExtra("name",name1);
                NewPage.putExtra("score",GText);
                startActivity(NewPage);
            }

        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = "Confirm Exit";
                String b = "แน่ใจว่าต้องการออกจากแอพ ?";

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle(a);
                dialog.setMessage(b);
                dialog.setPositiveButton("ยกเลิก", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                       dialog.cancel();
                    }

                });
                dialog.setNegativeButton("ออก", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        finish();
                    }

                });
                dialog.show();

            }
        });
    }
}
