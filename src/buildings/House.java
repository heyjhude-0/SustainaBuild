package buildings;

public class House extends Building {
    public House() {
        super("🏠  House", 15, 10, 8, 10);
    }

    @Override
    public void build() {
        System.out.println("🏠    You built a cozy House! Families are moving in happily.");
        System.out.println("📊    +15 Population | +10 Happiness | +8 Pollution | -10 Space\n");
    }
}