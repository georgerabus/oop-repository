package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    private Universe starWars;
    private Universe hitchhikers;
    private Universe rings;
    private Universe marvel;
    private final JsonNode data;
    private final ObjectMapper mapper;
    private final String ROOT = "src/main/resources";

    public ReadFile() throws IOException {
        File inputFile = new File(ROOT + "/input.json");
        this.mapper = new ObjectMapper();
        this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
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

        Path outputDirectory = Paths.get(ROOT + "/output");

        if (Files.notExists(outputDirectory)) {
            Files.createDirectories(outputDirectory);
        }

        if (starWars != null) mapper.writeValue(new File(ROOT + "/output/starwars.json"), starWars);
        if (hitchhikers != null) mapper.writeValue(new File(ROOT + "/output/hitchhiker.json"), hitchhikers);
        if (rings != null) mapper.writeValue(new File(ROOT + "/output/rings.json"), rings);
        if (marvel != null) mapper.writeValue(new File(ROOT + "/output/marvel.json"), marvel);
    }
}
