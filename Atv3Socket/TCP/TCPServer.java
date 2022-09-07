package Atv3Socket.TCP;

import java.io.*;
import java.net.*;

class TCPServer {
   public static void main(String argv[]) throws Exception {
       String clientSentence;
       String capitalizedSentence;

       ServerSocket welcomeSocket = new ServerSocket(6789); //Cria socket de aceitação na porta 6789

       System.out.println("Ponto1");
       Socket connectionSocket = welcomeSocket.accept();// Espera, no Socket de aceitação por contato do cliente

       while (true) {
           System.out.println("Ponto2");
           BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); // Cria stream de entrada, ligado ao Socket
           DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); //Cria stream de saída, ligado ao socket
           System.out.println("Ponto3");
           clientSentence = inFromClient.readLine(); //Cria stream de saída, ligado ao socket
           System.out.println("Ponto4");
           capitalizedSentence = clientSentence.toUpperCase() + '\n';
           outToClient.writeBytes(capitalizedSentence); //Escreve linha para o socket
           // connectionSocket.close();
       }
       //Fim do while loop, retorne e espere por outra conexão do cliente
   }
}

