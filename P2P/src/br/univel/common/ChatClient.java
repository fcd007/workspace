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
    

    public void notificarEntrada(String nome) throws RemoteException;

    public void notificarSaida(String nome) throws RemoteException;
    
    /**
     * Verifica se a conexao esta ativa.
     * @return
     * @throws RemoteException 
     */
    public boolean checkConnection() throws RemoteException;
    
    public void prepareUpload(String name) throws RemoteException;
    
    public byte getByte(String fileName, int index) throws RemoteException;
    
    public int getFileLength(String nome) throws RemoteException;
}
