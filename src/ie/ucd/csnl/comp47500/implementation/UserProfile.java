package ie.ucd.csnl.comp47500.implementation;

/**
 * Represents a user's profile information within a social network.
 * This class stores personal details such as name, age, and a dynamically calculated influence score.
 */
public class UserProfile {
	// Fields
    private String name; 
    private int age;
    private int influenceScore = 0; // Computed score based on user's influence in the network

    /**
     * Constructor to initialize a UserProfile with a name and age.
     * @param name The name of the user.
     * @param age The age of the user.
     */
    
    public UserProfile(String name, int age) { 
        this.name = name; 
        this.age = age;
    } 

    // Getters
    public String getName() { 
        return name; 
    } 

    public int getAge() { 
        return age; 
    } 


    public int getInfluenceScore() {
        return influenceScore;
    }

    // Setters
    public void setName(String name) { 
        this.name = name; 
    } 

    public void setAge(int age) { 
        this.age = age; 
    } 


    public void setInfluenceScore(int d) {
        this.influenceScore = d;
    }

    // Overridden toString() method
    @Override 
    public String toString() { 
        return "UserProfile{" + 
                "name='" + name + '\'' + 
                ", age=" + age +
                ", followersCount=" + influenceScore + 
                '}'; 
    }

} 
