package objetos;


public class Ouro extends Objetos{
    
    private int valor;

    public Ouro(String Nome, String Descricao, suporte Conteudo){
        super(Nome, Descricao, Conteudo);
        this.valor = 0;
    
    }
    public Ouro(String Nome, String Descricao, int Valor, suporte Conteudo){
        super(Nome, Descricao, Conteudo);
        this.valor = Valor;
    }

    public int getValor(){
        return valor;
    }
    
}
