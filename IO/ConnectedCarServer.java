package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectedCarServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());

                String command;
                while ((command = input.readLine()) != null) {
                    System.out.println("Received from client: " + command);

                    // Process the command
                    String response;
                    switch (command) {
                        case "remoteStart":
                            response = "Car started remotely.";
                            break;
                        case "lockUnlockDoors":
                            response = "Doors locked/unlocked.";
                            break;
                        case "vehicleStatus":
                            response = "Fuel level: 75%, Battery charge: 80%, Tire pressure: Normal";
                            break;
                        default:
                            response = "Unknown command.";
                    }

                    // Send response to the client
                    output.write(response + "\n");
                    output.flush();
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
