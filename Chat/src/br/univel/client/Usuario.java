/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.client;

import br.univel.common.ChatServer;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author jmgrams
 */
public class Usuario {
    public static void main(String[] args){
                    try {
                        Registry registry = LocateRegistry.getRegistry("127.0.0.1",
                                1818);
                        ChatServer servico = (ChatServer) registry
                                .lookup(ChatServer.NOME);
                        servico.registrar("Juliano Grams", this);
                        System.out.println(retorno);

                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (NotBoundException e) {
                        e.printStackTrace();
                    }
    }
}
