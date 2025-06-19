import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MeridianPrimeSystem {
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("🛰️ Iniciando monitoreo de sistemas en Meridian Prime...");

        Flux<String> trafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(nivel -> nivel > 70)
                .map(nivel -> "🚗 Alerta: Congestión del " + nivel + "% en Avenida Solar")
                .onBackpressureBuffer()
                .publishOn(Schedulers.parallel());

        Flux<String> contaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(101))
                .filter(pm -> pm > 50)
                .map(pm -> "🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)")
                .publishOn(Schedulers.parallel());

        Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    String[] prioridades = {"Baja", "Media", "Alta"};
                    return prioridades[random.nextInt(3)];
                })
                .filter(p -> p.equals("Alta"))
                .map(p -> "🚑 Emergencia vial: Accidente con prioridad " + p)
                .publishOn(Schedulers.parallel());

        Flux<String> trenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11))
                .filter(min -> min > 5)
                .map(min -> "🚝 Tren maglev con retraso crítico: " + min + " minutos")
                .onBackpressureBuffer()
                .publishOn(Schedulers.parallel());

        AtomicInteger rojoConsecutivo = new AtomicInteger(0);
        Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    String[] estados = {"Verde", "Amarillo", "Rojo"};
                    return estados[random.nextInt(3)];
                })
                .map(estado -> {
                    if (estado.equals("Rojo")) {
                        if (rojoConsecutivo.incrementAndGet() >= 3) {
                            rojoConsecutivo.set(0);
                            return "🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte";
                        }
                    } else {
                        rojoConsecutivo.set(0);
                    }
                    return null;
                })
                .filter(msg -> msg != null)
                .publishOn(Schedulers.parallel());

        // Merge all into a unified stream
        Flux<String> sistemaUnificado = Flux.merge(trafico, contaminacion, accidentes, trenes, semaforos)
                .doOnNext(System.out::println);

        // BONUS: Alerta global si 3 o más eventos críticos ocurren en ventana de 1 segundo
        sistemaUnificado.buffer(Duration.ofSeconds(1))
                .filter(lista -> lista.size() >= 3)
                .subscribe(lista -> {
                    System.out.println("🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime");
                    lista.forEach(evento -> System.out.println(" └─ " + evento));
                });

        // Mantener la aplicación viva
        Thread.sleep(20000); // Ejecutar por 20 segundos
    }
}
