import java.util.Scanner;
//import buildings.CityManager;
import buildings.*;
//import buildings.InvalidConstructionException;

class Main{
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
       while (true) {
                System.out.println();
                System.out.println("╔----------------------------------------------------------------------------------╗");
                System.out.println("|                        WELCOME TO SUSTAINABUILD!👋                                |");
                System.out.println("|----------------------------------------------------------------------------------|");
                System.out.println("|           🏦  Choose, and construct buildings and take up available space.        |");
                System.out.println("|                   🌲  Balance progress and sustainability.                        |");
                System.out.println("|   🧠  Strategic thinking becomes essential to maintain a green and thriving city. |"); 
                System.out.println("╚----------------------------------------------------------------------------------╝");
                System.out.println();
                System.out.println("\t1. 🕹  Start Game");
                System.out.println("\t2. ❓  How to Play");
                System.out.println("\t3. 📃  Credits");
                System.out.println("\t4. ❌  Exit");
                System.out.print("\n\tChoose an option: ");
                
                char choice = sc.next().charAt(0); 

            switch (choice) {
                case '1':
                    startGame(sc);
                    break;
                case '2':
                    showHowToPlay(sc);
                    break;
                case '3':
                    showCredits(sc);
                    break;
                case '4':
                    System.out.println("\t👋  Exiting game.Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice. Enter to try again.");
                    sc.nextLine();
                    sc.nextLine();
                }
            }
            
            
}
   
    public static void showMainMenu(){
        
    }


    public static void startGame(Scanner sc){
        CityManager city = new CityManager();
        clearScreen();
        System.out.println("🎮   GAME START");
        while (true){
            
            
            System.out.println("\n🏦🏦  Choose building to create: 🏦🏦\n");
            System.out.println("1. 🏭  Factory \t\t2. 🏠  House");
            System.out.println("3. 🌳  Tree  \t\t4. 🏥  Hospital");
            System.out.println("5. 🎢  Theme Park  \t6. 🏢  Market");
            System.out.println("7. ❌   Exit");
            System.out.print("Your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("❌ Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            int input = sc.nextInt();
            
            clearScreen();
        
        try {
            switch (input) {
                case 1:
                    city.addBuilding(new Factory());
                    break;
                case 2:
                    city.addBuilding(new House());
                    break;
                case 3:
                    city.addBuilding(new Tree());
                    break;
                case 4:
                    city.addBuilding(new Hospital());
                    break;
                case 5: 
                    city.addBuilding(new ThemePark());
                    break;
                case 6: 
                    city.addBuilding(new Market());
                    break;
                case 7:
                    endGame(city, sc);
                    return;
                default: 
                    System.out.println("❌  Invalid choice.");
                    continue;
   
            }
        
        } catch (InvalidConstructionException e) {
                System.out.println(e.getMessage());
                continue;
            }
            
            city.showCityStats();

            if (!city.isCityStable()){
                    System.out.println("\n📉  City unstable!");
                    endGame(city, sc);
                    break;
                }

            if (!city.isSpaceLeft()){
                    System.out.println("🏨 All space are occupied. Let's see how well you did.");
                    endGame(city, sc);
                    break;
                }
            
            System.out.println("🎮  Press..."); 
            System.out.println("[C] to continue building.");
            System.out.println("[ ] any button to Exit and show your current score. ");
            char press = sc.next().charAt(0); 
            sc.nextLine();

            if (press != 'C' && press != 'c'){
                endGame(city, sc);
                break;
            }
           
        } 
    }

    public static void endGame(CityManager city, Scanner sc){
        System.out.println();
        System.out.println("🎮  GAME ENDED. Final City Status");
        city.showCityStats();
        System.out.println("\n📈  RATING: " + city.getCityRating());
        System.out.println("\nPress Enter to return to Main Menu.");
        sc.nextLine();
        sc.nextLine();
        clearScreen();
    }

    private static void showHowToPlay(Scanner sc) {
        clearScreen();
        System.out.println("❓  HOW TO PLAY:");
        System.out.println("\n- Build and manage your city.");
        System.out.println("- Balance population, happiness, and pollution.");
        System.out.println("- Avoid spamming trees or overbuilding.");
        System.out.println("- Keep ecoScore high to maintain city stability.");
        System.out.println("\nPress Enter to return to Main Menu.");
        sc.nextLine();
        sc.nextLine();
        clearScreen();
    }

    private static void showCredits(Scanner sc) {
        clearScreen();
        System.out.println("📃  CREDITS:");
        System.out.println("\n- Developer: Jhude Dagle, Faith Gonzales, Nhealeen Hernandez");
        System.out.println("- Language: Java");
        System.out.println("- Special thanks: Ma'am Fatima Agdon");
        System.out.println("\nPress Enter to return to Main Menu.");
        sc.nextLine();
        sc.nextLine();
        clearScreen();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}