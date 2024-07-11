package Logica;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private int id;
    private String titulo;
    private String tipo;
    private String editorial;
    private String isbn;
    private List<Categoria> categorias;
    private List<Autor> autores;

    // Constructor
    public Libro(int id, String titulo, String tipo, String editorial, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.editorial = editorial;
        this.isbn = isbn;
        this.categorias = new ArrayList<>();
        this.autores = new ArrayList<>();
    }

    // Métodos
    public void agregarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }

    public void asignarAutor(Autor autor) {
        this.autores.add(autor);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}




