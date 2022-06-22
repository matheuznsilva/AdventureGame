package objetos;

import java.util.ArrayList;

public class listaDeObjetos  extends ArrayList<objetos> implements java.io.Serializable{

    private String nome;

    public listaDeObjetos(String Nome){
        super();
        nome = Nome;
    }

    public String getNome() {
        return nome;
    }
    
}
