package com.example.blacknesswolf.crud.Utilidades;

public class Utilidades {

public static final String TABLA_PERSONAS="persona";
public static final String CAMPO_ID="_id";
public static final String CAMPO_NOMBRE="nombre";
public static final String CAMPO_APELLIDO="apellido";
public static final String CAMPO_COMENTARIO="comentario";
public static final String CAMPO_EDAD="edad";

    //Creacion tabla personas
public static    final String CREAR_TABLA_PERSONAS="CREATE TABLE "+TABLA_PERSONAS+"("
            +CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +CAMPO_NOMBRE+" TEXT,"
            +CAMPO_APELLIDO+" TEXT,"
            +CAMPO_COMENTARIO+" TEXT,"
            +CAMPO_EDAD+" TEXT)";


}
