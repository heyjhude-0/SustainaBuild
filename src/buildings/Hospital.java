package buildings;

public class Hospital extends Building {
    public Hospital() {
        super("🏥  Hospital", 10, 15, 20, 14);
    }

    @Override
    public void build() {
        System.out.println("🏥    A Hospital is now serving the people! Everyone feels safer and cared for.");
        System.out.println("📊    +10 Population | +15 Happiness | +20 Pollution | -14 Space\n");
    }
}