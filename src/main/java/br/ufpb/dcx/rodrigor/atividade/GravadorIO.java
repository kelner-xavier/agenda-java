package br.ufpb.dcx.rodrigor.atividade;

import java.io.*;
import java.util.HashMap;

public class GravadorIO {
    private String localFile = "agenda-vrau" + File.separator + "agenda.txt";
    public void gravarAgenda(HashMap<String, Contato> contato) throws IOException {
    ObjectOutputStream gravandoDados = null;
		try {
            gravandoDados = new ObjectOutputStream(new FileOutputStream(localFile));
            if(contato!=null) {
                gravandoDados.writeObject(contato);
                gravandoDados.close();
                System.out.printf("gravado ");
            }
        } catch (IOException erro) {
            throw erro;

        } finally {
            if (gravandoDados != null) {
                gravandoDados.close();
            }
        }
    }

    public HashMap<String, Contato> lerArquivo() throws IOException, ClassNotFoundException {
        ObjectInputStream objInput = null;
        HashMap<String, Contato> lista;

        try {
            objInput = new ObjectInputStream(new FileInputStream(localFile));
            Object listaContatos = objInput.readObject();
            lista = (HashMap<String, Contato>) listaContatos;
            System.out.printf("Arquivo lido");
            return lista;

        } catch (IOException | ClassNotFoundException erro1) {
            throw erro1;

        }finally {
            if(objInput!=null){
                objInput.close();
            }
        }
    }

}
