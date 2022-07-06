package entities;

import geral.Palavras;

public class TiposDePalavras {
    private String palavra;
    private Palavras tipoDePalavra; 
    
    public TiposDePalavras(String PL, Palavras TP){
        palavra = PL;
        tipoDePalavra = TP;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public Palavras getTipoDePalavra() {
        return tipoDePalavra;
    }

    public void setTipoDePalavra(Palavras tipoDePalavra) {
        this.tipoDePalavra = tipoDePalavra;
    }

}
