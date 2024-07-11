package Logica;

public class Autor {
    private int id;
    private String nombre;
    private String biografia;

    // Constructor
    public Autor(int id, String nombre, String biografia) {
        this.id = id;
        this.nombre = nombre;
        this.biografia = biografia;
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

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}