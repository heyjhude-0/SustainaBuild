package buildings;

// abstract class (abstraction)
public abstract class Building {
    // attributes (encapsulation)
    private String name;
    private int populationImpact;
    private int happinessImpact;
    private int pollutionImpact;
    private int spaceRequired;

    // constructor
    public Building(String name, int populationImpact, int happinessImpact, int pollutionImpact, int spaceRequired) {
        this.name = name;
        this.populationImpact = populationImpact;
        this.happinessImpact = happinessImpact;
        this.pollutionImpact = pollutionImpact;
        this.spaceRequired = spaceRequired;
    }

    // getters and setters (encapsulation)
    public String getName() { return name; }
    public int getPopulationImpact() { return populationImpact; }
    public int getHappinessImpact() { return happinessImpact; }
    public int getPollutionImpact() { return pollutionImpact; }
    public int getSpaceRequired() { return spaceRequired; }

    public void setName(String name) { this.name = name; }
    public void setPopulationImpact(int populationImpact) { this.populationImpact = populationImpact; }
    public void setHappinessImpact(int happinessImpact) { this.happinessImpact = happinessImpact; }
    public void setPollutionImpact(int pollutionImpact) { this.pollutionImpact = pollutionImpact; }
    public void setSpaceRequired(int spaceRequired) { this.spaceRequired = spaceRequired; }

    // abstract method (polymorphism)
    public abstract void build();
}

//////////////////////////////////////////////////////////////
// subclasses (inheritance + polymorphism)
//////////////////////////////////////////////////////////////

// 🏭 factory — boosts population but pollutes the city


// 🏠 house — adds population and mild happiness, small pollution


// 🌳 tree — reduces pollution, small space used

// 🏥 hospital — improves happiness, some pollution

// 🏢 market — moderate population and happiness, some pollution


// 🎢 theme park — big happiness, some pollution, large space

