package oop.practice;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private Universe starWars = new Universe(new ArrayList<>());
    private Universe hitchhikers = new Universe(new ArrayList<>());
    private Universe marvel = new Universe(new ArrayList<>());
    private Universe rings = new Universe(new ArrayList<>());

    public Category(JsonNode data) {
        for (JsonNode entry : data) {
            boolean isHumanoid = entry.has("isHumanoid") && !entry.get("isHumanoid").isNull() && entry.get("isHumanoid").asBoolean();
            String planet = entry.has("planet") && !entry.get("planet").isNull() ? entry.get("planet").asText() : "unknown";
            int age = entry.has("age") && !entry.get("age").isNull() ? entry.get("age").asInt() : -1;

            List<String> traits = new ArrayList<>();
            if (entry.has("traits") && !entry.get("traits").isNull()) {
                entry.get("traits").forEach(traitNode -> traits.add(traitNode.asText()));
            }

            if (!isHumanoid && planet.equals("Kashyyyk") && age >= 0 && age <= 400 && traits.contains("HAIRY") && traits.contains("TALL")) {
                starWars.getIndividuals().add(entry);
            } else if (!isHumanoid && planet.equals("Endor") && age >= 0 && age <= 60 && traits.contains("HAIRY") && traits.contains("SHORT")) {
                starWars.getIndividuals().add(entry);
            } else if (isHumanoid && planet.equals("Asgard") && age >= 0 && age <= 5000 && traits.contains("BLONDE") && traits.contains("TALL")) {
                marvel.getIndividuals().add(entry);
            } else if (isHumanoid && planet.equals("Betelgeuse") && age >= 0 && age <= 100 && traits.contains("EXTRA_ARMS") && traits.contains("EXTRA_HEAD")) {
                hitchhikers.getIndividuals().add(entry);
            } else if (!isHumanoid && planet.equals("Vogsphere") && age >= 0 && age <= 200 && traits.contains("GREEN") && traits.contains("BULKY")) {
                hitchhikers.getIndividuals().add(entry);
            } else if (isHumanoid && planet.equals("Earth") && traits.contains("BLONDE") && traits.contains("POINTY_EARS")) {
                rings.getIndividuals().add(entry);
            } else if (isHumanoid && planet.equals("Earth") && age >= 0 && age <= 200 && traits.contains("SHORT") && traits.contains("BULKY")) {
                rings.getIndividuals().add(entry);
            } else {
                System.out.println("Unknown classification for entry: " + entry.toPrettyString());
            }
        }
    }

    public Universe getStarWars() {
        return starWars;
    }

    public Universe getHitchhikers() {
        return hitchhikers;
    }

    public Universe getMarvel() {
        return marvel;
    }

    public Universe getRings() {
        return rings;
    }
}
