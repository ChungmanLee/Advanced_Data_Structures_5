package ie.ucd.csnl.comp47500.implementation;

import java.util.ArrayList;
import java.util.List;

import ie.ucd.csnl.comp47500.model.Edge;
import ie.ucd.csnl.comp47500.model.Vertex;

/**
 * Represents a social network graph specifically tailored for analyzing user interactions.
 * This class extends GraphImpl to handle vertices specifically designed as UserProfile, 
 * which include user profiles and their interactions.
 */
public class SocialNetworkGraph extends GraphImpl<UserProfile> {

    /**
     * Constructor for the SocialNetworkGraph.
     * Initializes an empty graph with no vertices or edges.
     */
    public SocialNetworkGraph() {
        super();
    }

    /**
     * Calculates the influence scores for all users in the graph.
     * The score is determined by the strength of the interactions each user has in the graph.
     * The strength of each interaction is added up to form the total influence score of a user.
     * (like, comment, share, follow) to calculate the total influence score for each user.
     * Recipient will get the score.
     */
    public void calculateInfluenceScores() {
        // Iterate over each vertex in the graph
        for (Vertex<UserProfile> vertex : getAdjacencyList().keySet()) {
            UserProfile userProfile = vertex.getData();  // Retrieve the user profile data

            // Initialize score for each vertex first
            userProfile.setInfluenceScore(0);  
        }

        // Iterate again to distribute scores based on interactions
        for (Vertex<UserProfile> fromVertex : getAdjacencyList().keySet()) {
            List<Edge<UserProfile>> edges = getAdjacencyList().get(fromVertex);
            for (Edge<UserProfile> edge : edges) {
                if (edge instanceof InteractionEdge) {
                    InteractionEdge intEdge = (InteractionEdge) edge;
                    Vertex<UserProfile> toVertex = intEdge.getTo();
                    UserProfile toUserProfile = toVertex.getData();
                    int currentScore = toUserProfile.getInfluenceScore();
                    // Adding strength to the receiver's score
                    toUserProfile.setInfluenceScore(currentScore + intEdge.getWeight());
                }
            }
        }
    }

    /**
     * Identifies the top N influencers in the graph based on their influence scores.
     * Influencers are sorted by their scores in descending order.
     * 
     * @param topN The number of top influencers to return.
     * @return A list of the top N influencers as UserProfile objects.
     */
    public List<UserProfile> findKeyInfluencers(int topN) {
        List<UserProfile> allProfiles = new ArrayList<>();
        
        // Collect all user profiles from the graph
        for (Vertex<UserProfile> vertex : getAdjacencyList().keySet()) {
            allProfiles.add(vertex.getData());
        }
        
        // Sort the profiles by influence score in descending order
        allProfiles.sort((p1, p2) -> Integer.compare(p2.getInfluenceScore(), p1.getInfluenceScore()));
        
        // Return the sublist of top N influencers, ensuring we do not exceed list size
        return allProfiles.subList(0, Math.min(topN, allProfiles.size()));
    }
    
    /**
     * Adds an interaction edge to the social network graph.
     * @param from The starting vertex of the interaction.
     * @param to The ending vertex of the interaction.
     * @param type The type of social interaction.
     * @param bidirectional Indicates whether the edge should be bidirectional.
     */
    public void addInteractionEdge(Vertex<UserProfile> from, Vertex<UserProfile> to, InteractionType type, boolean bidirectional) {
        InteractionEdge interactionEdge = new InteractionEdge(from, to, type);
        getAdjacencyList().putIfAbsent(from, new ArrayList<>());
        getAdjacencyList().get(from).add(interactionEdge);

        if (bidirectional) {
            InteractionEdge reciprocalEdge = new InteractionEdge(to, from, type);
            getAdjacencyList().putIfAbsent(to, new ArrayList<>());
            getAdjacencyList().get(to).add(reciprocalEdge);
        }
    }
    
}
