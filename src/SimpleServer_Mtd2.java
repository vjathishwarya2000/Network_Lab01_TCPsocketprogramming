import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.io.DataOutputStream;


public class SimpleServer_Mtd2 {
    public static void main(String[] args) {
        try {
            System.out.println("1. Before creating the server socket");
            ServerSocket serverSocket = new ServerSocket(50001);
            System.out.println("2. After creating the server socket");

            for(;;) {
                System.out.println("3. Before accept the client");
                Socket client = serverSocket.accept();
                System.out.println("4. After accept client");

                RequestProcessorThread processorThread = new RequestProcessorThread(client);

                System.out.println("About to start a new thread");
                Thread t = new Thread(processorThread);
                t.start();
                System.out.println("After starting a new thread");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

