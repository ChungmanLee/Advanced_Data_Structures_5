package ie.ucd.csnl.comp47500.implementation;

import ie.ucd.csnl.comp47500.model.Vertex;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an edge in a social network graph, specifically designed to handle interactions
 * between user profiles. This class extends EdgeImpl to include social interaction types and dynamically calculates the weight.
 */
public class InteractionEdge extends EdgeImpl<UserProfile> {
    private InteractionType type;  // The type of social interaction this edge represents

    // Static map to hold base weights for each interaction type
    private static final Map<InteractionType, Integer> BASE_WEIGHT = new HashMap<>();
    static {
        BASE_WEIGHT.put(InteractionType.LIKE, 1);  // Base weight for a 'like' interaction
        BASE_WEIGHT.put(InteractionType.COMMENT, 2);  // Base weight for a comment
        BASE_WEIGHT.put(InteractionType.SHARE, 3);  // Base weight for sharing content
        BASE_WEIGHT.put(InteractionType.FOLLOW, 5);  // Base weight for following a user
    }

    /**
     * Constructs a new InteractionEdge with specified details about the interaction.
     * @param from The starting vertex (UserProfile) of the interaction.
     * @param to The ending vertex (UserProfile) of the interaction.
     * @param type The type of interaction, which determines the base weight.
     */
    public InteractionEdge(Vertex<UserProfile> from, Vertex<UserProfile> to, InteractionType type) {
        super(from, to, calculateWeight(type));  // Call to the superclass constructor with calculated weight
        this.type = type;
    }

    /**
     * Calculates the weight of an interaction based on its type.
     * @param type The type of the interaction.
     * @return The weight assigned to this type of interaction.
     */
    private static int calculateWeight(InteractionType type) {
        return BASE_WEIGHT.getOrDefault(type, 1);  // Default weight is 1 if not specified
    }

    /**
     * Returns the type of interaction this edge represents.
     * @return The interaction type.
     */
    public InteractionType getType() {
        return type;
    }
}
