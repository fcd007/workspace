/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.common;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jmgrams
 */
public interface ChatServer extends Remote {

    final public String SERVICO = "ChatServer";

    public Response registrar(String nome, ChatClient client, File[] files) throws RemoteException;

    public void logoff(String nome) throws RemoteException;

    public Response enviarMsgPrivada(String from, String to, String msg) throws RemoteException;

    public Response enviarMsgPublica(String from, String msg) throws RemoteException;
    
}
