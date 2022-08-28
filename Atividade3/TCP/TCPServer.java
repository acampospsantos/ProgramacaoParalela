package Atv3.TCP;

import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;

        ServerSocket welcomeSocket = new ServerSocket(6789); // Cria socket de aceitação na porta 6789

        while (true) {

            Socket connectionSocket = welcomeSocket.accept(); // Espera, no Socket de aceitação por contato do cliente

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); // Cria stream de entrada, ligado ao Socket

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); //Cria stream de saída, ligado ao socket

            clientSentence = inFromClient.readLine(); //Lê linha do socket

            capitalizedSentence = clientSentence.toUpperCase() + '\n'; 

            outToClient.writeBytes(capitalizedSentence); //Escreve linha para o socket
        }
        //Fim do while loop, retorne e espere por outra conexão do cliente
    } 

}
