package br.univel.server;

import br.univel.common.ChatClient;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.univel.common.ChatServer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Server implements ChatServer {

    final private Map<String, ChatClient> usuarios = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Iniciando o server...");

        Server s = new Server();
        ChatServer servico;
        try {
            servico = (ChatServer) UnicastRemoteObject.exportObject(s, 0);
            Registry registry = LocateRegistry.createRegistry(1818);
            registry.rebind(ChatServer.NOME, servico);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registrar(String nome, ChatClient client) throws RemoteException {
        if (usuarios.containsKey(nome)) {
            throw new RemoteException("O nome " + nome + " já está sendo utilizado!");
        } else {
            usuarios.put(nome, client);
            for (Entry<String, ChatClient> e : usuarios.entrySet()) {
                e.getValue().notificarEntrada(nome + " conectou");
            }
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
    public void enviarMsgPrivada(String from, String to, String msg) throws RemoteException {
        if (usuarios.containsKey(to)) {
            usuarios.get(to).receberMsgPrivada(from, msg);
        } else {
            throw new RemoteException("O cliente " + to + " não existe");
        }
    }

    @Override
    public void enviarMsgPublica(String from, String msg) throws RemoteException {
        for (Entry<String, ChatClient> e : usuarios.entrySet()) {
            if (!e.getKey().equals(from)) {
                e.getValue().receberMsgPublica(from, msg);
            }
        }
    }
}
