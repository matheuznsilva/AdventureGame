package objetos;

import geral.Direcao;
import geral.SuporteGeral;

public class Personagem extends Suporte{
    
    public Personagem(String Nome, String Descricao, ListaDeObjetos Obj, Sala SL){
        super(Nome, Descricao, Obj, SL);
    }

    public void setLocal(Sala SL){
        setConteudo(SL);
    }

    public Sala getLocal(){
        return (Sala) getConteudo();
    }

    public String descricaoLocal(){
        return ((Sala) getConteudo()).descricao();
    }

    public String inventario(){
        String Str = descreveObjeto();
        if(Str.isEmpty()){
            Str = "NADA";
        }
        return Str;
    }

    public SuporteGeral objetoAqui(String nome){
        SuporteGeral SG = objetoNoInventario(nome);
        if(SG == null){
            SG = objetoNaSala(nome);
        }
        return SG; 
    }

    public SuporteGeral objetoNoInventario(String nome){
        return this.procurarObjeto(nome);
    }

    public SuporteGeral objetoNaSala(String nome){
        return((Sala) getConteudo()).procurarObjeto(nome);
    }

    public String fechar(String nome){
        SuporteGeral SG;
        Objetos Obj;
        String Str;

        if(nome.isEmpty()){
            Str = "O QUE VOCE DESEJA FECHAR? ";
        } else{
            SG = objetoAqui(nome);
            Obj = SG.getObjetos();
            if(Obj == null){
                Str = "O OBJETO " + nome + " NAO ESTA AQUI!";
            } else{
                Str = Obj.fechar();
            }
        }
        return Str;
    }

    public String abrir(String nome){
        SuporteGeral SG;
        Objetos Obj;
        String Str;

        if(nome.isEmpty()){
            Str = "O QUE VOCE DESEJA ABRIR? ";
        } else{
            SG = objetoAqui(nome);
            Obj = SG.getObjetos();
            if(Obj == null){
                Str = "O OBJETO " + nome + " NAO ESTA AQUI!";
            } else{
                Str = Obj.abrir();
            }
        }
        return Str;
    }

    public String olharDentro(String nome){
        SuporteGeral SG = objetoAqui(nome);;
        Objetos Obj;
        String Str = "";
        Recipiente Bag;

        if(SG == null){
            Str = "NAO VEJO " + nome + " AQUI!";
        } else{
            Obj = SG.getObjetos();
            Bag = paraBolsa(Obj);
            if(Bag == null){
                Str = "VOCE NAO PODE OLHAR DENTRO DE " + Obj.getNome() + "!";
            } else{
                if(Bag.estaAberta()){
                    Str = Bag.Descricao();
                    if(Str.isEmpty()){
                        Str = "A(O) " + Bag.getNome() + " ESTA VAZIA(O)";
                    } else{
                        Str = "A(O) " + Bag.getNome() + " CONTEM:\n" + Str;
                    }
                } else{
                    Str = "A(O) " + Bag.getNome() + " NAO ESTA ABERTA(O)!";
                }
            }
        }
        return Str;
    }

    public String olharPara(String nome){
        SuporteGeral SG = objetoAqui(nome);;
        Objetos Obj;
        String Str = "";
        Suporte SP;

        if(SG == null){
            Str = "NAO VEJO " + nome + " AQUI!";
        } else{
            Obj = SG.getObjetos();
            SP = SG.getSuporte();
            if(SP instanceof Recipiente){
                Str = "O(A) " + Obj.getNome() + " ESTA DENTRO DO(A)" + SP.getNome() + "\n";
            }
            Str += Obj.descricao();
        }
        return Str;
    }

    public String guardar(String nome, String nomeRecipiente){
        String Str;
        SuporteGeral SG, contSG;
        Objetos Obj;
        Recipiente Bag;

        SG = objetoNoInventario(nome);
        contSG = objetoAqui(nomeRecipiente);

        if(SG == null){
            Str = "VOCE NAO TEM " + nome;
        } else if(contSG == null){
            Str = nomeRecipiente + "NAO ESTA AQUI";
        } else{
            Obj = SG.getObjetos();
            Bag = paraBolsa(contSG.getObjetos());
            if((Bag == null)){
                Str = "VOCE NAO PODE GUARDAR " + nome + " DENTRO DE " + nomeRecipiente; 
            } else if(Obj == Bag){
                Str = "VOCE NAO PODE GUARDAR " + nome + " DENTRO DE SI MESMO"; 
            } else if(Bag.Bolsa(Obj)){
                Str = nome + " JA ESTA DENTRO DE " + nomeRecipiente; 
            } else if(!(Bag).estaAberta()){
                Str = "VOCE NAO PODE GUARDAR " + nome + " DENTRO DE " + nomeRecipiente + " POIS A MESMA ESTA FECHADA"; 
            } else if (Bag.inclui(Obj)){
                Str = "VOCE NAO PODE GUARDAR " + nome + " DENTRO DE " + nomeRecipiente + " PORQUE " + nomeRecipiente + " JA ESTA DENTRO DE " + nome; 
            } else{
                moverObjeto(Obj, SG.getSuporte(), Bag);
                Str = "VOCE GUARDOU " + nome + " DENTRO DE " + nomeRecipiente;
            }
        }
        return Str;
    }

    public String pegar(String nome){
        String Str;
        SuporteGeral SG;
        Objetos Obj;
        ListaDeObjetos LO;
        Suporte SP;

        SG = objetoAqui(nome);
        if(SG == null){
            Str = nome + "NAO ESTA AQUI";
        } else{
            Obj = SG.getObjetos();
            LO = SG.getLista();
            SP = SG.getSuporte();
            if(LO == this.getObjetos()){
                Str = "VOCE JA POSSUI " + nome; 
            } else{
                if(Obj.Capturavel()){
                    moverObjeto(Obj, SP, this);
                    if(SP instanceof Recipiente){
                        Str = "VOCE PEGOU " + nome + " DE " + SP.getNome(); 
                    } else{
                        Str = nome + " JA ESTA NA SUA MAO"; 
                    }
                } else{
                    Str = "VOCE NAO PODE PEGAR " + Obj.getNome(); 
                }
            }
        }
        return Str;
    }

    public String colocar(String nome){
        String Str;
        SuporteGeral SG;
        Objetos Obj;

        SG = this.procurarObjeto(nome);
        if(SG == null){
            Str = "VOCE NAO POSSUI " + nome; 
        } else{
            Obj = SG.getObjetos();
            moverObjeto(Obj, SG.getSuporte(), this.getLocal());
            Str = "VOCE SOLTOU " + nome; 
        }
        return Str;
    }

    /*public Boolean consultaSaida(){
        Sala sala = getLocal();
        Porta porta = sala.getPorta();
        return porta.isSaida();
    }*/

    public Boolean moverPara(Direcao Dir){
        Sala saida, sala = getLocal();
        Boolean Mov = false;
        Porta porta = sala.getPorta();
        switch(Dir){
            case NORTE:{
                if(porta.isSaida()){
                    porta = sala.getPorta2();
                    if(!porta.isTrancada()){
                        saida = sala.getW();
                    } else{
                        saida = null;
                        System.out.println(porta.toString());
                    }
                } else{
                    if(!porta.isTrancada()){
                        saida = sala.getW();
                    } else{
                        saida = null;
                        System.out.println(porta.toString());
                    }
                }
                break;
            }
            case SUL:{
                if(porta.isSaida()){
                    porta = sala.getPorta2();
                    if(!porta.isTrancada()){
                        saida = sala.getS();
                    } else{
                        saida = null;
                        System.out.println(porta.toString());
                    }
                } else{
                    if(!porta.isTrancada()){
                        saida = sala.getS();
                    } else{
                        saida = null;
                        System.out.println(porta.toString());
                    }
                }
               break;
            }
            case LESTE:{
                if(porta.isSaida()){
                    porta = sala.getPorta2();
                    if(!porta.isTrancada()){
                        saida = sala.getD();
                    } else{
                        saida = null;
                        System.out.println(porta.toString());
                    }
                } else{
                    if(!porta.isTrancada()){
                        saida = sala.getD();
                    } else{
                        saida = null;
                        System.out.println(porta.toString());
                    }
                }
                break;
            }
            case OESTE:{
                if(porta.isSaida()){
                    porta = sala.getPorta2();
                    if(!porta.isTrancada()){
                        saida = sala.getA();
                    } else{
                        saida = null;
                        System.out.println(porta.toString());
                    }
                } else{
                    if(!porta.isTrancada()){
                        saida = sala.getA();
                    } else{
                        saida = null;
                        System.out.println(porta.toString());
                    }
                }
                break;
            }
            case CIMA:{
              
                saida = sala.getCima();
                break;
            }
            case BAIXO:{
                saida = sala.getBaixo();
                break;
            }
            default:{
                saida = null;
                break;
            }
        }
        if(saida != null){
            setLocal(saida);
            Mov = true;
        }
        return Mov;
    }
}
