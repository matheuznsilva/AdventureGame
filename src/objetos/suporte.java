package objetos;

import geral.SuporteGeral;

public class suporte extends Objetos{

    private ListaDeObjetos listaObjetos;
    private SuporteGeral SuporteGeral = null;
    private String objetoStr = "";

    public suporte(String Nome, String Descricao, ListaDeObjetos LO, suporte Conteudo) {
        super(Nome, Descricao, Conteudo);
        listaObjetos = LO;
    }

    public suporte(String Nome, String Descricao, boolean Capturavel, boolean Movel, ListaDeObjetos LO, suporte Conteudo) {
        super(Nome, Descricao, Capturavel, Movel, Conteudo);
        listaObjetos = LO;
    }

    public static Bolsa paraBolsa(Objetos Obj){
        Bolsa Bag = null;
        if(Obj instanceof Bolsa){
            Bag = (Bolsa) Obj;
        }
        return Bag;
    }

    public int quantidadeObjetos(){
        return listaObjetos.size();
    }

    private void encontrarObjeto(suporte SP, String nome){
        boolean encontrou = false;
        Bolsa Bag;
        for (Objetos obj : SP.getObjetos()) {
            if (obj.getNome().equals(nome)) {
                SuporteGeral = new SuporteGeral(obj, SP);
                encontrou = true;
            }
            if (!encontrou) {
                Bag = paraBolsa(obj);
                if ((Bag != null) && (Bag.estaAberta())){
                    encontrarObjeto(Bag, nome);
                }             
            }
        }
    }

    private void paraDescreverObjeto(suporte SP){
        ListaDeObjetos listaObj = SP.getObjetos();
        Bolsa Bag;

        for (Objetos obj : listaObj) {
            String nomeConteudo = "";
            if (obj.getConteudo() instanceof Bolsa) {
                nomeConteudo = " [ em " + obj.getConteudo().getNome() + " ]";
            }
            objetoStr += obj.getNome() + nomeConteudo + "\n";
            Bag = paraBolsa(obj);
            if ((Bag != null) && (Bag.estaAberta())) {
                if (Bag.quantidadeObjetos() > 0) {
                    paraDescreverObjeto(Bag);
                }
            }
        } 
    }

    public String descreveObjeto(){
        objetoStr = "";
        paraDescreverObjeto(this);
        return objetoStr;
    }

    public boolean Bolsa(Objetos Obj){
        return getObjetos().contains(Obj);
    }

    public SuporteGeral procurarObjeto(String nome) {
        SuporteGeral = null;
        encontrarObjeto(this, nome);
        return SuporteGeral;
    }

    public ListaDeObjetos getObjetos() {
        return listaObjetos;
    }

    public void setObjetos(ListaDeObjetos LO) {
        this.listaObjetos = LO;
    }

    public void remover(Objetos Obj){
        listaObjetos.remove(Obj);
    }

    public void adicionar(Objetos Obj){
        listaObjetos.add(Obj);
    }

    protected void moverObjeto(Objetos Obj, suporte origem, suporte destino){
        origem.remover(Obj);
        destino.adicionar(Obj);
        Obj.setConteudo(destino);
    }
    
}
