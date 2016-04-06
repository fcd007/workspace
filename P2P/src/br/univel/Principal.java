/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel;

import br.univel.client.Client;
import br.univel.client.DownloadManager;
import br.univel.common.ChatClient;
import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

    register(client);

//    while (!input.equals("exit")) {
    String input = scanner.nextLine();

    String fileName = "eclipse-jee-mars-2-win32-x86_64.zip";

    try {
      final List<ChatClient> chatClients = client.getServico().download(fileName, client.getNome());
      final ExecutorService executor = Executors.newFixedThreadPool(chatClients.size());
      final int byteLength = chatClients.get(0).getFileLength(fileName);
      final DownloadManager downloadManager = new DownloadManager(byteLength, client, chatClients);

      byte[] byteArray = new byte[byteLength];
      boolean finished = false;
      

      FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir") + "\\download\\" + fileName));
      fos.write(byteArray);
    } catch (RemoteException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
//    }

    try {
      client.getServico().logoff(client.getNome());
    } catch (RemoteException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.exit(client.getPort());
  }

  public static void register(Client client) {

    try {
      String workingDir = System.getProperty("user.dir");
      File folder = new File(workingDir + "\\upload");

      if (folder.exists() && folder.isDirectory()) {
        client.getServico().registrar(client.getNome(), client, folder.listFiles());
      } else {
        System.out.println("O diretório 'upload' não foi encontrado.");
      }
    } catch (RemoteException ex) {
      Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      return;
    }
  }
}
