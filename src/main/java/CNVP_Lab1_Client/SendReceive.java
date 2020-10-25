package CNVP_Lab1_Client;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class SendReceive {
    public static String getDataToSend(String input) throws JsonProcessingException {
        String operation = OperationDispatch.getOperation(input);
        String converted = JsonParser.convertToJson(operation);
        return converted;
    }

    public static void sendDataToServer(String input, BufferedWriter writer) throws IOException {
        String dataToSend = getDataToSend(input);
        writer.write(dataToSend + "\n");   //send
        writer.flush();
    }

    public static String receive(BufferedReader reader) throws IOException {
        String serverMassage = reader.readLine();
        return JsonParser.convertFromJson(serverMassage);

    }

}

