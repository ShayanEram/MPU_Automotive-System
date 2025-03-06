import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ConnectedCarApp implements Runnable {
    @Override
    public void run() {
        contactServer("remoteStart");
        contactServer("lockUnlockDoors");
        contactServer("vehicleStatus");
    }

    public void contactServer(String command)
    {
        try(Socket socket = new Socket("localhost", 12345))
        {
            OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send command to the server
            output.write(command + "\n");
            output.flush();

            // Receive response from the server
            String response = input.readLine();
            System.out.println("Received from server: " + response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
