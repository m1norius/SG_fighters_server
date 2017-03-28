import units.Unit;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by minorius on 28.03.2017.
 */
public class Communicator {

    public static void dataTransfer(Socket socket) throws IOException {

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        try {
            List<Unit> fightersOnArena  = (List<Unit>) inputStream.readObject();
            Arena.combat(fightersOnArena);

            outputStream.writeObject(Arena.winner);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
