package objetos;

import geral.suporteGeral;

public class suporte extends objetos implements java.io.Serializable{

    private listaDeObjetos listaObjetos;
    private suporteGeral SuporteGeral = null;
    private String objetoStr = "";

    public suporte(String Nome, String Descricao, listaDeObjetos LO, suporte Conteudo) {
        super(Nome, Descricao, Conteudo);
        listaObjetos = LO;
    }

    public suporte(String Nome, String Descricao, boolean Capturavel, boolean Movel, listaDeObjetos LO, suporte Conteudo) {
        super(Nome, Descricao, Capturavel, Movel, Conteudo);
        listaObjetos = LO;
    }

    public listaDeObjetos getObjetos() {
        return listaObjetos;
    }

    public void setListaDeObjetos(listaDeObjetos LO) {
        this.listaObjetos = LO;
    }
    
}
