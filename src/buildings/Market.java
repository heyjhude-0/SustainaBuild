package buildings;

public class Market extends Building {
    public Market() {
        super("🏢  Market", 12, 8, 15, 10);
    }

    @Override
    public void build() {
        System.out.println("🏢    A lively Market opened! People are busy shopping and selling goods.");
        System.out.println("📊    +12 Population | +8 Happiness | +15 Pollution | -10 Space\n");
    }
}
