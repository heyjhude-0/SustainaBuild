package buildings;

public class ThemePark extends Building {
    public ThemePark() {
        super("🎢  Theme Park", 5, 25, 20, 20);
    }

    @Override
    public void build() {
        System.out.println("🎢    A Theme Park is built! Everyone’s having fun and laughter fills the air!");
        System.out.println("📊    +5 Population | +25 Happiness | +25 Pollution | -20 Space\n");
    }
}
