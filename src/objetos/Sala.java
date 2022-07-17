package objetos;

public class Sala extends Suporte {

    private Sala w, s, a, d, cima, baixo;
    private Porta porta;



    public Sala(){
        super("Nova Sala","", null, null);
        this.w = null;
        this.s = null;
        this.a = null;
        this.d = null;
        this.cima = null;
        this.baixo = null;
    }

    public void iniciar(String Nome, String Descricao, Sala w, Sala s, Sala a, Sala d, Sala cima, Sala baixo, ListaDeObjetos Obj) {
        setNome(Nome);
        setDescricao(Descricao);
        this.w = w;
        this.s = s;
        this.a = a;
        this.d = d;
        this.cima = cima;
        this.baixo = baixo;
        setObjetos(Obj);
    } 
     public void iniciar(String Nome, String Descricao, Sala w, Sala s, Sala a, Sala d, Sala cima, Sala baixo, ListaDeObjetos Obj, Boolean status, Boolean saida) {
        setNome(Nome);
        setDescricao(Descricao);
        this.w = w;
        this.s = s;
        this.a = a;
        this.d = d;
        this.cima = cima;
        this.baixo = baixo;
        //this.porta = Porta().setTrancada(status);
        //this.porta = Porta().setSaida(saida);
        setObjetos(Obj);
    }

    public Sala getW() {
        return w;
    }

    public void setW(Sala w) {
        this.w = w;
    }

    public Sala getS() {
        return s;
    }

    public void setS(Sala s) {
        this.s = s;
    }

    public Sala getA() {
        return a;
    }

    public void setA(Sala a) {
        this.a = a;
    }

    public Sala getD() {
        return d;
    }

    public void setD(Sala d) {
        this.d = d;
    }

    public Sala getCima() {
        return cima;
    }

    public void setCima(Sala cima) {
        this.cima = cima;
    }

    public Sala getBaixo() {
        return baixo;
    }

    public void setBaixo(Sala baixo) {
        this.baixo = baixo;
    }

    public String descricao(){
        String descricaoSala;
        String descricaoObjeto;

        descricaoSala = String.format("%s. %s.", getNome(), getDescricao());
        descricaoObjeto = descreveObjeto();
        if(!descricaoObjeto.isEmpty()){
            descricaoSala += "\nOBJETOS:\n" + descricaoObjeto;
        }
        return descricaoSala;
    }
    
}
