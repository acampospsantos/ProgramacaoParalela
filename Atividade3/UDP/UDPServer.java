package Atv3.UDP;

import java.io.*;
import java.net.*;

public class UDPServer {

    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876); //Cria socket datagrama na porta 9876

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); //Cria espaço para datagramas recebidos 
            
            serverSocket.receive(receivePacket); //Recebe datagrama

            String sentence = new String(receivePacket.getData()); 

            InetAddress IPAddress = receivePacket.getAddress(); //Obtém endereço IP do transmissor

            int port = receivePacket.getPort(); //Obtém número da porta do transmissor

            String capitalizedSentence = sentence.toUpperCase();

            sendData = capitalizedSentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port); //Cria datagrama para enviar ao cliente

            serverSocket.send(sendPacket); //Escreve o datagrama para dentro do socket
        } 
        //Termina o while loop, retorna e espera por outro datagrama
    }

}
