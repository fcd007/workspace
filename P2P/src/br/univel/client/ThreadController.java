/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.client;

import br.univel.Principal;

/**
 *
 * @author juliano
 */
public class ThreadController {

  private int threadCount;

  public int getThreadCount() {
    return threadCount;
  }

  public void setThreadCount(int threadCount) {
    this.threadCount = threadCount;
  }

  public void addThread() {
    this.threadCount++;
  }

  public void removeThread() {
    if (this.threadCount > 0) {
      this.threadCount--;
    }
  }
  
  public Thread getThread(Principal principal, Runnable runnable){
    return  new Download().start(Principal principal, Runnable runnable);
  }

}
