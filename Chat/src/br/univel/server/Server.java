package br.univel.server;

import br.univel.Test;
import br.univel.common.ChatClient;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.univel.common.ChatServer;
import br.univel.common.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements ChatServer {

    final private Map<String, ChatClient> usuarios = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Iniciando o server...");

        Scanner scanner = new Scanner(System.in);

        Server s = new Server();
        ChatServer servico;
        try {
            servico = (ChatServer) UnicastRemoteObject.exportObject(s, 0);
            Registry registry = LocateRegistry.createRegistry(1818);
            registry.rebind(ChatServer.SERVICO, servico);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        while(true){
            for(String key : s.usuarios.keySet()){
                ChatClient chatClient = s.usuarios.get(key);
                try {
                    chatClient.checkConnection();
                } catch (RemoteException ex) {
                    s.usuarios.remove(key);
                    System.out.println(key+" timed out.");
                }
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    public Response registrar(String nome, ChatClient client) throws RemoteException {
        if (usuarios.containsKey(nome)) {
            return new Response(false, "O nome " + nome + " já está sendo utilizado!");
        } else {
            System.out.println(nome + " Se registrou.");
            usuarios.put(nome, client);
            for (Entry<String, ChatClient> e : usuarios.entrySet()) {
                e.getValue().notificarEntrada(nome + " conectou");
            }
            return new Response(true, "Voce se registrou");
        }
    }

    @Override
    public void logoff(String nome) throws RemoteException {
        usuarios.remove(nome);
        for (Entry<String, ChatClient> e : usuarios.entrySet()) {
            e.getValue().notificarSaida(nome + " desconectou");
        }

    }

    @Override
    public Response enviarMsgPrivada(String from, String to, String msg) throws RemoteException {
        System.out.println(from + " esta enviando uma mensagem privada para " + to);
        if (usuarios.containsKey(to)) {
            usuarios.get(to).receberMsgPrivada(from, msg);
            return new Response(true, "");
        } else {
            return new Response(false, "O cliente " + to + " não existe");
        }
    }

    @Override
    public Response enviarMsgPublica(String from, String msg) throws RemoteException {
        for (Entry<String, ChatClient> e : usuarios.entrySet()) {
            if (!e.getKey().equals(from)) {
                e.getValue().receberMsgPublica(from, msg);
            }
        }
        return new Response(true, "");
    }
}
