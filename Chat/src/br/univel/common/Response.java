/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univel.common;

import java.io.Serializable;

/**
 * @since Mar 4, 2016 12:11:39 AM
 * @author Juliano Montezano Grams <julianograms@gmail.com>
 */
public class Response implements Serializable{
    
    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public Response(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    
    

}
