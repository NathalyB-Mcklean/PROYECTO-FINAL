package Logica;

import java.util.Date;

public class Opinion {
    private int id;
    private int idUsuario;
    private int idLibro;
    private String comentario;
    private int puntuacion;
    private Date fecha;

    // Constructor
    public Opinion(int idUsuario, int idLibro, String comentario, int puntuacion) {
        this.id = generateId();
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.fecha = new Date();
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
