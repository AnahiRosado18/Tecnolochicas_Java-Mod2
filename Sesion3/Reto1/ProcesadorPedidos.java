package Sesion3.Reto1;

import java.util.*;
import java.util.stream.*;

public class ProcesadorPedidos {
    public static void main(String[] args) {
        // Lista de pedidos
        List<Pedido> pedidos = Arrays.asList(
            new Pedido("Juan", "domicilio", "555-1234"),
            new Pedido("Ana", "local", "555-0000"),
            new Pedido("Luis", "domicilio", null),
            new Pedido("Sofía", "domicilio", "555-5678"),
            new Pedido("Pedro", "local", null)
        );

        // Procesamiento
        List<String> mensajes = pedidos.stream()
            .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
            .map(Pedido::getTelefono)
            .flatMap(Optional::stream)
            .map(tel -> "Confirmación enviada al número: " + tel)
            .collect(Collectors.toList());

        // Mostrar mensajes
        mensajes.forEach(System.out::println);
    }
}
