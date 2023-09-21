package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class SimpleDaytimeServer {
    public static void main(String args[]) throws java.io.IOException {
        try {
            ServerSocket server = new ServerSocket(13);
            int i = 1;
            while (true) {
                Socket client = server.accept();
                System.out.println("accept : " + i);
                String date = new Date().toString();
                DataOutputStream os = new DataOutputStream(client.getOutputStream());
                os.writeBytes(date+"\n\n");
                client.close();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
