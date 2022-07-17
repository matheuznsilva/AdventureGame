package objetos;

public class Objetos implements java.io.Serializable{
    
    private String nome;
    private String descricao;
    private boolean capturavel;
    private boolean movel;
    private Suporte conteudo;

    public Objetos(String Nome, String Descricao, Suporte Conteudo){
        this.nome = Nome;
        this.descricao = Descricao;
        this.conteudo = Conteudo;
        this.capturavel = true;
        this.movel = true;
    }

    public Objetos(String Nome, String Descricao, boolean Capturavel, boolean Movel, Suporte Conteudo){
        this.nome = Nome;
        this.descricao = Descricao;
        this.conteudo = Conteudo;
        this.capturavel = Capturavel;
        this.movel = Movel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String Descricao) {
        this.descricao = Descricao;
    }

    public boolean Capturavel() {
        return capturavel;
    }

    public void setCapturavel(boolean Capturavel) {
        this.capturavel = Capturavel;
    }

    public boolean Movel() {
        return movel;
    }

    public void setMovel(boolean Movel) {
        this.movel = Movel;
    }

    public Suporte getConteudo() {
        return conteudo;
    }

    public void setConteudo(Suporte Conteudo) {
        this.conteudo = Conteudo;
    }

    public String abrir(){
        return "NÃO PODE ABRIR " + nome + "PORQUE NAO EH CONTEUDO.";
    }

    public String fechar(){
        return "NÃO PODE FECHAR " + nome + "PORQUE NAO EH CONTEUDO.";
    }

    public String descricao(){
        return nome + " " + descricao;
    }

    private boolean contem(Recipiente Conteudo){
        Suporte spt;
        Boolean naBolsa = false;

        spt = this.getConteudo();
        while(spt != null){
            if(spt == Conteudo){
                naBolsa = true;
            }
            spt = spt.getConteudo();
        }
        return naBolsa;
    }

    public boolean inclui(Objetos Obj){
        return (Obj instanceof Recipiente) && (this.contem((Recipiente) Obj));
    }

}
