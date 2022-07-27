package entities;

import java.io.Serializable;
import java.util.*;

import geral.Direcao;
import objetos.Personagem;
import objetos.Porta;
import objetos.Sala;
import objetos.Recipiente;
import objetos.ListaDeObjetos;
import objetos.Objetos;
import objetos.Tesouro;
import objetos.Troll;

public class Jogo implements Serializable{

    private ArrayList<Sala> mapa;
    private Personagem Jogador;
    objetos.Troll Troll;

    public Jogo(){
        Organizador.inicializarVocabulario();
        iniciaJogo();
    }

    private void iniciaJogo(){
        this.mapa = new ArrayList<Sala>();

        ListaDeObjetos ListaVazia = new ListaDeObjetos("sala");
        ListaDeObjetos ListaDeSalas = new ListaDeObjetos("salaDeTrolls");
        ListaDeObjetos ListaDeTesouro = new ListaDeObjetos("salaDeTesouro");
        ListaDeObjetos ListaDeChaves = new ListaDeObjetos("salaDasChaves");
        ListaDeObjetos ListaDeFlorestas = new ListaDeObjetos("floresta");
        ListaDeObjetos ListaDeCabanas = new ListaDeObjetos("cabanas");
        ListaDeObjetos ListaDeCavernas = new ListaDeObjetos("cavernas");
        ListaDeObjetos ListaDeJogadores = new ListaDeObjetos("jogador");
        ListaDeObjetos ListaDeMonstros = new ListaDeObjetos("monstros");

        Sala inicio = new Sala();
        Sala entrada = new Sala();
        Sala floresta = new Sala();
        Sala floresta2 = new Sala();
        Sala floresta3 = new Sala();
        Sala lago = new Sala();
        Sala caverna = new Sala();
        Sala caverna2 = new Sala();
        Sala caverna3 = new Sala();
        Sala caverna4 = new Sala();
        Sala caverna5 = new Sala();
        Sala caverna6 = new Sala();
        Sala salaChave = new Sala();
        Sala salaDoTesouro = new Sala();
        Sala cabana = new Sala();
        Sala perigo = new Sala();
        Sala salaDeTrolls  = new Sala();
        Sala salaDeTrolls2  = new Sala();
        Sala salaFinal  = new Sala();
        Sala saida  = new Sala();

        ListaDeTesouro.add(new Tesouro("diamantes", "um diamante bruto bem raro", 5, salaDoTesouro));
        ListaDeTesouro.add(new Tesouro("ouro", "uma pepita de ouro 18k", 5, salaDoTesouro));
        ListaDeTesouro.add(new Tesouro("anel", "Esse anel possui grande poder (Mas lembre-se 'Com grandes poderes vem grandes responsabilidades')", 500, perigo));

        ListaDeFlorestas.add(new Objetos("arvore", "é uma arvore bem grande", false, false, floresta));
        
        ListaDeChaves.add(new Objetos("chave", "é uma chave velha e enferrujada", true, true, salaChave));
       
        ListaDeSalas.add(new Recipiente("saco", "é um saco velho", true, true, true, true, new ListaDeObjetos("listaDeSacos"),caverna2));
        ListaDeSalas.add(new Recipiente("tigela", "é uma tigela de porcelana", true, true, false, true, new ListaDeObjetos("listaDeTigelas"),caverna4));
        ListaDeSalas.add(new Recipiente("caixa", "é uma caixa de cartoes", true, true, true, true, new ListaDeObjetos("listaDeCaixas"),caverna6));
        ListaDeSalas.add(new Tesouro("cenoura", "é uma cenoura bem crocante", 1, salaDeTrolls));

        ListaDeCabanas.add(new Tesouro("papel", "Ha uma mensagem escrita no papel, ela diz: 'esse espaco foi deixado em branco intencionalmente'", 1, cabana));
        ListaDeCabanas.add(new Tesouro("lapis", "Este lapis não possui ponta", 1, cabana));
        ListaDeCabanas.add(new Recipiente("mochila", "é uma mochila", true, true, true, true, new ListaDeObjetos("listaDeMochila"),cabana));
        ListaDeCabanas.add(new Objetos("lanterna", "é uma lanterna com pouca bateria", true, true, cabana));
        ListaDeCabanas.add(new Objetos("machado", "é um machado bem afiado", true, true, cabana));
        
        // inicialização de salas
        inicio.iniciar("Inicio", "Aqui é o comeco da sua jornada", null, entrada, null, null, null, null, ListaVazia, new Porta(false, false), new Porta(false, false));
        entrada.iniciar("Preso", "Agora nao tem mais volta, procure a saida", null, caverna, null, floresta, null, null, ListaVazia, new Porta(false, false), new Porta(false, false));
        
        floresta.iniciar("Floresta", "Uma floresta majestosa", null, cabana, entrada, floresta2, null, null, ListaDeFlorestas, new Porta(false, false), new Porta(false, false));
        floresta2.iniciar("Floresta", "Uma floresta majestosa", null, null, floresta, floresta3, null, null, ListaDeFlorestas, new Porta(false, false), new Porta(false, false));
        floresta3.iniciar("Floresta", "Uma floresta majestosa", null, null, floresta2, lago, null, null, ListaDeFlorestas, new Porta(false, false), new Porta(false, false));
        lago.iniciar("Lago", "Fim da linha você chegou a um lago", null, null, floresta3, null, null, null, ListaDeFlorestas, new Porta(false, false), new Porta(false, false));
        cabana.iniciar("Cabana", "Uma velha cabana de madeixa", floresta, null, caverna, null, null, null, ListaDeCabanas, new Porta(false, false), new Porta(false, false));
        
        caverna.iniciar("Caverna", "Uma caverna sombria com paredes cobertas de lodo", entrada, caverna2, null, cabana, null, null, ListaVazia, new Porta(false, false), new Porta(false, false));
        caverna2.iniciar("Caverna", "Uma caverna sombria com paredes cobertas de lodo", caverna, caverna4, null, caverna3, null, null, ListaVazia, new Porta(false, false), new Porta(false, false));
        caverna3.iniciar("Caverna", "Uma caverna sombria com paredes cobertas de lodo", null, null, caverna2, null, null, null, ListaVazia, new Porta(false, false), new Porta(false, false));
        caverna4.iniciar("Caverna", "Uma caverna sombria com paredes cobertas de lodo", caverna2, null, salaDeTrolls, caverna5, null, null, ListaVazia, new Porta(false, false), new Porta(false, false));
        caverna5.iniciar("Caverna", "Uma caverna sombria com paredes cobertas de lodo", null, null, caverna4, caverna6, null, null, ListaVazia, new Porta(false, false), new Porta(false, false));
        caverna6.iniciar("Sala", "Uma caverna sombria com paredes cobertas de lodo", salaChave, salaDeTrolls2, caverna5, null, null, null, ListaVazia, new Porta(false, false), new Porta(false, false));
        
        salaDeTrolls.iniciar("Sala do Troll que protege o tesouro", "Uma caverna fedorenta", null, salaDoTesouro, null, caverna4, null, null, ListaDeCavernas, new Porta(false, false), new Porta(false, false));
        salaDeTrolls2.iniciar("Sala do Troll que protege a saida", "Uma caverna fedorenta", caverna6, salaFinal, null, null, null, null, ListaDeCavernas, new Porta(false, false), new Porta(false, false));

        salaDoTesouro.iniciar("Sala do Tesouro", "Uma sala cheia dos mais belos tesouros", salaDeTrolls, null, null, null, null, null, ListaDeTesouro, new Porta(false, false), new Porta(false, false));
        salaChave.iniciar("Sala da Chave", "Uma caverna sombria com paredes cobertas de lodo", null, caverna6, null, null, null, null, ListaDeChaves, new Porta(false, false), new Porta(false, false));
        
        salaFinal.iniciar("Saida", "Parabens você chegou à saida, tente abria a porta", salaDeTrolls2, saida, null, null, null, null, ListaVazia, new Porta(true, true), new Porta(false, false));
        saida.iniciar("Fim", "Fim de jogo - digite q para sair", null, null, null, null, null, null, ListaDeCavernas, new Porta(true, false), new Porta(false, false));
        
        
        mapa.add(inicio);
        mapa.add(entrada);
        mapa.add(floresta);
        mapa.add(floresta2);
        mapa.add(floresta3);
        mapa.add(lago);
        mapa.add(caverna);
        mapa.add(caverna2);
        mapa.add(caverna3);
        mapa.add(caverna4);
        mapa.add(caverna5);
        mapa.add(caverna6);
        mapa.add(salaChave);
        mapa.add(salaDoTesouro);
        mapa.add(cabana);
        mapa.add(salaDeTrolls);
        mapa.add(salaDeTrolls2);
        mapa.add(salaFinal);
        mapa.add(saida);

        Jogador = new Personagem("Explorador", "Um jogador corajoso", ListaDeJogadores, inicio);
        Troll = new Troll("Shrek", "Um troll asqueroso e nojento", ListaDeMonstros, salaDeTrolls, true, 500);
        Troll = new Troll("Fiona", "Uma troll asquerosa e nojenta", ListaDeMonstros, salaDeTrolls2, true, 500);
        
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
        Str = "\n+-----------------------------------------------------------------------+"
             +"\n| DIGITE: (w, s, a, d, cima, baixo) PARA SE MOVIMENTAR OU (q) PARA SAIR |"
             +"\n+-----------------------------------------------------------------------+\n\n";
        printString(Str);
        olharEmVolta();
    }

    public String comando(String entrada) {
        List<String> listaDePalavras;
        String Str;
        String lowStr;

        Str = "Obrigado por jogar";
        lowStr = entrada.trim().toLowerCase();
        
        if (!lowStr.equals("q")) {
            if (lowStr.equals("")) {
                Str = "Voce precisa digitar um comando";
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
        showTest("pegar cenoura");
        showTest("pegar tigela");
        showTest("pegar saco");
        showTest("pegar caixa");
        showTest("colocar cenoura na tigela");
        showTest("colocar tigela no saco");
        showTest("colocar saco na caixa");
        showTest("colocar caixa na tigela");
        showTest("colocar saco na tigela");
        showTest("colocar cenoura na caixa");
        showTest("i");
        printString("---END TEST---");

    }
    
}
