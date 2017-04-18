package com.mllwf.oval;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etAccout;
    private EditText etPassward;
    private CheckBox cbRemember;
    private Button btnLogin;
    private CheckBox cbNoEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btn_login);
        cbNoEnable = (CheckBox) findViewById(R.id.cb_noenable);
        cbNoEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "isChecked:" + isChecked, Toast.LENGTH_SHORT).show();
                if (cbNoEnable.isChecked() == true) {
                    btnLogin.setEnabled(false);
                } else {
                    btnLogin.setEnabled(true);
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListItemActivty.class);
                startActivity(intent);
            }
        });
    }
}
