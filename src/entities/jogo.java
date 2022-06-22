package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class jogo implements Serializable{

    private ArrayList<Sala> mapa;
    private personagem Jogador;

    public jogo(){
        Parser.iniciar();
        iniciaJogo();
    }

    private void iniciaJogo(){
        this.mapa = ArrayList<Sala>();

        Objetos salaDeTrolls = new Objetos(nome: "salaDeTrolls");
        Objetos floresta = new Objetos(nome: "floresta");
        Objetos caverna = new Objetos(nome: "caverna");
        Objetos perigo = new Objetos(nome: "perigo");
        Objetos jogador = new Objetos(nome: "jogador");

        Sala salaDeTrolls = new Sala();
        Sala floresta = new Sala();
        Sala caverna = new Sala();
        Sala perigo = new Sala();
        Sala perigo = new Sala();

        salaDeTrolls.add()
    }
    
}
