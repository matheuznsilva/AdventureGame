package objetos;

public class Porta extends Sala{
    private boolean Trancada;
    private boolean Saida;
    private Integer I;

    public Porta(boolean trancada, boolean saida) {
        Trancada = trancada;
        Saida = saida;
    }

    public boolean isTrancada() {
        return Trancada;
    }

    public void setTrancada(boolean trancada) {
        Trancada = trancada;
    }

    public boolean isSaida() {
        return Saida;
    }

    public void setSaida(boolean saida) {
        Saida = saida;
    }
}
