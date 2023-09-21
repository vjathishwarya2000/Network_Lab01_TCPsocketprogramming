import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

public class RequestProcessorThread implements Runnable{

    private Socket client = null;

    // New Constructor
    public RequestProcessorThread(Socket client){
        this.client = client;
    }

    @Override
    public void run(){
        System.out.println("5. Before writing data to client");
        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());

        Date today = new Date();
        dataOutputStream.writeBytes(today.toString());
        System.out.println("6. After writing data to client");

        InputStream is = client.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader());
        String ReceivedData = br.readLine();
        System.out.println("7. Received from Client: " + ReceivedData);

        System.out.println("8. Before closing connection to client");
        client.close();
        System.out.println("9. After closing connection to client");
    }
}
