/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jmgrams
 */
public interface ChatServer extends Remote {

    final public String NOME = "ChatServer";

    public void registrar(String nome, ChatClient client) throws RemoteException;

    public void logoff(String nome) throws RemoteException;

    public void enviarMsgPrivada(String from, String to, String msg) throws RemoteException;

    public void enviarMsgPublica(String from, String msg) throws RemoteException;
}
