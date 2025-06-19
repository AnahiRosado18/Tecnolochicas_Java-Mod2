package com.example.demo.runner;

import com.example.demo.modelo.Marca;
import com.example.demo.modelo.Producto;
import com.example.demo.repositorio.MarcaRepository;
import com.example.demo.repositorio.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final MarcaRepository marcaRepo;
    private final ProductoRepository productoRepo;

    public DataLoader(MarcaRepository marcaRepo, ProductoRepository productoRepo) {
        this.marcaRepo = marcaRepo;
        this.productoRepo = productoRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Marca apple = marcaRepo.save(new Marca("Apple"));
        Marca samsung = marcaRepo.save(new Marca("Samsung"));

        productoRepo.save(new Producto("iPhone 15", "Último modelo", 20000, apple));
        productoRepo.save(new Producto("iPad Pro", "Tablet potente", 15000, apple));

        productoRepo.save(new Producto("Galaxy S23", "Smartphone avanzado", 18000, samsung));
        productoRepo.save(new Producto("Smart TV", "Televisión inteligente", 12000, samsung));

        System.out.println("\n📚 Productos por marca:");
        marcaRepo.findAll().forEach(marca -> {
            System.out.println("🏷️ " + marca.getNombre() + ":");
            productoRepo.findAll().stream()
                .filter(p -> p.getMarca() != null && p.getMarca().getId().equals(marca.getId()))
                .forEach(p -> System.out.println("   - " + p.getNombre()));
        });
    }
}
