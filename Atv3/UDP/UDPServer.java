package Atv3.UDP;

import java.io.*;
import java.net.*;

class UDPServer {
  public static void main(String args[]) throws Exception {

     int porta = 9876;
     int numConn = 1;
    
     DatagramSocket serverSocket = new DatagramSocket(porta); //Cria socket datagrama na porta 9876

     byte[] receiveData = new byte[1024];
     byte[] sendData = new byte[1024];

     while (true) {

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); //Cria espaço para datagramas recebidos
        System.out.println("Esperando por datagrama UDP na porta " + porta);
        serverSocket.receive(receivePacket); //Recebe datagrama
        System.out.print("Datagrama UDP [" + numConn + "] recebido...");

        String sentence = new String(receivePacket.getData());
        System.out.println(sentence);
       
        InetAddress IPAddress = receivePacket.getAddress(); //Obtém endereço IP do transmissor

        int port = receivePacket.getPort(); //Obtém número da porta do transmissor

        String capitalizedSentence = sentence.toUpperCase();

        sendData = capitalizedSentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); //Cria datagrama para enviar ao cliente
       
        System.out.print("Enviando " + capitalizedSentence + "...");

        serverSocket.send(sendPacket); //Escreve o datagrama para dentro do socket
        System.out.println("OK\n");
     }
       //Termina o while loop, retorna e espera por outro datagrama
  }
}

