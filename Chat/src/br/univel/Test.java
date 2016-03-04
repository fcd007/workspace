/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel;

import br.univel.client.Client;
import br.univel.common.ChatClient;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since Mar 3, 2016 11:27:43 PM
 * @author Juliano Montezano Grams <julianograms@gmail.com>
 */
public class Test {

    public static Map<String, Client> usuarios = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String input;

        String menu
                = "1 - Criar Usuario\n"
                + "2 - Enviar Mensagem Privada\n"
                + "3 - Enviar Mensagem Publica\n"
                + "4 - logoff de usuario\n"
                + "exit\n";

        System.out.println(menu);
        do {

            input = scanner.nextLine();

            switch (input) {
                case "1": {
                    Client client = createUsuario();
                    try {
                        System.out.println(client.getServico().registrar(client.getNome(), client).getMsg());
                    } catch (RemoteException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                }
                case "2": {
                    System.out.println("Digite o nome do usuario que voce deseja utilizar: ");
                    String emissor = scanner.nextLine();
                    System.out.println("Digite o nome do usuario que voce deseja enviar a mensagem: ");
                    String receptor = scanner.nextLine();
                    System.out.println("Digite a mensagem: ");
                    String msg = scanner.nextLine();

                    Client client = usuarios.get(emissor);
                    try {
                        System.out.println(client.getServico().enviarMsgPrivada(emissor, receptor, msg).getMsg());
                    } catch (RemoteException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "3": {
                    
                }
                case "4": {

                }
            }

        } while (!input.equals("exit"));
    }

    private static Client createUsuario() {
        System.out.println("Digite o nome do usuario: ");
        String nome = scanner.next();
        System.out.println("Digite a porta: ");
        int port = scanner.nextInt();
        Client client = new Client(nome, port);
        usuarios.put(nome, client);
        return client;
    }

}
