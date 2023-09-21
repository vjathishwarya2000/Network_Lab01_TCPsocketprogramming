package com.company;    // Client Side

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class ClientSocket {
    public static void getAddressDetails(InetAddress address) {
        System.out.println(address.getHostName() + " - " + address.getHostAddress());
    }
    public void connect(InetAddress host, int serverPort) {
        try {
            System.out.println("Connecting to server on port " + serverPort);
            Socket socket = new Socket(host, serverPort);
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            PrintWriter toServer =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader fromServer =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            toServer.println("Hello from " + socket.getLocalSocketAddress());
            String line = fromServer.readLine();
            System.out.println("Client received: " + line + " from Server");
            toServer.close();
            fromServer.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        ClientSocket client = new ClientSocket();
        InetAddress host = InetAddress.getByName("localhost");
        // TODO : run each method seperately

        //client.connect(host, 7);
        client.connect(host, 13);
        getAddressDetails(host);
    }
}