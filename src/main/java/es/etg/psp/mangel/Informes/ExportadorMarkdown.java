package es.etg.psp.mangel.Informes;

import java.util.List;

// Exporta el informe en formato Markdown
public class ExportadorMarkdown implements Exportador {

    @Override
    public String exportar(Informe informe) {
        StringBuilder salida = new StringBuilder();
        List<Seccion> secciones = informe.getSecciones();  // Asegura tipo correcto

        for (Seccion seccion : secciones) {
            salida.append("## ").append(seccion.getTitulo()).append("\n\n");
            salida.append(seccion.getContenido()).append("\n\n");
        }

        return salida.toString();
    }
}