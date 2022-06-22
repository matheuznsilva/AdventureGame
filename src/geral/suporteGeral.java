package geral;

import objetos.listaDeObjetos;
import objetos.objetos;
import objetos.suporte;

public class suporteGeral implements java.io.Serializable{
    
    private objetos obj;
    private suporte spt;

    public suporteGeral(objetos Objetos, suporte Suporte){
        obj = Objetos;
        spt = Suporte;
    }

    public objetos getObjetos(){
        return obj;
    }

    public void setObjetos(objetos Objetos){
        this.obj = Objetos;
    }

    public suporte getSuporte() {
        return spt;
    }

    public void setSuporte(suporte Suporte) {
        this.spt = Suporte;
    }

    public listaDeObjetos getLista(){
        return spt.getObjetos();
    }
}
