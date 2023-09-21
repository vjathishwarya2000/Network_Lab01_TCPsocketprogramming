package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (
                ServerSocket serverSocket =
                        new ServerSocket(7);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while (true) {
                out.println("Enter any sentence to check...");
                inputLine = in.readLine();
                out.println("The sentence entered is:  \"" + inputLine + "\"");
                if (inputLine.equalsIgnoreCase("terminate")) {
                    out.println("Server is closed! See you again. Bye!");
                    break;
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}