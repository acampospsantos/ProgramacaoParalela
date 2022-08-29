package Atv3.UDP;

import java.io.*;
import java.net.*;

class UDPClient {
  public static void main(String args[]) throws Exception {

     BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); // Cria stream de entrada

     DatagramSocket clientSocket = new DatagramSocket(); //Cria socket cliente

     String servidor = "localhost";
     int porta = 9876;

     InetAddress IPAddress = InetAddress.getByName(servidor); //Translada nome do host para endereço IP usando DNS

     byte[] sendData = new byte[1024];
     byte[] receiveData = new byte[1024];

     System.out.print("Digite o texto a ser enviado ao servidor: ");
     String sentence = inFromUser.readLine();
     sendData = sentence.getBytes();
     DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, porta); //Cria datagrama com dados a enviar, tamanho, endereço IP, porta

     System.out.println("Enviando pacote UDP para " + servidor + ": " + porta);
     clientSocket.send(sendPacket); //Envia datagrama para servidor

     DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

     clientSocket.receive(receivePacket); //Lê datagrama do servidor
     System.out.println("Pacote UDP recebido...");

     String modifiedSentence = new String(receivePacket.getData());

     System.out.println("Texto recebido do servidor: " + modifiedSentence);
     clientSocket.close();
     System.out.println("Socket cliente fechado!");
  }
}
