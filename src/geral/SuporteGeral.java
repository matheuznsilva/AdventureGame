package geral;

import objetos.ListaDeObjetos;
import objetos.Objetos;
import objetos.suporte;

public class SuporteGeral implements java.io.Serializable{
    
    private Objetos obj;
    private suporte spt;

    public SuporteGeral(Objetos Objetos, suporte Suporte){
        obj = Objetos;
        spt = Suporte;
    }

    public Objetos getObjetos(){
        return obj;
    }

    public void setObjetos(Objetos Objetos){
        this.obj = Objetos;
    }

    public suporte getSuporte() {
        return spt;
    }

    public void setSuporte(suporte Suporte) {
        this.spt = Suporte;
    }

    public ListaDeObjetos getLista(){
        return spt.getObjetos();
    }
}
