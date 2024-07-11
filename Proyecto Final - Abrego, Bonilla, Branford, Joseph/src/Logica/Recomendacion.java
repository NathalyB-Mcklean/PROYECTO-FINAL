package Logica;

import java.util.Date;

public class Recomendacion {
    private int id;
    private int idUsuario;
    private int idLibro;
    private int puntuacion;
    private Date fecha;

    // Constructor
    public Recomendacion(int idUsuario, int idLibro, int puntuacion) {
        this.id = generateId();
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.puntuacion = puntuacion;
        this.fecha = new Date();
    }

    // Generador de ID (puede ser reemplazado por una lógica más compleja)
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

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
