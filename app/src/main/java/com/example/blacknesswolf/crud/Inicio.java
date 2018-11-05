package com.example.blacknesswolf.crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.blacknesswolf.crud.Entidades.ConexionSQLiteH;

public class Inicio extends AppCompatActivity {

    Button btn_ingresoU,btn_Mostrar,btnLV_ver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ConexionSQLiteH conn=new ConexionSQLiteH(this,"bd_personas",null,1);

    btn_ingresoU=findViewById(R.id.btn_ingresoU);
    btn_Mostrar=findViewById(R.id.btn_Mostrar);
    btnLV_ver=findViewById(R.id.btnLV_ver);

   btn_ingresoU.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent = new Intent(view.getContext(),IngresoU.class);
           startActivityForResult(intent,0);
       }
   });
        btn_Mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Ver.class);
                startActivityForResult(intent,0);
            }
        });

btnLV_ver.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(view.getContext(),VerU.class);
        startActivityForResult(intent,0);
    }
});
    }

}
