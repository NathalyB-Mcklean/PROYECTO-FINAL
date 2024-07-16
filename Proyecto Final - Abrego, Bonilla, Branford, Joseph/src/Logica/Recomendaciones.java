package Logica;

import java.util.ArrayList;
import java.util.List;
import Logica.Libro;

public class Recomendaciones {

    // Método estático para obtener todos los libros disponibles
    public static Libro[] obtenerLibros() {
        return Libro.obtenerLibros(); // Devuelve todos los libros disponibles
    }

    // Método para filtrar libros por categoría
    public static Libro[] filtrarPorCategoria(Libro[] libros, String categoria) {
        List<Libro> librosFiltrados = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getCategoria().equalsIgnoreCase(categoria) || categoria.equalsIgnoreCase("Todos")) {
                librosFiltrados.add(libro);
            }
        }

        return librosFiltrados.toArray(new Libro[0]);
    }

    // Método para buscar libros por texto en el título o la descripción
    public static Libro[] buscarPorTexto(Libro[] libros, String textoBusqueda) {
        String textoBusquedaLowerCase = textoBusqueda.toLowerCase();

        List<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : libros) {
            String tituloLowerCase = libro.getTitulo().toLowerCase();
            String descripcionLowerCase = libro.getDescripcion().toLowerCase();

            if (tituloLowerCase.contains(textoBusquedaLowerCase) || descripcionLowerCase.contains(textoBusquedaLowerCase)) {
                librosEncontrados.add(libro);
            }
        }

        return librosEncontrados.toArray(new Libro[0]);
    }

    // Método para filtrar libros por estado de leído
    public static Libro[] filtrarLibrosPorEstado(boolean leidos) {
        List<Libro> librosFiltrados = new ArrayList<>();

        for (Libro libro : obtenerLibros()) {
            if (libro.isLeido() == leidos) {
                librosFiltrados.add(libro);
            }
        }

        return librosFiltrados.toArray(new Libro[0]);
    }
}
