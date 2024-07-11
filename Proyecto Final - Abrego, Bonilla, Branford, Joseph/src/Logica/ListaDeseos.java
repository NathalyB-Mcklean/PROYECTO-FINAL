package Logica;

import java.util.Date;

public class ListaDeseos {
    private int id;
    private int idUsuario;
    private int idLibro;
    private Date fechaAñadido;

    // Constructor
    public ListaDeseos(int idUsuario, int idLibro) {
        this.id = generateId();
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaAñadido = new Date();
    }

    // Generador de ID
    private int generateId() {
        return (int) (Math.random() * 10000);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public Date getFechaAñadido() {
        return fechaAñadido;
    }

    public void setFechaAñadido(Date fechaAñadido) {
        this.fechaAñadido = fechaAñadido;
    }
}
