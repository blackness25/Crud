 package com.example.blacknesswolf.crud;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blacknesswolf.crud.Entidades.ConexionSQLiteH;
import com.example.blacknesswolf.crud.Utilidades.Utilidades;

 public class Ver extends AppCompatActivity {

    EditText et_nombre1,et_apellido1,et_edad1,et_comentario1,et_buscar;
    Button btn_buscar;
    FloatingActionButton fab_guardar,fab_borrar;
    ConexionSQLiteH conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        conn=new ConexionSQLiteH(getApplicationContext(),"BD_personas",null,1);

        et_nombre1=findViewById(R.id.et_nombre1);
        et_apellido1=findViewById(R.id.et_apellido1);
        et_edad1=findViewById(R.id.et_edad1);
        et_comentario1=findViewById(R.id.et_comentario1);
        et_buscar=findViewById(R.id.et_buscar);
        btn_buscar=findViewById(R.id.btn_buscar);
        fab_guardar=findViewById(R.id.fab_guardar);
        fab_borrar=findViewById(R.id.fab_borrar);



    }
    public void onClick(View view){

        switch (view.getId()){
            case R.id.btn_buscar:
                buscar();
                break;
            case R.id.fab_guardar:
                actualizarU();
                break;
            case R.id.fab_borrar:
                Eliminar();
                break;
        }
    }

     private void Eliminar() {
         SQLiteDatabase BD=conn.getWritableDatabase();
         String [] parametros={et_buscar.getText().toString()};
         BD.delete(Utilidades.TABLA_PERSONAS,Utilidades.CAMPO_ID+"=?",parametros);
         Toast.makeText(getApplicationContext(),"Eliminado Exitoso!",Toast.LENGTH_LONG).show();
         BD.close();
         et_buscar.setText("");
         limpiar();
     }

     private void actualizarU() {

        SQLiteDatabase BD=conn.getWritableDatabase();
         String [] parametros={et_buscar.getText().toString()};
         ContentValues values=new ContentValues();
         values.put(Utilidades.CAMPO_NOMBRE,et_nombre1.getText().toString());
         values.put(Utilidades.CAMPO_APELLIDO,et_apellido1.getText().toString());
         values.put(Utilidades.CAMPO_EDAD,et_edad1.getText().toString());
         values.put(Utilidades.CAMPO_COMENTARIO,et_comentario1.getText().toString());
         BD.update(Utilidades.TABLA_PERSONAS,values,Utilidades.CAMPO_ID+"=?",parametros);
         Toast.makeText(getApplicationContext(),"Actualizacion Exitosa!",Toast.LENGTH_LONG).show();
         BD.close();
     }

     private void buscar() {
         SQLiteDatabase BD=conn.getReadableDatabase();
         String [] parametros={et_buscar.getText().toString()};
         String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_APELLIDO,Utilidades.CAMPO_EDAD,Utilidades.CAMPO_COMENTARIO};


         try {

             Cursor cursor=BD.query(Utilidades.TABLA_PERSONAS,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
             cursor.moveToFirst();
             et_nombre1.setText(cursor.getString(0));
             et_apellido1.setText(cursor.getString(1));
             et_edad1.setText(cursor.getString(2));
             et_comentario1.setText(cursor.getString(3));
             cursor.close();
         }catch (Exception e){

             Toast.makeText(getApplicationContext(),"No exsiste",Toast.LENGTH_LONG).show();
             limpiar();
         }


    }

     private void limpiar() {

    et_nombre1.setText("");
    et_apellido1.setText("");
    et_edad1.setText("");
    et_comentario1.setText("");
    }
 }
