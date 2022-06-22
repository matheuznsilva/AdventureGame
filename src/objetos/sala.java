package objetos;

import geral.direcao;

public class sala {

    private sala w, s, a, d, cima, baixo;

    public sala(String Nome, String Descricao, sala w, sala s, sala a, sala d, sala cima, sala baixo, listaDeObjetos LO) {
        setNome(Nome);
        setDescricao(Descricao);
        this.w = w;
        this.s = s;
        this.a = a;
        this.d = d;
        this.cima = cima;
        this.baixo = baixo;
        setListaDeObjetos(LO);
    }

    public sala getW() {
        return w;
    }

    public void setW(sala w) {
        this.w = w;
    }

    public sala getS() {
        return s;
    }

    public void setS(sala s) {
        this.s = s;
    }

    public sala getA() {
        return a;
    }

    public void setA(sala a) {
        this.a = a;
    }

    public sala getD() {
        return d;
    }

    public void setD(sala d) {
        this.d = d;
    }

    public sala getCima() {
        return cima;
    }

    public void setCima(sala cima) {
        this.cima = cima;
    }

    public sala getBaixo() {
        return baixo;
    }

    public void setBaixo(sala baixo) {
        this.baixo = baixo;
    }

    public String descicao(){
        String descricaoSala;
        String descricaoObjeto;

        descricaoSala = String.format("%s. %s.", getNome(), getDescricao());
        descricaoObjeto = descricaoObjeto();
    }
    
}
