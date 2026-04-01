/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Recommendation {
    // Declare variables
    private String recommendationID;
    private String type;
    private String recommendationText;
    private String[] recommendations;
    
    // Constructor
    public Recommendation(String recommendationID, String type, String recommendationText) {
        this.recommendationID = recommendationID;
        this.type = type;
        this.recommendationText = recommendationText;
        // Split the recommendations and place them in an array
        this.recommendations = recommendationText.split("\\|");
    }
    
    // Encapsulation
    public String getRecommendationID(){
        return this.recommendationID;
    }
    
    public void setRecommendationID(String recommendationID){
        this.recommendationID = recommendationID;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getRecommendationText(){
        return this.recommendationText;
    }
    
    public void setRecommendationText(String recommendationText){
        this.recommendationText = recommendationText;
        // Splits the recommendation text
        this.recommendations = recommendationText.split("\\|");
    }
    
    public String[] getRecommendations(){
        return recommendations;
    }
    
    // Get the number of recommendation
    public int getRecommendationsCount(){
        // Return the amount of recommendation text
        return recommendations.length;
    }
}
