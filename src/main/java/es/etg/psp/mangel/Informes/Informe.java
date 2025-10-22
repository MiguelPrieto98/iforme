package es.etg.psp.mangel.Informes;
import java.util.ArrayList;
import java.util.List;



public class Informe {

    private final List<Seccion> secciones = new ArrayList<>();

    public void agregarSeccion(Seccion seccion) {
        secciones.add(seccion);
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }
}