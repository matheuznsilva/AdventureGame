package objetos;


public class Tesouro extends Objetos{
    
    private int valor;

    public Tesouro(String Nome, String Descricao, Suporte Conteudo){
        super(Nome, Descricao, Conteudo);
        this.valor = 0;
    
    }
    public Tesouro(String Nome, String Descricao, int Valor, Suporte Conteudo){
        super(Nome, Descricao, Conteudo);
        this.valor = Valor;
    }

    public int getValor(){
        return valor;
    }
    
}
