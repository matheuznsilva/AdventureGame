package objetos;

public class Troll extends Suporte{

    private Boolean vivo;
    private Integer poder;
    
    public Troll(String Nome, String Descricao, ListaDeObjetos Obj, Sala SL, Boolean status, Integer poder){
        super(Nome, Descricao, Obj, SL);
        this.poder = poder;
        this.vivo = status;
    }

    public void setLocal(Sala SL){
        setConteudo(SL);
    }

    public Sala getLocal(){
        return (Sala) getConteudo();
    }

    public String descricaoLocal(){
        return ((Sala) getConteudo()).descricao();
    }

    
    public Boolean getVivo() {
        return vivo;
    }

    public void setVivo(Boolean vivo) {
        this.vivo = vivo;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }
}
