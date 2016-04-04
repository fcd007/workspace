/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel;

import br.univel.client.Client;
import java.io.File;
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
      String workingDir = System.getProperty("user.dir");
      System.out.println("Current working directory : " + workingDir);

      File folder = new File(workingDir + "/upload");

      if (folder.exists() && folder.isDirectory()) {
        client.getServico().registrar(user, client, folder.listFiles());
      }else{
        System.out.println("O diretório 'upload' não foi encontrado.");
      }
    } catch (RemoteException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      return;
    }
    String input = "";
    while (!input.equals("exit")) {
      String privateUser = "";
      boolean hasPrivate = false;

      System.out.println(client.getPrefix());
      input = scanner.nextLine();

      for (int i = 0; i < input.length(); i++) {
        char letter = input.charAt(i);
        if (letter == '[' || hasPrivate) {
          if (letter == ']') {
            try {
              client.getServico().enviarMsgPrivada(client.getNome(), privateUser, input.substring(i + 1));
            } catch (RemoteException ex) {
              System.out.println("Mensagem não enviada");
              Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
          }
          if (hasPrivate) {
            privateUser += letter;
          }
          hasPrivate = true;
        }
      }
      if (!hasPrivate) {
        try {
          client.getServico().enviarMsgPublica(client.getNome(), input);
        } catch (RemoteException ex) {
          System.out.println("Mensagem não enviada");
        }
      }
    }

    try {
      client.getServico().logoff(client.getNome());
    } catch (RemoteException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.exit(client.getPort());
  }
}
