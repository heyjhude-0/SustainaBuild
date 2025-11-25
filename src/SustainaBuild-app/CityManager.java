import java.util.ArrayList;
import java.util.List;

public class CityManager {
    int totalPopulation = 0;
    int totalHappiness = 50;
    int totalPollution = 0;
    int availableSpace = 100; 
    int ecoScore = 0;
    public List<Building> buildings = new ArrayList<>();

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
    public List<Building> getBuildings() { return buildings; }
    public int getEcoScore(){ return ecoScore;}



    public void addBuilding(Building b) throws InvalidConstructionException {
       if (availableSpace < b.getSpaceRequired()) {
            throw new InvalidConstructionException("\nNot enough space left to build a " + b.getName() + "!");
        }
        if (buildings.size() >= 3 && !isCityStable()){
            throw new InvalidConstructionException("City is unstable! You can't build more.");
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

    int score = totalHappiness - totalPollution + (availableSpace / 2);

   
    if (totalPollution > 30) {        
        score -= (totalPollution - 10) / 2;
    }

    if (totalPopulation < 50) {
        score -= (50 - totalPopulation);  
    }


    else if (totalPopulation > 150) {
        score -= (totalPopulation - 150) / 4;
    }
    
    if (score > 100) score = 100;
    if (score < 0) score = 0;

    ecoScore = score;
}

    
    void showCityStats(){

        System.out.println("\n📊  Your City Status: " );
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
        return ecoScore >= 30;
    }

    public boolean isSpaceLeft() {
        return availableSpace > 0;
    }

    public String getCityRating() {
    if (ecoScore >= 80) return "🌿  Excellent!";
    if (ecoScore >= 60) return "😊  Good job!";
    if (ecoScore >= 30) return "😐  City is stable but could improve.";
    return "💀   City collapsed due to instability!";
}


}
