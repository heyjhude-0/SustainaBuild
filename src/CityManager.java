import buildings.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CityManager {
    private int totalPopulation = 0;
    private int totalHappiness = 50;
    private int totalPollution = 0;
    private int availableSpace = 100; 
    private int ecoScore = 0;
    private final List<Building> buildings = new ArrayList<>();

    public int getTotalPopulation(){ return totalPopulation;}
    public void setTotalPopulation(int totalPopulation){
        this.totalPopulation = totalPopulation;
    }

    public int getTotalHappiness(){ return totalHappiness;}
    public void setTotalHappiness(int totalHappiness){
        this.totalHappiness = totalHappiness;
    }

    public int getTotalPollution(){ return totalPollution;}
    public void setTotalPollution(int totalPollution){
        this.totalPollution = totalPollution;
    }

    public int getAvailableSpace(){ return availableSpace;}
    public void setAvailableSpace(int availableSpace){
        this.availableSpace= availableSpace;
    }
    public List<Building> getBuildings() { return Collections.unmodifiableList(buildings); }
    public int getEcoScore(){ return ecoScore;}



    public void addBuilding(Building b) throws InvalidConstructionException {
       if (availableSpace < b.getSpaceRequired()) {
            throw new InvalidConstructionException("\nNot enough space left to build a " + b.getName() + "!");
        }
     
        int maxTrees = 10; 
        int treeCount = 0;
        for (Building x : buildings) if (x.getName().contains("Tree") || x.getName().contains("🌳")) treeCount++;
        if (b instanceof Tree || b.getName().contains("Tree") || b.getName().contains("🌳")) {
            if (treeCount >= maxTrees) {
                throw new InvalidConstructionException("You can't add/spam more trees here (max " + maxTrees + ").");
            }
        }
        buildings.add(b);
        availableSpace -= b.getSpaceRequired();
        totalPopulation += b.getPopulationImpact();
        totalHappiness += b.getHappinessImpact();
        totalPollution += b.getPollutionImpact();
        updateEcoScore();
        b.build();



    }

private void updateEcoScore() {

    int score = totalHappiness - totalPollution + (availableSpace / 4);

    //pollution cap
    if (totalPollution < 0){
        totalPollution = 0;
    }

    if (totalPollution > 30) {        
        score -= (totalPollution - 30) / 2;
    }

    if (totalPopulation < 40) {
        score -= (40 - totalPopulation);  
    }


    else if (totalPopulation > 150) {
        score -= (totalPopulation - 150) / 4;
    }
    
    if (score > 100) score = 100;
    if (score < 0) score = 0;

    ecoScore = score;
}

    
    void showCityStats(){

        System.out.println("\n📊  YOUR CITY STATUS: " );
        System.out.print("\t🏢  Current buildings: ");
        for (Building bld: buildings){
            System.out.print(bld.getName() + ", ");
        }
        System.out.println("\n\t👨  Current Population: " + getTotalPopulation());
        System.out.println("\t😄  Current Happiness: " + getTotalHappiness());
        System.out.println("\t🌫  Current Pollution: " + getTotalPollution());
        System.out.println("\t🕳  Remaining Space: " + getAvailableSpace());
        System.out.println("\t☘  Eco Score: " + getEcoScore());


    }
    
    public boolean isCityStable() {
        return ecoScore >= 25;
    }

    public boolean isSpaceLeft() {
        return availableSpace > 0;
    }

    public String getCityRating() {
        if (ecoScore >= 80) return "🌿  Excellent!";
        if (ecoScore >= 60) return "😊  Good job!";
        if (ecoScore >= 40) return "😐  City is stable but could improve.";
        if (ecoScore >= 25) return "😢  City is struggling.";
        return "💀   City collapsed due to instability!";
    }


}
