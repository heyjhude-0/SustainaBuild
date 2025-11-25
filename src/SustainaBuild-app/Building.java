
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
class Factory extends Building {
    public Factory() {
        super("🏭  Factory", 25, -10, 25, 15);
    }

    @Override
    public void build() {
        System.out.println("🏭    A Factory has been built! It boosts your economy but fills the air with smoke...");
        System.out.println("📊    +25 Population | -10 Happiness | +25 Pollution | -15 Space\n");
    }
}

// 🏠 house — adds population and mild happiness, small pollution
class House extends Building {
    public House() {
        super("🏠  House", 15, 6, 5, 10);
    }

    @Override
    public void build() {
        System.out.println("🏠    You built a cozy House! Families are moving in happily.");
        System.out.println("📊    +15 Population | +6 Happiness | +8 Pollution | -10 Space\n");
    }
}

// 🌳 tree — reduces pollution, small space used
class Tree extends Building {
    public Tree() {
        super("🌳  Tree", 0, 2, -6, 3);
    }

    @Override
    public void build() {
        System.out.println("🌳    You planted Trees! The city air feels cleaner and fresher.");
        System.out.println("📊    +0 Population | +1 Happiness | -3 Pollution | -3 Space\n");
    }
}

// 🏥 hospital — improves happiness, small pollution
class Hospital extends Building {
    public Hospital() {
        super("🏥  Hospital", 10, 15, 15, 14);
    }

    @Override
    public void build() {
        System.out.println("🏥    A Hospital is now serving the people! Everyone feels safer and cared for.");
        System.out.println("📊    +10 Population | +15 Happiness | +15 Pollution | -14 Space\n");
    }
}
// 🏢 market — moderate population and happiness, minor pollution
class Market extends Building {
    public Market() {
        super("🏢  Market", 12, 8, 10, 10);
    }

    @Override
    public void build() {
        System.out.println("🏢    A lively Market opened! People are busy shopping and selling goods.");
        System.out.println("📊    +12 Population | +8 Happiness | +10 Pollution | -10 Space\n");
    }
}


// 🎢 theme park — big happiness, some pollution, large space
class ThemePark extends Building {
    public ThemePark() {
        super("🎢  Theme Park", 5, 25, 20, 20);
    }

    @Override
    public void build() {
        System.out.println("🎢    A Theme Park is built! Everyone’s having fun and laughter fills the air!");
        System.out.println("📊    +5 Population | +25 Happiness | +20 Pollution | -20 Space\n");
    }
}

