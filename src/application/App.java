package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import entities.Jogo;

public class App {

    public static Jogo jogo;
    public static void main(String[] args) throws Exception {

        BufferedReader in;
        String ent;
        String exit = " ";

        jogo = new Jogo();
        in = new BufferedReader(new InputStreamReader(System.in));
        jogo.printIntroducao();

        do{
            System.out.print("-> ");
            ent = in.readLine();
            switch(ent) {
                case "carregar":{
                    //carregaJogo();
                    break;
                }
                case "salvar": {
                    //salvarJogo();
                    break;
                }
                default: {
                    exit = jogo.comando(ent);
                    break;
                }
            }
            if(!exit.trim().isEmpty()){
                jogo.printString(exit);
            }
        } while(!"sair".equals(ent));
        
    }
}
