package buildings;

public class Factory extends Building {
    public Factory() {
        super("🏭  Factory", 30, -5, 20, 15);
    }

    @Override
    public void build() {
        System.out.println("🏭    A Factory has been built! It boosts your economy but fills the air with smoke...");
        System.out.println("📊    +30 Population | -5 Happiness | +25 Pollution | -15 Space\n");
    }
}