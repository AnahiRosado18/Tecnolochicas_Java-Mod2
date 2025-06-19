package Sesion2.Reto1;

import java.util.concurrent.*;

public class SimulacionMision {
    public static void main(String[] args) {
        System.out.println("Simulación de misión espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            Future<String> nav = executor.submit(new SistemaNavegacion());
            Future<String> vital = executor.submit(new SistemaSoporteVital());
            Future<String> termico = executor.submit(new SistemaControlTermico());
            Future<String> com = executor.submit(new SistemaComunicaciones());

            // Mostrar resultados en cualquier orden (espera a cada uno)
            System.out.println(com.get());
            System.out.println(vital.get());
            System.out.println(termico.get());
            System.out.println(nav.get());

            System.out.println("Todos los sistemas reportan estado operativo.");

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error en la simulación: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
