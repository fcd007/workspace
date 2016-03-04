package br.univel.client;

import br.univel.common.ChatClient;
import br.univel.server.Server;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client implements ChatClient {

    public static void main(String[] args) {

        System.out.println("Iniciando o cliente...");

        Server s = new Server();
        ChatClient servico;
        try {
            servico = (ChatClient) UnicastRemoteObject.exportObject(s, 0);
            Registry registry = LocateRegistry.createRegistry(1818);
            registry.rebind(ChatClient.NOME, servico);
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
    public void receberMsgPrivada(String from, String msg) throws RemoteException {
        System.out.println("Mensagem privada de " + from + "\n" + msg + "\n");
    }

    @Override
    public void receberMsgPublica(String from, String msg) throws RemoteException {
        System.out.println("Mensagem publica de " + from + "\n" + msg + "\n");
    }

    @Override
    public void notificarEntrada(String nome) throws RemoteException {
        System.out.println(nome + "\n");
    }

    @Override
    public void notificarSaida(String nome) throws RemoteException {
        System.out.println(nome + "\n");
    }
    
    //public Client

}
