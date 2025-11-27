package buildings;

public class Tree extends Building {
    public Tree() {
        super("🌳  Tree", 0, 3, -5, 3);
    }

    @Override
    public void build() {
        System.out.println("🌳    You planted Trees! The city air feels cleaner and fresher.");
        System.out.println("📊    +0 Population | +3 Happiness | -5 Pollution | -3 Space\n");
    }
}
