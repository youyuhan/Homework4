package com.example.administrator.weektest07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView mTextView;
    private Button btnOk,btnCancle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

 mTextView = findViewById(R.id.textview);
        btnOk = findViewById(R.id.btnOK);
        btnCancle = findViewById(R.id.btnCancle);
        Intent intent=this.getIntent(); final Bundle bundle=intent.getExtras(); String name=bundle.getString("name"); String enring="您确定删除"+name+"的记录吗"; mTextView.setText(enring); btnOk.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { Intent intent1=new Intent(); setResult(RESULT_OK); finish(); } });
         btnCancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setResult(RESULT_CANCELED,null);
                    finish();
                }
            });
    }
}