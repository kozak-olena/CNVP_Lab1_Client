package CNVP_Lab1_Client;

import java.io.IOException;

public class OperationDispatch {
    public static String getOperation(String input) {

        if (input.equals("get number of brigade")) {
            return "GetNumberOfMyBrigade";
        } else if (input.equals("get surnames of brigade")) {
            return "GetSurnamesOfMyBrigade";
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public static String getConsoleOut(String input, String receivedData) throws IOException {
        if (input.equals("get number of brigade")) {
            return "number of my brigade: " + receivedData;
        } else if (input.equals("get surnames of brigade")) {
            return "surnames of my brigade: " + receivedData;
        } else {
            throw new IOException("Invalid number of operation");
        }
    }


}
