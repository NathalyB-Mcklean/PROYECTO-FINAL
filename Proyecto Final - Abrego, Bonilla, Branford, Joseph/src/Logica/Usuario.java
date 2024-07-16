package Logica;

public class Usuario {
    private String nombre;
    private String correo;
    private String contraseña;

    // Arreglo estático para almacenar todos los usuarios
    private static Usuario[] usuarios = new Usuario[10];
    private static int contadorUsuarios = 0;

    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    // Método para agregar un usuario al arreglo
    public static boolean agregarUsuario(Usuario nuevoUsuario) {
        if (contadorUsuarios < usuarios.length) {
            for (Usuario usuario : usuarios) {
                if (usuario != null && usuario.getNombre().equals(nuevoUsuario.getNombre())) {
                    return false; // Usuario ya existe
                }
            }
            usuarios[contadorUsuarios++] = nuevoUsuario;
            return true; // Usuario agregado exitosamente
        }
        return false; // No hay espacio para más usuarios
    }

    // Método para validar credenciales
    public static Usuario validarCredenciales(String nombre, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null; // Credenciales inválidas
    }

    public static Usuario[] getUsuarios() {
        return usuarios;
    }
}
//PRUEBA