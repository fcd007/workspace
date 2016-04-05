package br.univel.server;

import br.univel.common.ChatClient;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.univel.common.ChatServer;
import br.univel.common.Response;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements ChatServer {

  final private Map<String, Client> usuarios = new HashMap<>();

  public static void main(String[] args) {
    System.out.println("Iniciando o server...");

    Server s = new Server();
    ChatServer servico;
    try {
      servico = (ChatServer) UnicastRemoteObject.exportObject(s, 0);
      Registry registry = LocateRegistry.createRegistry(1818);
      registry.rebind(ChatServer.SERVICO, servico);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    List<String> removeList = new LinkedList<>();
    while (true) {

      for (String key : s.usuarios.keySet()) {
        Client client = s.usuarios.get(key);
        try {
          client.getChatClient().checkConnection();
        } catch (RemoteException ex) {
          removeList.add(key);
          System.out.println(key + " timed out.");
        }
      }
      for (String element : removeList) {
        s.usuarios.remove(element);
      }
      removeList.clear();
      try {
        Thread.sleep(3000);
      } catch (InterruptedException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  }

  @Override
  public Response registrar(String nome, ChatClient chatClient, File[] files) throws RemoteException {
    if (usuarios.containsKey(nome)) {
      return new Response(false, "O nome " + nome + " já está sendo utilizado!");
    } else {
      Client client = new Client(nome, files, chatClient);
      System.out.println(nome + " Se registrou.");
      usuarios.put(nome, client);
      for (Entry<String, Client> e : usuarios.entrySet()) {
        e.getValue().getChatClient().notificarEntrada(nome + " conectou");
      }
      return new Response(true, "Voce se registrou");
    }
  }

  @Override
  public void logoff(String nome) throws RemoteException {
    usuarios.remove(nome);
    for (Entry<String, Client> e : usuarios.entrySet()) {
      e.getValue().getChatClient().notificarSaida(nome + " desconectou");
    }
    System.out.println(nome + " desconectou");

  }

  @Override
  public ChatClient download(String fileName, String name) throws RemoteException {
    List<Client> clients = new LinkedList<>();
    usuarios
            .keySet()
            .stream()
            .map(usuarios::get)
            .forEach((c) -> {
      for (File file : c.getFiles()) {
        if (file.getName().equals(fileName)) {
          clients.add(c);
        }
      }
            });
    ChatClient chatClient = clients
            .stream()
            .findFirst()
            .get()
            .getChatClient();
    chatClient.prepareUpload(fileName);
    return chatClient;
  }

}
