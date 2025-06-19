package Sesion2.Reto2;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        System.out.println("🏥 " + profesional + " intenta ingresar a " + nombre + "...");

        lock.lock(); // Comienza acceso exclusivo
        try {
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(1500); // Simula tiempo de uso
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println("⚠️ " + profesional + " fue interrumpido.");
        } finally {
            lock.unlock(); // Libera el recurso
        }
    }
}
