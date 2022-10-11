package br.ufpb.dcx.rodrigor.atividade;

import java.io.IOException;
import java.util.HashMap;

//- Persistência em Banco/Arquivo x
//- Teste
//- Interface Texto x
//- Cadastrar/Listar/Remover x
//- Tratamento de Exceções x

public class Agenda {
    private HashMap<String, Contato> agenda;
    private GravadorIO gravador = new GravadorIO();

    public Agenda() {
        recuperarDados();
    }

    public boolean cadastrar(Contato contato){
        if (agenda.containsKey(contato.getNumero())){
            return false;
        }
        agenda.put(contato.getNumero(), contato);
        return true;
    }
    public void listar(){
        for (Contato contato : agenda.values()) {
            System.out.println(contato.toString());
        }
    }
    public boolean remover(Contato contato){
        if (agenda.containsKey(contato.getNumero())){
            agenda.remove(contato.getNumero());
            return true;
        }
        return false;
    }
    public void gravarDados() {
        try{
            gravador.gravarAgenda(this.agenda);
        }catch(IOException e ){
            System.out.println(e+ "\nNão gravou");
        }
    }

    public void recuperarDados(){
        try{
            this.agenda = gravador.lerArquivo();
        } catch (IOException | ClassNotFoundException e){
            agenda  = new HashMap<String, Contato>();
        }
    }
    public Contato pesquisarContato (String numero){
        return agenda.get(numero);
    }

}
