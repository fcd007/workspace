Projeto RMI
---
#### Como executar
> Para executar o projeto corretamente na linha de comando do SO,
> você deve compilar o projeto com a mais class como 'Server.class'
> para executar o servidor, e a 'Principal.class', para executar como cliente.

### Funcionamento
##### Servidor
> Ele possui 4 métodos
> * registrar
>   * Recebe um objeto do tipo ChatClient, e o nome (que é a chave do hashpmap) ,
> registra um usuário em um hashmap e retorna um objeto representando sucesso ou falha.
> * logoff
>   * Remove o usuário do hashmap através da chave (nome)e retorna um objeto representando sucesso ou falha.
> * enviarMsgPrivada
>   * Recebe uma string com a chave (nome) do usuário que irá enviar a mensagem, uma que representa o que vai
> receber a mensagem, e um que é a mensagem. Ele então verifica se o usuário não está 
> enviando a mensagem para ele mesmo, e verifica a conexão com o usuário através do método `checkConnection()`
> Por fim, executa o método `receberMsgPrivada()` do objeto ChatClient recebido.
> * enviarMsgPublica
>   * Recebe uma string com a chave (nome) do usuário que irá enviar a mensagem e uma que é a mensagem.
> verifica se o usuário não está enviando a mensagem para ele mesmo, checa a conexão, e executa o método
> `receberMsgPublica()` do objeto do ChatClient.

##### Cliente
> Possui 5 métodos
> * receberMsgPrivada
>   * Escreve no console quem está enviando a mensagem, e a mensagem.
> * receberMsgPublica
>   * Escreve no console a mensagem.
> * notificarEntrada
>   * Escreve no console o nome de um usuário que acabou de se registrar no servidor.
> * notificarSaida
>   * Escreve no console o nome de um usuário que acabou de fazer logoff no servidor.
> * checkConnection
>   * Retorna true, serve apenas confirmar para o servidor que o usuário ainda está ativo.

#### Utilização
##### Servidor (Server.class)
> Basta executar o .jar na linha de comando, e o servidor
> escreve no console o log das ações dos usuários.

##### Cliente (Principal.class)
> Ao executar, ele pede o seu nome de usuário, e a porta que você quer utilizar.
> Para enviar uma mensagem pública, basta digitar a mensagem e apertar `ENTER`.
> Para enviar uma mensagem privada, você deve digiar o nome do usuário desejado entre colchetes `[nomedousuario]`, e 
> em seguida digitar a mensagem.
> Para fazer logoff basta escrever `exit`.
