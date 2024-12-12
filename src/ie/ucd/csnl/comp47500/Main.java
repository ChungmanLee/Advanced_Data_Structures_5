package ie.ucd.csnl.comp47500;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ie.ucd.csnl.comp47500.implementation.InteractionType;
import ie.ucd.csnl.comp47500.implementation.SocialNetworkGraph;
import ie.ucd.csnl.comp47500.implementation.UserProfile;
import ie.ucd.csnl.comp47500.implementation.VertexImpl;
import ie.ucd.csnl.comp47500.model.Vertex;
import ie.ucd.csnl.comp47500.constant.Message;

public class Main {

	public static void main(String[] args) {
		
	    	// Test codes for usecase
	    	// Create a new social network graph
	    	SocialNetworkGraph SNgraph = new SocialNetworkGraph();
	
	    	// Create some user profiles
			String csvFile =Message.RESOURCE_PATH+ "users_data_100000.csv";
			String line;
			String csvSplitBy = ";";

			
			int size = 10;
			for (int i=0;i<6;i++){
				System.out.println("_____________________________________________________________________________________________");
				System.out.println("processing graph with vertices: "+size);
				List<UserProfile> userProfileList = new ArrayList<>();
				List<Vertex<UserProfile>> vertices = new ArrayList<>();
				long startTime = System.currentTimeMillis();
				try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
					int lineCount = 0;
					while ((line = br.readLine()) != null && lineCount < size) {
						lineCount++;
						// Rest of the code
						String[] userData = line.split(csvSplitBy);
						String name = userData[0].replaceAll("\"", "");
						int age = Integer.parseInt(userData[1].replaceAll("\"", ""));

						// Create user profile and vertex
						

						UserProfile userProfile = new UserProfile(name, age);
						userProfileList.add(userProfile);
						Vertex<UserProfile> userVertex = new VertexImpl<>(userProfile);
						vertices.add(userVertex);
						// Add vertex to the graph
						SNgraph.addVertex(userVertex);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Time taken to add vertices in graph "+(endTime-startTime) + " ms");
				int count = 0;
				long startTimeedges = System.currentTimeMillis();
				while(count < size){
					Random random = new Random();
					int randomIndex1 = random.nextInt(userProfileList.size());
					int randomIndex2;
					do {
						randomIndex2 = random.nextInt(userProfileList.size());
					} while (randomIndex2 == randomIndex1);
					UserProfile userProfile1 = userProfileList.get(randomIndex1);
					UserProfile userProfile2 = userProfileList.get(randomIndex2);
					Vertex<UserProfile> vertex1 = new VertexImpl<>(userProfile1);
					Vertex<UserProfile> vertex2 = new VertexImpl<>(userProfile2);
					InteractionType interactionType = InteractionType.values()[random.nextInt(InteractionType.values().length)];
					boolean isPositive = random.nextBoolean();
					SNgraph.addInteractionEdge(vertex1, vertex2, interactionType, isPositive);
					
					count++;
				}
				long endTimeedges = System.currentTimeMillis();
				System.out.println("Time taken to add edges in graph "+(endTimeedges-startTimeedges) + " ms");
				// Calculate influence scores
				long startTimeInfluence = System.currentTimeMillis();
				SNgraph.calculateInfluenceScores();
				long endTimeInfluence = System.currentTimeMillis();
				System.out.println("Time taken to calculate influence scores using traversal algorithm "+(endTimeInfluence-startTimeInfluence) + " ms");
	
				// Print out the influence scores
				//uncomment this line to print influence scores
				//System.out.println("Influencer Scores:");
				for (Vertex<UserProfile> vertex : vertices) {
					//System.out.printf("%s: %d%n", vertex.getData().getName(), vertex.getData().getInfluenceScore());
				}
		
				// Find and print the top influencer
				long startTimeTopInfluencer = System.currentTimeMillis();
			   System.out.println("\nTop Influencer:");
				List<UserProfile> topInfluencers = SNgraph.findKeyInfluencers(3);
				for (UserProfile influencer : topInfluencers) {
					System.out.printf("%s with score %d%n", influencer.getName(), influencer.getInfluenceScore());
			   }
			   long endTimeTopInfluencer = System.currentTimeMillis();
			   System.out.println("\nTime taken to find top influencer "+(endTimeTopInfluencer-startTimeTopInfluencer) + " ms");
				size = size * 10;
				//List<Vertex<UserProfile>> vertices = List.of(alice, bob, carol);
			}
	    // 	UserProfile aliceProfile = new UserProfile("Alice dsd", 30);
	    // 	UserProfile bobProfile = new UserProfile("Bob", 25);
	    // 	UserProfile carolProfile = new UserProfile("Carol", 27);
		
	    // 	// Create vertices using these profiles
	    // 	Vertex<UserProfile> alice = new VertexImpl<>(aliceProfile);
	    // 	Vertex<UserProfile> bob = new VertexImpl<>(bobProfile);
	    // 	Vertex<UserProfile> carol = new VertexImpl<>(carolProfile);
	
	    // 	// Add vertices to the graph
	    // 	SNgraph.addVertex(alice);
	    // 	SNgraph.addVertex(bob);
	    // 	SNgraph.addVertex(carol);
	
	    // 	//Create some interactions using addInteractionEdge
	    // 	SNgraph.addInteractionEdge(alice, bob, InteractionType.FOLLOW, true);
	    // 	SNgraph.addInteractionEdge(bob, carol, InteractionType.COMMENT, false);
	    // 	SNgraph.addInteractionEdge(carol, alice, InteractionType.SHARE, false);
	    	
	    // 	SNgraph.calculateInfluenceScores();
	
	   	//  //Calculate influence scores
	    	
	    // 	List<Vertex<UserProfile>> vertices = List.of(alice, bob, carol);
	    // 	for (Vertex<UserProfile> vertex : vertices) {
	    //     	System.out.printf("%s: %d%n", vertex.getData().getName(), vertex.getData().getInfluenceScore());
	    // 	}
	
	    // 	// Find and print the top influencer
	   	// 	System.out.println("\nTop Influencer:");
	    // 	List<UserProfile> topInfluencers = SNgraph.findKeyInfluencers(1);
	    // 	for (UserProfile influencer : topInfluencers) {
	    //     	System.out.printf("%s with score %d%n", influencer.getName(), influencer.getInfluenceScore());
	   	// 	}
        
	}

}
