package es.etg.psp.mangel.Comandos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Ejecuta todos los comandos registrados y devuelve sus resultados
public class EjecutadorComandos {

    private final List<Comando> comandos = List.of(
        new ComandoPs(),
        new ComandoDf(),
        new ComandoFree()
    );

    // Devuelve un mapa con nombre del comando y su salida
    public Map<String, String> ejecutarTodos() {
        Map<String, String> resultados = new LinkedHashMap<>();
        for (Comando comando : comandos) {
            resultados.put(comando.getNombre(), comando.ejecutar());
        }
        return resultados;
    }
}