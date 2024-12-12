package ie.ucd.csnl.comp47500.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ie.ucd.csnl.comp47500.implementation.InteractionType;
import ie.ucd.csnl.comp47500.implementation.SocialNetworkGraph;
import ie.ucd.csnl.comp47500.implementation.UserProfile;
import ie.ucd.csnl.comp47500.implementation.VertexImpl;
import ie.ucd.csnl.comp47500.model.Vertex;

class SocialNetworkGraphTest {
    private SocialNetworkGraph socialGraph;
    Vertex<UserProfile> user1;
    Vertex<UserProfile> user2;
    @BeforeEach
    void setUp() {
        socialGraph = new SocialNetworkGraph();
        user1 = new VertexImpl<>(new UserProfile("User1",21));
        user2 = new VertexImpl<>(new UserProfile("User2", 54));
        socialGraph.addVertex(user1);
        socialGraph.addVertex(user2);
    }

    @Test
    void testAddInteractionEdge() {
        
        
        socialGraph.addInteractionEdge(user1, user2, InteractionType.LIKE, false);
        
        assertEquals(1, socialGraph.getEdgeCount(false));
        assertEquals(true, socialGraph.hasEdge(user1, user2));
    }
    
    @Test
    void testCalculateInfluenceScores() {
    
        
        
        // Add interaction edges
        socialGraph.addInteractionEdge(user1, user2, InteractionType.LIKE, false);
        socialGraph.addInteractionEdge(user2, user1, InteractionType.COMMENT, false);
        socialGraph.addInteractionEdge(user1, user2, InteractionType.COMMENT, false);
        
        // Calculate influence scores
        socialGraph.calculateInfluenceScores();
        
        // Check influence scores
        assertEquals(2, user1.getData().getInfluenceScore());
        assertEquals(3, user2.getData().getInfluenceScore());
    }
    
    @Test
    void testFindKeyInfluencers() {

        Vertex<UserProfile> user3 = new VertexImpl<>(new UserProfile("User3",41));
        socialGraph.addVertex(user1);
        socialGraph.addVertex(user2);
        socialGraph.addVertex(user3);
        
        // Add interaction edges
        socialGraph.addInteractionEdge(user1, user2, InteractionType.LIKE, false);
        socialGraph.addInteractionEdge(user2, user1, InteractionType.COMMENT, false);
        socialGraph.addInteractionEdge(user3, user1, InteractionType.SHARE, false);
        
        // Calculate influence scores
        socialGraph.calculateInfluenceScores();
        
        // Find top influencers
        List<UserProfile> influencers = socialGraph.findKeyInfluencers(2);
        
        // Check top influencers
        assertEquals(2, influencers.size());
        assertEquals("User1", influencers.get(0).getName());
        assertEquals("User2", influencers.get(1).getName());
        
    }
    
    @Test
    void testBidirection() {

        
        // Add interaction edges
        socialGraph.addInteractionEdge(user1, user2, InteractionType.FOLLOW, true);
        
        // Calculate influence scores
        socialGraph.calculateInfluenceScores();
        
        // Check influence scores
        assertEquals(5, user1.getData().getInfluenceScore());
        assertEquals(5, user2.getData().getInfluenceScore());
    }
    
    
}

