package objetos;

public class ouro extends objetos implements java.io.Serializable{
    
    private int valor;

    public ouro(String Nome, String Descricao, suporte Conteudo){
        super(Nome, Descricao, Conteudo);
        this.valor = 0;
    
    }
    public ouro(String Nome, String Descricao, int Valor, suporte Conteudo){
        super(Nome, Descricao, Conteudo);
        this.valor = Valor;
    }

    public int getValor(){
        return valor;
    }
    
}
