package entities;

import java.io.Serializable;
import java.util.*;

import geral.Direcao;
import objetos.Personagem;
import objetos.Sala;
import objetos.Bolsa;
import objetos.ListaDeObjetos;
import objetos.Objetos;
import objetos.Ouro;

public class Jogo implements Serializable{

    private ArrayList<Sala> mapa;
    private Personagem Jogador;

    public Jogo(){
        Organizador.inicializarVocabulario();
        iniciaJogo();
    }

    private void iniciaJogo(){
        this.mapa = new ArrayList<Sala>();

        ListaDeObjetos ListaDeSalas = new ListaDeObjetos("salaDeTrolls");
        ListaDeObjetos ListaDeFlorestas = new ListaDeObjetos("floresta");
        ListaDeObjetos ListaDeCavernas = new ListaDeObjetos("caverna");
        ListaDeObjetos ListaDePerigos = new ListaDeObjetos("perigo");
        ListaDeObjetos ListaDeJogadores = new ListaDeObjetos("jogador");

        Sala salaDeTrolls = new Sala();
        Sala floresta = new Sala();
        Sala caverna = new Sala();
        Sala cabana = new Sala();
        Sala perigo = new Sala();

        ListaDeSalas.add(new Ouro("cenoura", "é uma cenoura bem crocante", 1, salaDeTrolls));
        ListaDeSalas.add(new Objetos("arvore", "é uma arvore bem grande", false, false, salaDeTrolls));
        ListaDeSalas.add(new Bolsa("saco", "é um saco velho", true, true, true, true, new ListaDeObjetos("listaDeSacos"),salaDeTrolls));
        ListaDeSalas.add(new Bolsa("tigela", "é uma tigela de porcelana", true, true, false, true, new ListaDeObjetos("listaDeTigelas"),salaDeTrolls));
        ListaDeSalas.add(new Bolsa("caixa", "é uma caixa de cartoes", true, true, true, true, new ListaDeObjetos("listaDeCaixas"),salaDeTrolls));

        ListaDeFlorestas.add(new Ouro("salsicha", " ", 1, floresta));

        ListaDeCavernas.add(new Ouro("pepel", "Ha uma mensagem escrita no papel, ela diz: 'esse espaco foi deixado em branco intencionalmente'", 1, caverna));
        ListaDeCavernas.add(new Ouro("lapis", "Este lapis não possui ponta", 1, caverna));

        ListaDePerigos.add(new Ouro("anel", "Esse anel possui grande poder (Mas lembre-se 'Com grandes poderes vem grandes responsabilidades')", 500, perigo));
        ListaDePerigos.add(new Ouro("capivara", "é uma grande capivara", 700, perigo));

        salaDeTrolls.iniciar("Sala do Troll", "Um quarto bastante umido e fedorento", null, caverna, null, floresta, null, null, ListaDeSalas);
        floresta.iniciar("Floresta", "Uma floresta magestosa", null, null, salaDeTrolls, null, null, null, ListaDeFlorestas);
        caverna.iniciar("Caverna", "Uma caverna sombria com paredes cobertas de lodo", salaDeTrolls, null, null, cabana, null, perigo, ListaDeCavernas);
        cabana.iniciar("Cabana", "Uma velha cabana de madeixa", null, null, caverna, null, null, null, new ListaDeObjetos("listaDeCabanas"));
        perigo.iniciar("Perigo", "Uma cela desagradável e escura", null, null, null, null, caverna, null, new ListaDeObjetos("listaDePerigos"));
        
        mapa.add(salaDeTrolls);
        mapa.add(floresta);
        mapa.add(caverna);
        mapa.add(cabana);
        mapa.add(perigo);

        Jogador = new Personagem("Explorador", "Um jogador corajoso", ListaDeJogadores, salaDeTrolls);
    }

    public String colocarNaBolsa(String nome, String nomeRecipiente) {
        return Jogador.guardar(nome, nomeRecipiente);
    }

    public String abrirAlgo(String nome) {
        return Jogador.abrir(nome);
    }

    public String fecharAlgo(String nome) {
        return Jogador.fechar(nome);
    }

    String pegarObjeto(String nome) {
        return Jogador.pegar(nome);
    }

    String colocarObjeto(String nome) {
        return Jogador.colocar(nome);
    }

    void moverJogador(Direcao Dir) {                
        if (Jogador.moverPara(Dir)) {
            olharEmVolta();            
        } else {
            printString("No Exit!");
        }
    }

    void vaiParaW() {
        moverJogador(Direcao.NORTE);
    }

    void vaiParaS() {
        moverJogador(Direcao.SUL);
    }

    void vaiParaA() {
        moverJogador(Direcao.OESTE);
    }

    void vaiParaD() {
        moverJogador(Direcao.LESTE);
    }

    void vaiParaCima() {
        moverJogador(Direcao.CIMA);
    }

    void vaiParaBaixo() {
        moverJogador(Direcao.BAIXO);
    }

    void olharEmVolta() {
        printString("Voce esta " + Jogador.descricaoLocal());
    }

    public void printString(String Str) {
        if (Str.endsWith("\n")) {
            Str = Str.substring(0, Str.length() - 1);
        }
        if (!Str.isEmpty()) {
            System.out.println(Str);
        }
    }

    void mostrarInventario() {
        printString(Jogador.inventario());
    }

    String olharParaAlgo(String nome) {
        return Jogador.olharPara(nome);
    }

    String olharDentroDeAlgo(String nome) {
        return Jogador.olharDentro(nome);
    }

    public void printIntroducao() {
        String Str;
        Str = "Você caiu em um buraco e chegou a uma caverna\n"
            + "subterrânea que cheira fortemente a troll.\n"
            + "Onde você quer ir?\n"
            + "Digite: w, s, a, d, cima, baixo, para se movimenta\n"
            + "ou q para sair.";
        printString(Str);
        olharEmVolta();
    }

    public String comando(String entrada) {
        List<String> listaDePalavras;
        String Str;
        String lowStr;

        Str = "ok";
        lowStr = entrada.trim().toLowerCase();
        
        if (!lowStr.equals("q")) {
            if (lowStr.equals("")) {
                Str = "You must enter a command";
            } else {
                listaDePalavras = Organizador.listaDePalavras(lowStr);
                Str = Organizador.organizadorDeComando(listaDePalavras);
            }
        }
        return Str;
    }

    // Test..... BEGIN
    void showTest(String Str) {
        printString("-> " + Str);
        printString(comando(Str));
    }

    void teste() {
        // utility method to let me try out bits of code while developing the game            
        printString("---BEGIN TEST---");
        //  showThingsInRoom(); // this works ok when no objects are in containers
        showTest("get carrot");
        showTest("get bowl");
        showTest("get sack");
        showTest("get box");
        showTest("put carrot in bowl");
        showTest("put bowl in sack");
        showTest("put sack in box");
        showTest("put box in bowl");
        showTest("put sack in bowl");
        showTest("put carrot in box");
        showTest("i");
        printString("---END TEST---");

    }
    
}
