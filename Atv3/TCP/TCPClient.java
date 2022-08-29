package Atv3.TCP;

import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //Cria stream de entrada

        Socket clientSocket = new Socket("localhost", 6789); //Cria socket cliente, conecta ao servidor

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); // Cria stream de saída ligado ao socket

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //Cria stream de entrada ligado ao socket

        sentence = inFromUser.readLine(); 

        outToServer.writeBytes(sentence + '\n'); //Envia linha para o servidor

        modifiedSentence = inFromServer.readLine(); //Lê linha do Servidor

        System.out.println("FROM SERVER: " + modifiedSentence); //

        clientSocket.close();
    }

}