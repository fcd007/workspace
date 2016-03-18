package br.univel.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.univel.common.ExecutorRMI;
import java.util.List;

public class ClientExecutor {

    protected ExecutorRMI servico;

    public ClientExecutor() {

        Registry registry;
        try {
            registry = LocateRegistry
                    .getRegistry("127.0.0.1", 1818);
            servico = (ExecutorRMI) registry
                    .lookup(ExecutorRMI.NOME);

            Integer[] res = servico.executar(new TarefaIMP(), 10);

            for (int i = 0; i < res.length; i++) {
                System.out.println(res[i]);
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ClientExecutor();
    }
}
