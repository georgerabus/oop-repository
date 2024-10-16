package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadFile {
    private Universe starWars;
    private Universe hitchhikers;
    private Universe rings;
    private Universe marvel;
    private JsonNode data;
    private ObjectMapper mapper;

    public ReadFile() throws IOException {
        File inputFile = new File("src/resources/input.json");
        this.mapper = new ObjectMapper();
        this.data = mapper.readTree(inputFile).get("input");
    }

    public void setUniverses(Universe starWars, Universe hitchhikers, Universe rings, Universe marvel) {
        this.starWars = starWars;
        this.hitchhikers = hitchhikers;
        this.rings = rings;
        this.marvel = marvel;
    }

    public void printFile() {
        System.out.println(this.data.toPrettyString());
    }

    public JsonNode getData() {
        return data;
    }

    public void writeData() throws IOException {
        if (starWars != null) mapper.writeValue(new File("src/resources/output/starwars.json"), starWars);
        if (hitchhikers != null) mapper.writeValue(new File("src/resources/output/hitchhiker.json"), hitchhikers);
        if (rings != null) mapper.writeValue(new File("src/resources/output/rings.json"), rings);
        if (marvel != null) mapper.writeValue(new File("src/resources/output/marvel.json"), marvel);
    }
}
