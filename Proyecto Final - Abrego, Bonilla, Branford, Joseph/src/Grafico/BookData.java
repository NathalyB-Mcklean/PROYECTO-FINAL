package Grafico;

import java.util.ArrayList;
import java.util.HashMap;

public class BookData {
    public static BookData instance;
    public HashMap<String, ArrayList<String>> comentariosMap;
    public HashMap<String, Integer> calificacionesMap;

    public BookData() {
        comentariosMap = new HashMap<>();
        calificacionesMap = new HashMap<>();
    }

    public static synchronized BookData getInstance() {
        if (instance == null) {
            instance = new BookData();
        }
        return instance;
    }

    public ArrayList<String> getComentarios(String tituloLibro) {
        return comentariosMap.getOrDefault(tituloLibro, new ArrayList<>());
    }

    public void addComentario(String tituloLibro, String comentario) {
        comentariosMap.putIfAbsent(tituloLibro, new ArrayList<>());
        comentariosMap.get(tituloLibro).add(comentario);
    }

    public int getCalificacion(String tituloLibro) {
        return calificacionesMap.getOrDefault(tituloLibro, 0);
    }

    public void setCalificacion(String tituloLibro, int calificacion) {
        calificacionesMap.put(tituloLibro, calificacion);
    }
}
