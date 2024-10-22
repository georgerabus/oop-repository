import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
      ReadFile readFile = new ReadFile();
      JsonNode data = readFile.getData();

      Category category = new Category(data);
      readFile.setUniverses(category.getStarWars(), category.getHitchhikers(), category.getRings(), category.getMarvel());
      readFile.writeData();
  }
}