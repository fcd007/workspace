/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel;

import static br.univel.Test.scanner;
import br.univel.client.Client;
import br.univel.common.ChatClient;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jmgrams
 */
public class Principal {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        System.out.println("Insira o Nome de usuário");
        String user = scanner.nextLine();
        
        System.out.println("Insira a porta");
        int port = Integer.parseInt(scanner.nextLine());
        Client client = new Client(user, port);
        
        try {
            client.getServico().registrar(user, client);
        } catch (RemoteException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        String input = "";
        do{
            System.out.println(client.getPrefix());
            input = scanner.nextLine();
            try {
                client.getServico().enviarMsgPublica(client.getNome(), input);
            } catch (RemoteException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(input != "exit");
    }
}
