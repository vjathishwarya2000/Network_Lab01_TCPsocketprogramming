package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;

public class StudentMarksEchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(clientSocket.getInputStream()));
            HashMap<Integer, Integer> studentMarks = new HashMap<>();
            Random r = new Random();
            for (int i = 0; i < 5; i++) {
                studentMarks.put(100 + i, r.nextInt(79) + 20);
            }
            String inputLine;
            while (true) {
                out.println("Student index number range => 100-104");
                out.println("Enter the Student Index Number to get marks");
                inputLine = in.readLine();
                if (inputLine.equalsIgnoreCase("terminate")) {
                    out.println("Server is closed! See you again. Bye!");
                    break;
                }
                try {
                    int h = Integer.parseInt(inputLine);
                    if (h > 104 || h < 100) {
                        out.println("Invalid student index number, check and try again! \n");
                        continue;

                    }

                } catch (Exception e) {
                    out.println(e.getMessage());
                    out.println("Invalid student index number, check and try again! \n");
                    continue;
                }
                out.print("Marks corresponding to the index number: \"" + inputLine + "\" is ");
                out.println(studentMarks.get(Integer.parseInt(inputLine)));
                out.println();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


