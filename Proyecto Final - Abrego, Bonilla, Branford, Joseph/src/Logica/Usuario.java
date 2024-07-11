package Logica;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String contrasena;
    private List<Recomendacion> recomendaciones;
    private List<Opinion> opiniones;
    private List<ListaDeseos> listaDeseos;
    private List<Amigo> amigos;

    // Constructor
    public Usuario(int id, String nombre, String direccion, String telefono, String email, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contrasena = contrasena;
        this.recomendaciones = new ArrayList<>();
        this.opiniones = new ArrayList<>();
        this.listaDeseos = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    // Métodos
    public void registrar() {
        System.out.println("Usuario registrado: " + this.nombre);
    }

    public boolean iniciarSesion(String email, String contrasena) {
        return this.email.equals(email) && this.contrasena.equals(contrasena);
    }

    public void recomendarLibro(Libro libro, int puntuacion) {
        Recomendacion recomendacion = new Recomendacion(this.id, libro.getId(), puntuacion);
        this.recomendaciones.add(recomendacion);
        System.out.println("Libro recomendado: " + libro.getTitulo());
    }

    public void opinarSobreLibro(Libro libro, String comentario, int puntuacion) {
        Opinion opinion = new Opinion(this.id, libro.getId(), comentario, puntuacion);
        this.opiniones.add(opinion);
        System.out.println("Opinión sobre el libro: " + libro.getTitulo() + " - " + comentario);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public List<Opinion> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(List<Opinion> opiniones) {
        this.opiniones = opiniones;
    }

    public List<ListaDeseos> getListaDeseos() {
        return listaDeseos;
    }

    public void setListaDeseos(List<ListaDeseos> listaDeseos) {
        this.listaDeseos = listaDeseos;
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Amigo> amigos) {
        this.amigos = amigos;
    }
}




