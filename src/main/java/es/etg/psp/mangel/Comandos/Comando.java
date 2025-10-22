package es.etg.psp.mangel.Comandos;
// Interfaz funcional para comandos del sistema
public interface Comando {
    String getNombre();         // Nombre del comando (ej. "ps")
    String ejecutar();          // Ejecuta el comando y devuelve la salida
}