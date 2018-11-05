package com.example.blacknesswolf.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blacknesswolf.crud.Entidades.ConexionSQLiteH;
import com.example.blacknesswolf.crud.Utilidades.Utilidades;

public class IngresoU extends AppCompatActivity {

EditText et_nombre,et_apellido,et_edad,et_comentario;
Button btn_guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_u);



        et_nombre=findViewById(R.id.et_nombre);
        et_apellido=(EditText) findViewById(R.id.et_apellido);
        et_edad=(EditText) findViewById(R.id.et_edad);
        et_comentario=(EditText) findViewById(R.id.et_comentario);
        btn_guardar=(Button) findViewById(R.id.btn_guardar);



    }
public void onClick(View view){
GuardarPersonas();
}
private void GuardarPersonas(){
        //Abrir conexion para escribir en la tabla
    ConexionSQLiteH conn=new ConexionSQLiteH(this,"BD_personas",null,1);
    //Abro la base de datos para poder editarla
    SQLiteDatabase BD=conn.getWritableDatabase();

    //Rapido para hacer registro
    ContentValues values=new ContentValues();
    values.put(Utilidades.CAMPO_NOMBRE,et_nombre.getText().toString());
    values.put(Utilidades.CAMPO_APELLIDO,et_apellido.getText().toString());
    values.put(Utilidades.CAMPO_EDAD,et_edad.getText().toString());
    values.put(Utilidades.CAMPO_COMENTARIO,et_comentario.getText().toString());


    Long IngresoDatos=BD.insert(Utilidades.TABLA_PERSONAS,Utilidades.CAMPO_ID,values);

    Toast.makeText(getApplicationContext(),"Guardado Exitoso"+IngresoDatos,Toast.LENGTH_LONG).show();
    BD.close();
}


}
