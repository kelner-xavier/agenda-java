package br.ufpb.dcx.rodrigor.atividade;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) throws IOException {

        Agenda agenda = new Agenda();


        boolean stop = false;
        do {
            try {

                Scanner ler = new Scanner(System.in);


                int opcao;

                System.out.print("****** APS AGENDA *******\n");
                System.out.print("*************************\n");
                System.out.print("**** Menu Principal *****\n");
                System.out.print("[ 1 ] Incluir Contato\n");
                System.out.print("[ 2 ] Excluir Contato\n");
                System.out.print("[ 3 ] Listar Contatos\n");
                System.out.print("[ 0 ] Encerrar o Programa\n");
                System.out.print("\nOpção Desejada: ");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 0:
                        System.out.println("\nAté a Proxima!");
                        System.exit(0);
                    case 1:
                        try {
                            String nome;
                            String telefone;

                            System.out.print("\nInforme o Nome do Contato:\n");
                            nome = ler.nextLine();

                            System.out.print("\nInforme o Telefone do Contato:\n");
                            telefone = ler.nextLine();
                            Contato contato = new Contato(nome, telefone);

                            agenda.cadastrar(contato);
                        } catch (InputMismatchException e) {
                            System.out.print("Digite um Telefone Válido.");
                        } finally {
                            break;
                        }
                    case 2:
                        try {
                            System.out.print("\nInforme a Posição a ser Excluída:\n");
                            String numero = ler.nextLine();
                            agenda.remover(agenda.pesquisarContato(numero));
                            System.out.print("\nContato Excluido com Sucesso!");
                        } catch (InputMismatchException e) {
                            System.out.print("\n Erro: Digite uma Posição Válida.\n\n");
                        } finally {
                            break;
                        }
                    case 3:
                        agenda.listar();
                        break;
                    default:
                        System.out.println("Opção Invalida! Tente Novamente");
                        break;
                }
                System.out.print("\n\n");


            } catch (InputMismatchException e) {
                System.out.println("\nDigite uma opção Válida!\n");
            }

        } while (stop);
    }}

