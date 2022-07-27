package objetos;

public class Porta extends Sala{
 
    private boolean Trancada;
    private boolean Saida;

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

    public String toString() {
        return "A Porta esta trancada procure a chave\n";
    }
    public String toString2() {
        return "Parabéns você chegou a porta de saida, tudo que precisa fazer eh atravessa-la\n";
    }
}
