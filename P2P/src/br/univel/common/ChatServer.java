/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.common;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author jmgrams
 */
public interface ChatServer extends Remote {

    final public String SERVICO = "ChatServer";

    public Response registrar(String nome, ChatClient client, File[] files) throws RemoteException;

    public void logoff(String nome) throws RemoteException;
    
    public List<ChatClient> download(String fileName, String name) throws RemoteException;
    
}
