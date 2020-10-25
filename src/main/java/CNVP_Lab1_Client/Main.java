package CNVP_Lab1_Client;

import java.io.IOException;
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
                    socketClient = Client.createSocket(ipAddressOfServer);
                    Client.sendReceive(socketClient, input);
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
