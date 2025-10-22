package es.etg.psp.mangel.Comandos;

// Comando 'ps' usando lógica común heredada
public class ComandoPs extends ComandoBase {
    @Override
    public String getNombre() { return "ps"; }

    @Override
    public String ejecutar() {
        return ejecutarShell("ps aux");
    }
}