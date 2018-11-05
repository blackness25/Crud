package com.example.blacknesswolf.crud.Entidades;

public class Usuarios {
    private int id;
    private String Nombre;
    private String Apellido;
    private String Comentario;
    private String Edad;

    public Usuarios(int id, String nombre, String apellido, String comentario, String edad) {
        this.id = id;
        Nombre = nombre;
        Apellido = apellido;
        Comentario = comentario;
        Edad = edad;
    }

    public Usuarios() {

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getComentario() {
        return Comentario;
    }



    public String getEdad() {
        return Edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }



    public void setEdad(String edad) {
        Edad = edad;
    }
}

