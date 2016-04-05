package br.univel.client;

import br.univel.common.ChatClient;
import br.univel.common.ChatServer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements ChatClient {

  private String nome;
  private int port;
  String[] filesNames;
  private Map<String, byte[]> uploadStack = new HashMap<>();

  private ChatServer servico;

  public Client(String nome, int port) {
    this.nome = nome;
    this.port = port;
    this.init();
    this.connectToServer();
  }

  public final void init() {

    System.out.println("Iniciando o cliente...");

    ChatClient servico;
    try {
      servico = (ChatClient) UnicastRemoteObject.exportObject(Client.this, 0);
      Registry registry = LocateRegistry.createRegistry(port);
      registry.rebind(ChatClient.SERVICO, servico);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  private void connectToServer() {
    try {
      Registry registry = LocateRegistry.getRegistry("127.0.0.1",
              1818);
      servico = (ChatServer) registry
              .lookup(ChatServer.SERVICO);

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (NotBoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void notificarEntrada(String msg) throws RemoteException {
    System.out.println("\n" + msg + "\n" + getPrefix());
  }

  @Override
  public void notificarSaida(String msg) throws RemoteException {
    System.out.println("\n" + msg + "\n" + getPrefix());
  }

  public ChatServer getServico() {
    return servico;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getNome() {
    return nome;

  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean checkConnection() throws RemoteException {
    return true;
  }

  public String getPrefix() {
    return "[" + this.nome + "]: ";
  }

  @Override
  public void prepareUpload(String fileName) throws RemoteException {
    try {
      File file = new File(System.getProperty("user.dir") + "\\upload\\" + fileName);
      FileInputStream fis = new FileInputStream(file);
      byte[] byteArray = new byte[(int) file.length()];
      fis.read(byteArray);
      uploadStack.put(fileName, byteArray);

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public byte getByte(String fileName, int index) throws RemoteException {
    return uploadStack.get(fileName)[index];
  }

  @Override
  public int getFileLength(String nome) throws RemoteException {
    return uploadStack.get(nome).length;
  }

}
