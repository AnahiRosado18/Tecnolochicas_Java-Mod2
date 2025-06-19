package Sesion2.Reto2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...\n");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // Lista de profesionales
        String[] profesionales = {
            "Dra. Sánchez",
            "Dr. Gómez",
            "Enfermero López",
            "Dra. Martínez",
            "Dr. Ramírez"
        };

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String profesional : profesionales) {
            executor.execute(() -> {
                salaCirugia.usar(profesional);
            });
        }

        executor.shutdown(); // Espera que terminen
    }
}
