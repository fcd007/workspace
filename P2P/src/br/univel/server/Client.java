/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.server;

import br.univel.common.ChatClient;
import java.io.File;

/**
 *
 * @author juliano
 */
public class Client {
  private String nome;
  private File[] files;
  private ChatClient chatClient;

  public Client(String nome, File[] files, ChatClient chatClient) {
    this.nome = nome;
    this.files = files;
    this.chatClient = chatClient;
  }

  

  public ChatClient getChatClient() {
    return chatClient;
  }

  public void setChatClient(ChatClient chatClient) {
    this.chatClient = chatClient;
  }
 
  

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public File[] getFiles() {
    return files;
  }

  public void setFiles(File[] files) {
    this.files = files;
  }
}
