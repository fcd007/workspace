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
public interface ChatClient extends Remote {
    
    final String SERVICO = "ChatClient";
    

    public void receberMsgPrivada(String from, String msg) throws RemoteException;

    public void receberMsgPublica(String from, String msg) throws RemoteException;

    public void notificarEntrada(String nome) throws RemoteException;

    public void notificarSaida(String nome) throws RemoteException;
    
    /**
     * Verifica se a conexao esta ativa.
     * @return
     * @throws RemoteException 
     */
    public boolean checkConnection() throws RemoteException;
}
