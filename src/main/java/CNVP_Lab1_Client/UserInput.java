package CNVP_Lab1_Client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UserInput {
    public static void displayOptions() {
        System.out.println("get number of brigade");
        System.out.println("get surnames of brigade");
        System.out.println("exit");
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String readUserInput() {
        displayOptions();
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.nextLine();
            if (input.equals("get number of brigade") || input.equals("get surnames of brigade") || input.equals("exit")) {
                return input;
            } else {
                System.out.println("Input is not correct");
                displayOptions();
            }
        }
    }

    public static InetAddress getInetAddress() throws UnknownHostException {
        System.out.println("Input server's IP address or use default 127.0.0.1");
        Scanner in = new Scanner(System.in);
        while (true) {
            String ipAddressOfServer = in.nextLine();
            boolean validation = validateIp(ipAddressOfServer);
            if (validation) {
                return InetAddress.getByName(ipAddressOfServer);
            } else {
                System.out.println("Input server's IP address or use default 127.0.0.1");
            }
        }
    }

    public static boolean validateIp(String inputedIp) {
        boolean validation = false;
        if (Validation.isValidInetAddress(inputedIp)) {
            return true;
        } else {
            System.out.print("The IP address " + inputedIp + " isn't valid");
            return false;
        }

    }
}
