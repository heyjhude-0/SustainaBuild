package buildings;

public class Factory extends Building {
    public Factory() {
        super("🏭  Factory", 25, -10, 25, 15);
    }

    @Override
    public void build() {
        System.out.println("🏭    A Factory has been built! It boosts your economy but fills the air with smoke...");
        System.out.println("📊    +25 Population | -10 Happiness | +25 Pollution | -15 Space\n");
    }
}