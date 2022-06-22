package objetos;

public class objetos implements java.io.Serializable{
    
    private String nome;
    private String descricao;
    private boolean capturavel;
    private boolean movel;
    private suporte conteudo;

    public objetos(String Nome, String Descricao, suporte Conteudo){
        this.nome = Nome;
        this.descricao = Descricao;
        this.conteudo = Conteudo;
        this.capturavel = true;
        this.movel = true;
    }

    public objetos(String Nome, String Descricao, boolean Capturavel, boolean Movel, suporte Conteudo){
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

    public boolean isCapturavel() {
        return capturavel;
    }

    public void setCapturavel(boolean Capturavel) {
        this.capturavel = Capturavel;
    }

    public boolean isMovel() {
        return movel;
    }

    public void setMovel(boolean Movel) {
        this.movel = Movel;
    }

    public suporte getConteudo() {
        return conteudo;
    }

    public void setConteudo(suporte Conteudo) {
        this.conteudo = Conteudo;
    }

    public String abrir(){
        return "NÃO PODE ABRIR " + nome + "PORQUE NAO EH CONTEUDO.";
    }

    public String fechar(){
        return "NÃO PODE FECHAR " + nome + "PORQUE NAO EH CONTEUDO.";
    }

    public String descicao(){
        return nome + " " + descricao;
    }

    private boolean contem(bolsa Conteudo){
        suporte spt;
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

    public boolean inclui(objetos Obj){
        return (Obj instanceof bolsa) && (this.contem((bolsa) obj));
    }

}
