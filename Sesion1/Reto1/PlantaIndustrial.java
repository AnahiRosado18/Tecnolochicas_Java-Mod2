package Sesion1.Reto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlantaIndustrial {
    public static void main(String[] args) {
        // Crear listas por tipo
        List<OrdenMasa> ordenesMasa = Arrays.asList(
            new OrdenMasa("A123", 500),
            new OrdenMasa("A124", 750)
        );

        List<OrdenPersonalizada> ordenesPersonalizadas = Arrays.asList(
            new OrdenPersonalizada("P456", 100, "ClienteX"),
            new OrdenPersonalizada("P789", 150, "ClienteY")
        );

        List<OrdenPrototipo> ordenesPrototipos = Arrays.asList(
            new OrdenPrototipo("T789", 10, "Diseño"),
            new OrdenPrototipo("T790", 5, "Pruebas")
        );

        // Mostrar todas las órdenes
        GestorOrdenes.mostrarOrdenes(ordenesMasa);
        GestorOrdenes.mostrarOrdenes(ordenesPersonalizadas);
        GestorOrdenes.mostrarOrdenes(ordenesPrototipos);

        // Procesar personalizadas
        GestorOrdenes.procesarPersonalizadas(new ArrayList<>(ordenesPersonalizadas), 200);

        // Combinar todas en una sola lista
        List<OrdenProduccion> todas = new ArrayList<>();
        todas.addAll(ordenesMasa);
        todas.addAll(ordenesPersonalizadas);
        todas.addAll(ordenesPrototipos);

        // Contar totales
        GestorOrdenes.contarOrdenes(todas);
    }

}
