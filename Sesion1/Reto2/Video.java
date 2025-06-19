package Sesion1.Reto2;

public class Video extends MaterialCurso {
    private int duracion; // minutos

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracion + " min");
    }
}

