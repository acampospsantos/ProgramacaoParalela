package Atv3.TCP;

import java.io.*;
import java.net.*;

class TCPClient {

   public static void main(String argv[]) throws Exception {
       String sentence;
       String modifiedSentence;

       BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //Cria stream de entrada

       int porta = 6789;
       String servidor = "localhost";

       System.out.println("Conectando ao servidor " + servidor + ": " + porta);

       Socket clientSocket = new Socket(servidor, porta); //Cria socket cliente, conecta ao servidor

       DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); //Cria stream de saída ligado ao socket

       BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //Cria stream de entrada ligado ao socket

       System.out.print("Digite uma mensagem a ser enviada para o servidor: ");
       sentence = inFromUser.readLine();

       outToServer.writeBytes(sentence + '\n'); //Envia linha para o servidor

       modifiedSentence = inFromServer.readLine(); //Lê linha do Servidor

       System.out.println("Recebido do servidor: " + modifiedSentence);

       clientSocket.close();
   }
}
