package entities;

import geral.Palavras;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.App;

public class Organizador {

    static HashMap<String, Palavras> vocabulario = new HashMap<>();

    static void inicializarVocabulario(){
        vocabulario.put("pelota", Palavras.SUBSTANTIVO);
        vocabulario.put("cama", Palavras.SUBSTANTIVO);
        vocabulario.put("osso", Palavras.SUBSTANTIVO);
        vocabulario.put("tigela", Palavras.SUBSTANTIVO);
        vocabulario.put("caixa", Palavras.SUBSTANTIVO);
        vocabulario.put("botao", Palavras.SUBSTANTIVO);
        vocabulario.put("fruta", Palavras.SUBSTANTIVO);
        vocabulario.put("peito", Palavras.SUBSTANTIVO);
        vocabulario.put("moeda", Palavras.SUBSTANTIVO);
        vocabulario.put("porta", Palavras.SUBSTANTIVO);
        vocabulario.put("poeira", Palavras.SUBSTANTIVO);
        vocabulario.put("flor", Palavras.SUBSTANTIVO);
        vocabulario.put("chave", Palavras.SUBSTANTIVO);
        vocabulario.put("faca", Palavras.SUBSTANTIVO);
        vocabulario.put("lampada", Palavras.SUBSTANTIVO);
        vocabulario.put("folha", Palavras.SUBSTANTIVO);
        vocabulario.put("alavanca", Palavras.SUBSTANTIVO);
        vocabulario.put("papel", Palavras.SUBSTANTIVO);
        vocabulario.put("lapis", Palavras.SUBSTANTIVO);
        vocabulario.put("saco", Palavras.SUBSTANTIVO);
        vocabulario.put("salsicha", Palavras.SUBSTANTIVO);
        vocabulario.put("sinal", Palavras.SUBSTANTIVO);
        vocabulario.put("fresta", Palavras.SUBSTANTIVO);
        vocabulario.put("esquilo", Palavras.SUBSTANTIVO);
        vocabulario.put("arvore", Palavras.SUBSTANTIVO);
        vocabulario.put("capivara", Palavras.SUBSTANTIVO);
        vocabulario.put("teste", Palavras.VERBO);
        vocabulario.put("obter", Palavras.VERBO);
        vocabulario.put("i", Palavras.VERBO);
        vocabulario.put("inventario", Palavras.VERBO);
        vocabulario.put("pegar", Palavras.VERBO);
        vocabulario.put("soltar", Palavras.VERBO);
        vocabulario.put("colocar", Palavras.VERBO);
        vocabulario.put("l", Palavras.VERBO);
        vocabulario.put("olhar", Palavras.VERBO);
        vocabulario.put("abrir", Palavras.VERBO);
        vocabulario.put("fechar", Palavras.VERBO);
        vocabulario.put("puxar", Palavras.VERBO);
        vocabulario.put("w", Palavras.VERBO);
        vocabulario.put("s", Palavras.VERBO);
        vocabulario.put("d", Palavras.VERBO);
        vocabulario.put("a", Palavras.VERBO);
        vocabulario.put("cima", Palavras.VERBO);
        vocabulario.put("baixo", Palavras.VERBO);
        vocabulario.put("q", Palavras.VERBO);
        vocabulario.put("sair", Palavras.VERBO);
        vocabulario.put("A", Palavras.ARTIGO);
        vocabulario.put("um", Palavras.ARTIGO);
        vocabulario.put("o", Palavras.ARTIGO);
        vocabulario.put("dentro", Palavras.PREPOSICAO);
        vocabulario.put("em", Palavras.PREPOSICAO);
        vocabulario.put("no", Palavras.PREPOSICAO);        
    }

    static String processamentoDePalavras(List<TiposDePalavras> comando){
        TiposDePalavras palavra1 = comando.get(0);
        TiposDePalavras palavra2 = comando.get(1);
        TiposDePalavras palavra3 = comando.get(2);
        TiposDePalavras palavra4 = comando.get(3);
        String mensagem = "";

        if((palavra1.getTipoDePalavra() != Palavras.VERBO) || (palavra3.getTipoDePalavra() != Palavras.PREPOSICAO)){
            mensagem = "NAO POSSO FAZER ISSO PORQUE NÃO ENTENDO '" + palavra1.getPalavra() + " ALGO " + palavra3.getPalavra() + "' ALGO!";
        } else if(palavra2.getTipoDePalavra() != Palavras.SUBSTANTIVO){
            mensagem = "NAO POSSO FAZER ISSO PORQUE '" + palavra2.getPalavra() + "' NÃO É UM OBJETO!";
        } else if(palavra4.getTipoDePalavra() != Palavras.SUBSTANTIVO){
            mensagem = "NAO POSSO FAZER ISSO PORQUE '" + palavra4.getPalavra() + "' NÃO É UM OBJETO!";
        } else{
            switch (palavra1.getPalavra() + palavra3.getPalavra()){
                case "colocar":{
                    mensagem = App.jogo.colocarNaBolsa(palavra2.getPalavra(), palavra4.getPalavra());
                    break;
                }
                default:{
                    mensagem = "NAO SEI COMO " + palavra1.getPalavra() + " " + palavra2.getPalavra() + " " + palavra3.getPalavra() + " " + palavra4.getPalavra() + "!";
                    break;
                }
            }
        }
        return mensagem;
    }

    static String processamentoDePalavras2(List<TiposDePalavras> comando){
        TiposDePalavras palavra1 = comando.get(0);
        TiposDePalavras palavra2 = comando.get(1);
        TiposDePalavras palavra3 = comando.get(2);
        String mensagem = "";

        if((palavra1.getTipoDePalavra() != Palavras.VERBO) || (palavra2.getTipoDePalavra() != Palavras.PREPOSICAO)){
            mensagem = "NAO POSSO FAZER ISSO PORQUE NÃO ENTENDO '" + palavra1.getPalavra() + " " + palavra3.getPalavra() + "' !";
        } else if(palavra3.getTipoDePalavra() != Palavras.SUBSTANTIVO){
            mensagem = "NAO POSSO FAZER ISSO PORQUE '" + palavra3.getPalavra() + "' NÃO É UM OBJETO!";
        } else{
            switch (palavra1.getPalavra() + palavra2.getPalavra()){
                case "olhar para":{
                    mensagem = App.jogo.olharParaAlgo(palavra3.getPalavra());
                    break;
                }
                case "olhar dentro":{
                    mensagem = App.jogo.olharDentroDeAlgo(palavra3.getPalavra());
                    break;
                }
                default:{
                    mensagem = "NAO SEI COMO " + palavra1.getPalavra() + " " + palavra2.getPalavra() + " " + palavra3.getPalavra() + "!";
                    break;
                }
            }
        }
        return mensagem;
    }

    static String processamentoDePalavras3(List<TiposDePalavras> comando){
        TiposDePalavras palavra1 = comando.get(0);
        TiposDePalavras palavra2 = comando.get(1);
        String mensagem = "";

        if(palavra1.getTipoDePalavra() != Palavras.VERBO){
            mensagem = "NAO POSSO FAZER ISSO PORQUE '" + palavra1.getPalavra() + "' NAO EH UM COMANDO!";
        } else if(palavra2.getTipoDePalavra() != Palavras.SUBSTANTIVO){
            mensagem = "NAO POSSO FAZER ISSO PORQUE '" + palavra2.getPalavra() + "' NÃO É UM OBJETO!";
        } else{
            switch (palavra1.getPalavra()){
                case "apanhar":
                case "pegar":{
                    mensagem = App.jogo.pegarObjeto(palavra2.getPalavra());
                    break;
                }
                case "soltar":
                case "colocar":{
                    mensagem = App.jogo.colocarObjeto(palavra2.getPalavra());
                    break;
                }
                case "abrir":{
                    mensagem = App.jogo.abrirAlgo(palavra2.getPalavra());
                    break;
                }
                case "fechar":{
                    mensagem = App.jogo.fecharAlgo(palavra2.getPalavra());
                    break;
                }
                default:{
                    mensagem = "NAO SEI COMO FAZER ISSO!";
                    break;
                }
            }
        }
        return mensagem;
    }

    static String processamentoDePalavras4(List<TiposDePalavras> comando){

        TiposDePalavras palavra = comando.get(0);
        String mensagem = "";

        if(palavra.getTipoDePalavra() != Palavras.VERBO){
            mensagem = "NAO POSSO FAZER ISSO PORQUE '" + palavra.getPalavra() + "' NAO EH UM COMANDO!";
        } else{
            switch (palavra.getPalavra()){
                case "w":{
                    App.jogo.vaiParaW();
                    break;
                }
                case "s":{
                    App.jogo.vaiParaS();
                    break;
                }
                case "a":{
                    App.jogo.vaiParaA();
                    break;
                }
                case "d":{
                    App.jogo.vaiParaD();
                    break;
                }
                case "cima":{
                    App.jogo.vaiParaCima();
                    break;
                }
                case "baixo":{
                    App.jogo.vaiParaBaixo();
                    break;
                }
                case "i":
                case "inventario":{
                    App.jogo.mostrarInventario();
                    break;
                }
                case "o":
                case "olhar":{
                    App.jogo.olharEmVolta();
                    break;
                }
                case "teste":{
                    App.jogo.teste();
                    break;
                }
                default:{
                    mensagem = "NAO SEI COMO FAZER ISSO!";
                    break;
                }
            }
        }
        return mensagem;
    }

    static String processamentoDeComando(List<TiposDePalavras> comando) {
        String Str = "";
        
        if (comando.size() == 0) {
            Str = "ENTRE COM UM COMANDO: ";
        } else if (comando.size() > 4) {
            Str = "ERRO - COMANDO LONGO";
        } else {           
            switch (comando.size()) {
                case 1:
                    Str = processamentoDePalavras4(comando);
                    break;
                case 2:
                    Str = processamentoDePalavras3(comando);
                    break;
                case 3:
                    Str = processamentoDePalavras2(comando);
                    break;
                case 4:
                    Str = processamentoDePalavras(comando);
                    break;
                default:
                    Str = "NAO FOI POSSIVEL REALIZAR ESSE COMANDO!";
                    break;
            }
        }
        return Str;
    }

    static String organizadorDeComando(List<String> listaDePalavras) {
        List<TiposDePalavras> comando = new ArrayList<>();
        Palavras tPalavra;
        String msgErro = "";
        String msg;

        for (String Str : listaDePalavras) {
            if (vocabulario.containsKey(Str)) {
                tPalavra = vocabulario.get(Str);
                if (tPalavra == Palavras.ARTIGO) {       // ignore articles             
                } else {
                    comando.add(new TiposDePalavras(Str, tPalavra));
                }
            } else { // if word not found in vocab
                comando.add(new TiposDePalavras(Str, Palavras.ERRO));
                msgErro = "DESCULPE, NAO CONSIGO ENTENDER '" + Str + "'";
            }
        }
        if (!msgErro.isEmpty()) {
            msg = msgErro;
        } else {
            msg = processamentoDeComando(comando);
        }
        return msg;
    }

    static List<String> listaDePalavras(String entrada) {
        String caracter = "[ \t,.:;?!\"']+";
        List<String> listaDePalavras = new ArrayList<>();
        String[] palavra = entrada.split(caracter);

        for (String Str : palavra) {
            listaDePalavras.add(Str);
        }
        return listaDePalavras;
    }
}
