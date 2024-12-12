package ie.ucd.csnl.comp47500.implementation;

import ie.ucd.csnl.comp47500.model.Vertex;

/**
 * Represents a vertex in a social network graph, specifically tailored for users.
 * This class extends VertexImpl to hold a UserProfile, which contains detailed
 * information about the user.
 */
public class UserVertex extends VertexImpl<UserProfile> {
    private UserProfile userProfile;  // UserProfile object that holds detailed information about the user

    /**
     * Constructs a UserVertex with a specified UserProfile.
     * This constructor initializes the vertex with user-specific profile data.
     * 
     * @param userProfile The UserProfile containing user data like name, age, and influence score.
     */
    public UserVertex(UserProfile userProfile) {
        super(userProfile);  // Call to the superclass constructor to store user profile data
        this.userProfile = userProfile;  // Additional reference to the UserProfile for easier access
    }

    /**
     * Returns the UserProfile associated with this vertex.
     * This method allows access to detailed user information stored in the UserProfile.
     * 
     * @return The UserProfile object associated with this vertex.
     */
    public UserProfile getUserProfile() {
        return userProfile;
    }
}
