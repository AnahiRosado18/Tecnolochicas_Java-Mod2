package Sesion1.Reto2;

import java.util.*;

public class PlataformaMain {
    public static void main(String[] args) {
        // Crear materiales
        List<MaterialCurso> materiales = Arrays.asList(
            new Video("Introducción a Java", "Mario", 15),
            new Video("POO en Java", "Carlos", 20),
            new Articulo("Historia de Java", "Ana", 1200),
            new Articulo("Tipos de datos", "Luis", 800),
            new Ejercicio("Variables y tipos", "Luis"),
            new Ejercicio("Condicionales", "Mario")
        );

        // Mostrar materiales
        GestorMateriales.mostrarMateriales(materiales);

        // Contar duración total de videos
        List<Video> videos = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            }
        }
        GestorMateriales.contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        GestorMateriales.marcarEjerciciosRevisados(materiales);

        // Filtro por autor
        GestorMateriales.filtrarPorAutor(materiales, m -> m.getAutor().equals("Mario"));
    }
}
