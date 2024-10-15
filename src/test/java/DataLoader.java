import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataLoader {
    public static String[][] getDataFromJSON(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File(fileName));

        String[][] data = new String[node.size()][];

        for (int i = 0; i < node.size(); i++) {
            data[i][0] = node.get(i).get("username").asText();
            data[i][1] = node.get(i).get("password").asText();
        }
        return data;
    }
}
