package objetos;

public class bolsa extends suporte implements java.io.Serializable{
    private boolean openable;
    private boolean estaAberta;

    public bolsa(String Nome, String Descricao, listaDeObjetos Lista, suporte Conteudo){
        super(Nome, Descricao, Lista, Conteudo);
        openable = false;
        estaAberta = true;
    }

    public bolsa(String Nome, String Descricao, listaDeObjetos Lista, boolean podeAbrir, boolean Aberta, suporte Conteudo){
        super(Nome, Descricao, Lista, podeAbrir, Aberta, Conteudo);
        openable = podeAbrir;
        estaAberta = Aberta;
    }

    public boolean isOpenable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public boolean isEstaAberta() {
        return estaAberta;
    }

    public void setEstaAberta(boolean estaAberta) {
        this.estaAberta = estaAberta;
    }

    public String abrir(){
        String Str;

        if(!openable){
            Str = "NÃO PODE SER ABERTO" + getNome();
        } else{
            if(estaAberta){
                Str = "O " + getNome() + " ESTA ABERTO";
            } else{
                estaAberta = false;
                Str = "ABRIL " + getNome();
            }
        }
        return Str;
    } 
    
    public String fechar(){
        String Str;

        if(!openable){
            Str = "NÃO PODE SER FECHADO" + getNome();
        } else{
            if(estaAberta){
                estaAberta = false;
                Str = "FECHANDO " + getNome();
            } else{
                Str = "O " + getNome() + " ESTA FECHADO";
            }
        }
        return Str;
    }

    public String Descricao(){
        String Str;

        Str = super.Descricao();
        if(openable){
            if(estaAberta){
                Str += " (ABERTA)";
            } else{
                Str += " (FECHADO)";
            }
        }
        if(estaAberta){
            if(getObjetos().size() > 0){
                Str += "\nEXISTE ALGO";
            }
        }
        return Str;
    }
}
