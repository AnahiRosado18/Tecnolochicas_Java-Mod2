package Sesion2.Reto1;

import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(600);
        return "Comunicaciones: enlace con estación terrestre establecido.";
    }
}
