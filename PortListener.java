import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by minorius on 28.03.2017.
 */
public class PortListener {

    static void portListenerOn(){

        System.out.println("Start");

        int port = 1702;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting...");

            while(true){

                Socket socket = serverSocket.accept();
                System.out.println("Connecting...");
                Communicator.dataTransfer(socket);

            }
        } catch(Exception x) {
            x.printStackTrace();
        }
        System.out.println("Finish");
    }
}
