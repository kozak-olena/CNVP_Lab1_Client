package CNVP_Lab1_Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    static int port = 5544;

    public static Socket createSocket(InetAddress ipAddressOfServer) throws IOException {

        Socket clientSocket = new Socket(ipAddressOfServer, port);
        if (clientSocket.isConnected()) {
            System.out.println("Connected to server"+"\n");

        }
        return clientSocket;
    }


    public static void sendReceive(Socket clientSocket, String input) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                SendReceive.sendDataToServer(input, writer);
                String receiveMessage = SendReceive.receive(reader);
                System.out.println(OperationDispatch.getConsoleOut(input, receiveMessage));
            } finally {
                if (reader != null) reader.close();
                else {
                    System.out.println("reader is null");
                }
                if (writer != null) writer.close();
                else {
                    System.out.println("writer is null");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
