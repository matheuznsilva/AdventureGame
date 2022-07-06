package objetos;

import java.util.ArrayList;

public class ListaDeObjetos  extends ArrayList<Objetos>{

    private String nome;

    public ListaDeObjetos(String Nome){
        super();
        nome = Nome;
    }

    public String getNome() {
        return nome;
    }
    
}
