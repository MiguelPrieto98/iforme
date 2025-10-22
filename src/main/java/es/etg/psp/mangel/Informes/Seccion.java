package es.etg.psp.mangel.Informes;

public class Seccion {
    private final String titulo;
    private final String contenido;

    public Seccion(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }
}