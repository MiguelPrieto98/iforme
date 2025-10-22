package es.etg.psp.mangel.Comandos;

// Comando 'df' usando lógica común heredada
public class ComandoDf extends ComandoBase {
    @Override
    public String getNombre() { return "df"; }

    @Override
    public String ejecutar() {
        return ejecutarShell("df -h");
    }
}