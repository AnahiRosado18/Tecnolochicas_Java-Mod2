package Sesion1.Reto2;

import java.util.List;
import java.util.function.Predicate;

public class GestorMateriales {

    // Mostrar cualquier tipo de material
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("Materiales del curso:");
        for (MaterialCurso m : lista) {
            m.mostrarDetalle();
        }
        System.out.println();
    }

    // Contar duración total de videos
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println("Duración total de videos: " + total + " minutos\n");
    }

    // Marcar ejercicios como revisados
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                ((Ejercicio) obj).marcarRevisado();
            }
        }
        System.out.println();
    }

    // (Opcional) Filtrar por autor usando Predicate
    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("Filtrando materiales por autor:");
        for (MaterialCurso m : lista) {
            if (filtro.test(m)) {
                m.mostrarDetalle();
            }
        }
    }
}
