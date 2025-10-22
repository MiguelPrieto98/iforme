package es.etg.psp.mangel.Comandos;

// Comando 'free' usando lógica común heredada
public class ComandoFree extends ComandoBase {
    @Override
    public String getNombre() { return "free"; }

    @Override
    public String ejecutar() {
        return ejecutarShell("free -h");
    }
}