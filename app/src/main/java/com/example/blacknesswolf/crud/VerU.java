package com.example.blacknesswolf.crud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.blacknesswolf.crud.Entidades.ConexionSQLiteH;
import com.example.blacknesswolf.crud.Entidades.Usuarios;
import com.example.blacknesswolf.crud.Utilidades.Utilidades;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VerU extends AppCompatActivity {

    ListView Lv_verU;
    ArrayList<String> listaInformacion;
    ArrayList<Usuarios> listaPersona;
    ConexionSQLiteH conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_u);

        conn = new ConexionSQLiteH(getApplicationContext(), "BD_personas", null, 1);
        Lv_verU = (ListView) findViewById(R.id.Lv_VerU);

        ConsultaListaPersonas();
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        Lv_verU.setAdapter(adaptador);

        Lv_verU.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String informacion="id: "+listaPersona.get(pos).getId()+"\n";
                informacion+="Nombre: "+listaPersona.get(pos).getNombre()+"\n";
                informacion+="Apellido: "+listaPersona.get(pos).getApellido()+"\n";
                informacion+="Edad: "+listaPersona.get(pos).getComentario()+"\n";
                informacion+="Comentario: "+listaPersona.get(pos).getEdad()+"\n";
                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();
            }
        });


    }

    private void ConsultaListaPersonas() {
        SQLiteDatabase BD = conn.getReadableDatabase();

        Usuarios usuario = null;
        listaPersona = new ArrayList<Usuarios>();
        Cursor cursor = BD.rawQuery("SELECT * FROM " + Utilidades.TABLA_PERSONAS, null);

        while (cursor.moveToNext()) {
            usuario = new Usuarios();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setApellido(cursor.getString(2));
            usuario.setEdad(cursor.getString(3));
            usuario.setComentario((cursor.getString(4)));

            listaPersona.add(usuario);
        }
        ObtenerLista();    


    }

    private void ObtenerLista() {
        listaInformacion =new ArrayList<String>();
        for (int i=0; i<listaPersona.size();i++){
            listaInformacion.add(listaPersona.get(i).getId()+" - "+listaPersona.get(i).getNombre());
        }
    }
}

