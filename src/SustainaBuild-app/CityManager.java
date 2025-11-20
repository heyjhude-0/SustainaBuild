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
            throw new InvalidConstructionException("Not enough space left to build a " + b.getName() + "!");
        }
        if (!buildings.isEmpty() && !isCityStable()){
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

    private void updateEcoScore(){
        int score = totalHappiness - totalPollution  + (availableSpace / 2);

        if (score > 100) score = 100;
        if (score < 0) score = 0;

        ecoScore = score;
    }

    
    void showCityStats(){
        System.out.println("\nYour City Status: " );
        System.out.print("Current buildings: ");
        for (Building bld: buildings){
            System.out.print(bld.getName() + ", ");
        }
        System.out.println("\nCurrent Population: " + getTotalPopulation());
        System.out.println("Current Happiness: " + getTotalHappiness());
        System.out.println("Current Pollution: " + getTotalPollution());
        System.out.println("Remaining Space: " + getAvailableSpace());
        System.out.println("Eco Score: " + getEcoScore());


    }
    
    public boolean isCityStable() {
        return ecoScore >= 30;
    }

    public boolean isSpaceLeft() {
        return availableSpace > 0;
    }

    public String getCityRating() {
    if (ecoScore >= 80) return "🌿 Excellent!";
    if (ecoScore >= 60) return "😊 Good job!";
    if (ecoScore >= 30) return "😐 City is stable but could improve.";
    return "💀 City collapsed due to instability!";
}


}
