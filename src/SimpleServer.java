import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleServer {
    public static void main(String[] args) {
        try {
            System.out.println("1. Before creating the server socket");
            ServerSocket serverSocket = new ServerSocket(50001);
            System.out.println("2. After creating the server socket");

            System.out.println("3. Before accept the client");
            Socket client = serverSocket.accept();
            System.out.println("4. After accept client");

            System.out.println("5. Before writing data to client");
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            dataOutputStream.writeBytes("hello");
            System.out.println("6. After writing data to client");

            try{
                Thread.sleep(60000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("7. Before closing connection to client");
            client.close();
            System.out.println("8. After closing connection to client");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
