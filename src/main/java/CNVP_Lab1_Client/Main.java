package CNVP_Lab1_Client;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        String input = null;
        Socket socketClient = null;
        try {
            try {
                InetAddress ipAddressOfServer = UserInput.getInetAddress();
                while (true) {

                    input = UserInput.readUserInput();
                    if (input.equals("exit")) {
                        break;
                    }
                    try {
                        socketClient = Client.createSocket(ipAddressOfServer);
                        Client.sendReceive(socketClient, input);
                    } catch (ConnectException exception) {
                        System.out.println("Server rejected" + "\n");
                    }
                }
            } finally {
                if (socketClient != null) {
                    socketClient.close();
                    System.out.println("client is closed");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
