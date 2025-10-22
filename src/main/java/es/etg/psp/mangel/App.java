package es.etg.psp.mangel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import es.etg.psp.mangel.Comandos.EjecutadorComandos;
import es.etg.psp.mangel.Informes.Exportador;
import es.etg.psp.mangel.Informes.ExportadorMarkdown;
import es.etg.psp.mangel.Informes.Informe;
import es.etg.psp.mangel.Informes.Seccion;

// Punto de entrada de la aplicación
public class App {

    public static void main(String[] args) {

        // Ejecutar comandos del sistema
        EjecutadorComandos ejecutador = new EjecutadorComandos();
        Map<String, String> resultados = ejecutador.ejecutarTodos();

        // Construir el informe con las salidas
        Informe informe = new Informe();
        for (Map.Entry<String, String> entrada : resultados.entrySet()) {
            Seccion seccion = new Seccion(entrada.getKey(), entrada.getValue());
            informe.agregarSeccion(seccion);
        }

        // Exportar el informe en formato Markdown
        Exportador exportador = new ExportadorMarkdown();
        String salidaFinal = exportador.exportar(informe);

        // Guardar el resultado en archivo
        guardarComoArchivo("informe.md", salidaFinal);
    }

    // Guarda el contenido en un archivo local
    private static void guardarComoArchivo(String nombreArchivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(contenido);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}