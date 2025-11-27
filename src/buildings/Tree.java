package buildings;

public class Tree extends Building {
    public Tree() {
        super("🌳  Tree", 0, 2, -6, 3);
    }

    @Override
    public void build() {
        System.out.println("🌳    You planted Trees! The city air feels cleaner and fresher.");
        System.out.println("📊    +0 Population | +1 Happiness | -3 Pollution | -3 Space\n");
    }
}
