package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    static Jogo jogo
    public static void main(String[] args) throws Exception {

        BufferedReader in;
        String ent;
        String exit;

        in = new BufferedReader(new InputStreamReader(System.in));
        jogo.printIntroducao();

        do{
            System.out.print("Comando: ");
            ent = in.readLine();
            switch(ent) {
                case "carregar":{
                    carregaJogo();
                    break;
                }
                case "salvar": {
                    salvarJogo();
                    break;
                }
                default: {
                    exit = jogo.comando(ent);
                    break;
                }
            }
            if(!exit.trim().isEmpty()){
                jogo.print(exit);
            }
        } while(!"sair".equals(ent));
        
    }
}
