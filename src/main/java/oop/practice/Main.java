package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class Main {
  private JsonNode data;
  private ReadFile readFile;

  public Main() throws IOException {
    readFile = new ReadFile();
    this.data = readFile.getData();

    Category category = new Category(data);
    readFile.setUniverses(category.getStarWars(), category.getHitchhikers(), category.getRings(), category.getMarvel());
    readFile.writeData();
  }

  public static void main(String[] args) throws IOException {
    new Main();
  }
}