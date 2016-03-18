/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.client;

import br.univel.common.Tarefa;
import java.io.Serializable;

/**
 *
 * @author jmgrams
 */
public class TarefaIMP implements Tarefa<Integer, Integer[]>, Serializable {

    @Override
    public Integer[] executar(Integer p) {

        Integer[] result = new Integer[p];
        for (int i = 0, before = 0,current = 1; i < p; i++, current += before, before = current-before) {
            result[i] = before;
        }
        return result;
    }

}
