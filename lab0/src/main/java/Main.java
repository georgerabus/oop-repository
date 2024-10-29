import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
      String path = "/input.json";
      ReadFile readFile = new ReadFile();
      JsonNode data = ReadFile.getData(path);

      var classifiedData = Category.classify(data);
      readFile.writeData(classifiedData);
  }
}