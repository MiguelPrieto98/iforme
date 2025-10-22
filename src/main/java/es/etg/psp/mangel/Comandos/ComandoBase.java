package es.etg.psp.mangel.Comandos;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Clase base con lógica común para ejecutar comandos del sistema
public abstract class ComandoBase implements Comando {

    // Ejecuta el comando usando Runtime y devuelve la salida combinada
    protected String ejecutarShell(String comando) {
        StringBuilder salida = new StringBuilder();

        try {
            Process proceso = Runtime.getRuntime().exec(new String[] { "bash", "-c", comando });

            // Captura salida estándar (stdout)
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    salida.append(linea).append("\n");
                }
            }

            // Captura salida de error (stderr)
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(proceso.getErrorStream()))) {
                String linea;
                while ((linea = errorReader.readLine()) != null) {
                    salida.append("[ERR] ").append(linea).append("\n");
                }
            }

        } catch (IOException e) {
            salida.append("Error al ejecutar ").append(comando).append(": ").append(e.getMessage());
        }

        return salida.toString();
    }
}