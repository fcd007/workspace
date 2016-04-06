/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.client;

import br.univel.common.ChatClient;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author juliano
 */
public class DownloadManager {

  private final Stack<Integer> lostBytes;
  private int byteIndex;
  private int byteLength;
  private final ChatClient receiver;
  private final List<ChatClient> senders;

  public DownloadManager(int byteLength, ChatClient receiver, List<ChatClient> senders) {
    this.lostBytes = new Stack();
    this.byteIndex = 0;
    this.byteLength = byteLength;
    this.receiver = receiver;
    this.senders = senders;
  }

  public int getByteIndex() {
    if (lostBytes.size() > 0) {
      return lostBytes.pop();
    } else {
      return byteIndex++;
    }
  }
  
  public byte[] download(){
    
    return null;
  }

}
