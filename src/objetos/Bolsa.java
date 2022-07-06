package objetos;

public class Bolsa extends suporte{
    private boolean openable;
    private boolean estaAberta;

    public Bolsa(String Nome, String Descricao, ListaDeObjetos Lista, suporte Conteudo){
        super(Nome, Descricao, Lista, Conteudo);
        openable = false;
        estaAberta = true;
    }

    public Bolsa(String Nome, String Descricao, boolean podePegar, boolean podeMover, boolean podeAbrir, boolean Aberta, ListaDeObjetos Obj, suporte Conteudo){
        super(Nome, Descricao, podePegar, podeMover, Obj, Conteudo);
        openable = podeAbrir;
        estaAberta = Aberta;
    }

    public boolean Openable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public boolean estaAberta() {
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

        Str = super.descricao();
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
