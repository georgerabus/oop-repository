import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadFile {

    private static ObjectMapper mapper = new ObjectMapper();
    private static final String ROOT = "lab0/src/main/resources";

//    public void setUniverses(Universe starWars, Universe hitchhikers, Universe rings, Universe marvel) {
//        this.starWars = starWars;
//        this.hitchhikers = hitchhikers;
//        this.rings = rings;
//        this.marvel = marvel;
//    }

    public static JsonNode getData(String pathToFile) throws IOException {
        File inputFile = new File(ROOT + pathToFile);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.readTree(inputFile).get("input");
    }

    public void writeData(ArrayList<Universe> data) throws IOException {

        Path outputDirectory = Paths.get(ROOT + "/output");

        if (Files.notExists(outputDirectory)) {
            Files.createDirectories(outputDirectory);
        }

        for (Universe universe : data) {
            mapper.writeValue(new File(ROOT + "/output/" + universe.getName() + ".json" ) , universe);
        }
    }
}
