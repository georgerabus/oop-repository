
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private static Universe starWars = new Universe("starWars", new ArrayList<>());
    private static Universe hitchhikers = new Universe("hitchhikers", new ArrayList<>());
    private static Universe marvel = new Universe("marvel", new ArrayList<>());
    private static Universe rings = new Universe("rings", new ArrayList<>());

    public static ArrayList<Universe> classify(JsonNode data) {
        for (JsonNode entry : data) {
            boolean isHumanoid = entry.has("isHumanoid") && !entry.get("isHumanoid").isNull() && entry.get("isHumanoid").asBoolean();
            String planet = entry.has("planet") && !entry.get("planet").isNull() ? entry.get("planet").asText() : "unknown";
            int age = entry.has("age") && !entry.get("age").isNull() ? entry.get("age").asInt() : -1;

            List<String> traits = new ArrayList<>();
            if (entry.has("traits") && !entry.get("traits").isNull()) {
                entry.get("traits").forEach(traitNode -> traits.add(traitNode.asText()));
            }

            if (!isHumanoid && (planet.equals("Kashyyyk") || traits.contains("HAIRY") && traits.contains("TALL") || age <= 400)) {
                starWars.getIndividuals().add(entry);
            } else if (!isHumanoid && (planet.equals("Endor") || traits.contains("HAIRY") && traits.contains("SHORT") || age <= 60)) {
                starWars.getIndividuals().add(entry);
            }
            else if (isHumanoid && (planet.equals("Asgard") || traits.contains("BLONDE") && traits.contains("TALL") || age <= 5000)) {
                marvel.getIndividuals().add(entry);
            }
            else if (isHumanoid && (planet.equals("Betelgeuse") || traits.contains("EXTRA_ARMS") && traits.contains("EXTRA_HEAD") || age <= 100)) {
                hitchhikers.getIndividuals().add(entry);
            } else if (!isHumanoid && (planet.equals("Vogsphere") || traits.contains("GREEN") && traits.contains("BULKY") || age <= 200)) {
                hitchhikers.getIndividuals().add(entry);
            }
            else if (isHumanoid && (planet.equals("Earth") || traits.contains("BLONDE") && traits.contains("POINTY_EARS") || traits.contains("SHORT") && traits.contains("BULKY") || age <= 200)) {
                rings.getIndividuals().add(entry);
            }
            // If no strong match is found, assign to the most appropriate universe based on the traits available
            else if (traits.contains("HAIRY") || traits.contains("TALL") || planet.equals("Kashyyyk") || planet.equals("Endor")) {
                starWars.getIndividuals().add(entry);
            } else if (traits.contains("BLONDE") || traits.contains("TALL") || planet.equals("Asgard")) {
                marvel.getIndividuals().add(entry);
            } else if (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD") || planet.equals("Betelgeuse")) {
                hitchhikers.getIndividuals().add(entry);
            } else if (traits.contains("GREEN") || traits.contains("BULKY") || planet.equals("Vogsphere")) {
                hitchhikers.getIndividuals().add(entry);
            } else if (traits.contains("BLONDE") || traits.contains("POINTY_EARS") || traits.contains("SHORT") || traits.contains("BULKY") || planet.equals("Earth")) {
                rings.getIndividuals().add(entry);
            }
            // Default to Star Wars if no clear match is found (or we could make a different default)
            else {
                starWars.getIndividuals().add(entry);
            }
        }

        var array = new ArrayList<Universe>();
        array.add(starWars);
        array.add(marvel);
        array.add(hitchhikers);
        array.add(rings);
        return array;
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
