package Atv3.UDP;

import java.io.*;
import java.net.*;

public class UDPClient {

    public static void main(String args[]) throws Exception {

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); // Cria stream de entrada

        DatagramSocket clientSocket = new DatagramSocket(); //Cria socket cliente

        InetAddress IPAddress = InetAddress.getByName("hostname"); //Translada nome do host para endereço IP usando DNS

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        String sentence = inFromUser.readLine();

        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); //Cria datagrama com dados a enviar, tamanho, endereço IP, porta

        clientSocket.send(sendPacket); //Envia datagrama para servidor

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 

        clientSocket.receive(receivePacket); //Lê datagrama do servidor

        String modifiedSentence = new String(receivePacket.getData());

        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }

}
