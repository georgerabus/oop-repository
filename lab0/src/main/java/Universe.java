import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class Universe {
    private String name;
    private List<JsonNode> individuals;

    public Universe(String name, List<JsonNode> individuals) {
        this.individuals = individuals;
    }

    public List<JsonNode> getIndividuals() {
        return individuals;
    }

    public String getName() {
        return name;
    }
}
