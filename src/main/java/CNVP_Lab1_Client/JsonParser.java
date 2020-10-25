package CNVP_Lab1_Client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonParser {

    public static String convertToJson(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ServerRequest serverRequest = new ServerRequest();
        serverRequest.setOperation(message);
        return objectMapper.writeValueAsString(serverRequest);
    }


    public static String convertFromJson(String received) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ServerRequest serverRequest = objectMapper.readValue(received, ServerRequest.class);
        String result = serverRequest.getOperation();
        return result;
    }

}
