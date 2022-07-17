package geral;

import objetos.ListaDeObjetos;
import objetos.Objetos;
import objetos.Suporte;

public class SuporteGeral implements java.io.Serializable{
    
    private Objetos obj;
    private Suporte spt;

    public SuporteGeral(Objetos Objetos, Suporte Suporte){
        obj = Objetos;
        spt = Suporte;
    }

    public Objetos getObjetos(){
        return obj;
    }

    public void setObjetos(Objetos Objetos){
        this.obj = Objetos;
    }

    public Suporte getSuporte() {
        return spt;
    }

    public void setSuporte(Suporte Suporte) {
        this.spt = Suporte;
    }

    public ListaDeObjetos getLista(){
        return spt.getObjetos();
    }
}
