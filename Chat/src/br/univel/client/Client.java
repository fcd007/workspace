package br.univel.client;

import br.univel.common.ChatClient;
import br.univel.common.ChatServer;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client implements ChatClient {

    private String nome;
    private int port;

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
    public void receberMsgPrivada(String from, String msg) throws RemoteException {
        System.out.println("\n Mensagem privada de " + from + "\n" + msg + "\n"+getPrefix());
    }

    @Override
    public void receberMsgPublica(String from, String msg) throws RemoteException {
        System.out.println("\n[" + from + "]: " + msg + "\n"+getPrefix());
    }

    @Override
    public void notificarEntrada(String msg) throws RemoteException {
        System.out.println("\n"+msg + "\n"+getPrefix());
    }

    @Override
    public void notificarSaida(String msg) throws RemoteException {
        System.out.println("\n"+msg + "\n"+getPrefix());
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
    
    public String getPrefix(){
        return "["+this.nome+"]: ";
    }

}
