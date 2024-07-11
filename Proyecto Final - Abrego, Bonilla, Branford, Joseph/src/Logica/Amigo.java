package Logica;

public class Amigo {
    private int id;
    private int idUsuario;
    private int idAmigo;

    // Constructor
    public Amigo(int idUsuario, int idAmigo) {
        this.id = generateId();
        this.idUsuario = idUsuario;
        this.idAmigo = idAmigo;
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

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }
}
