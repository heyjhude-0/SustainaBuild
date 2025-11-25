import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
       
        System.out.println();
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("|                        WELCOME TO SUSTAINABUILD!👋                                |");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("|           🏦  Choose, and construct buildings and take up available space.        |");
        System.out.println("|                   🌲  Balance progress and sustainability.                        |");
        System.out.println("|   🧠  Strategic thinking becomes essential to maintain a green and thriving city. |"); 
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.print("\n🎮  Press Y to start game... ");
        char choice = sc.next().charAt(0); 

        if (choice == 'Y' || choice == 'y'){
            startGame(sc);
        }
        else{
            System.out.println("Game Exit.");
        }

        
        sc.close();
    }

    public static void startGame(Scanner sc){
        CityManager city = new CityManager();
        while (true){
            
            
            System.out.println("\n🏦🏦  Choose building to create: 🏦🏦\n");
            System.out.println("1. 🏭  Factory \t\t2. 🏠  House");
            System.out.println("3. 🌳  Tree  \t\t4. 🏥  Hospital");
            System.out.println("5. 🎢  Theme Park  \t6. 🏢  Market");
            System.out.println("7. ❌   Exit");
            System.out.print("Your choice: ");
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
                    endGame(city);
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
                    System.out.println("📉  City unstable!");
                    endGame(city);
                    break;
                }

            if (!city.isSpaceLeft()){
                    System.out.println("🏨 All space are occupied. Let's see how well you did.");
                    endGame(city);
                    break;
                }
            
            System.out.println("🎮  Press..."); 
            System.out.println("[C] to continue building.");
            System.out.println("[ ] any button to Exit and show your current score. ");
            char press = sc.next().charAt(0); 
            sc.nextLine();

            if (press != 'C' && press != 'c'){
                endGame(city);
                break;
            }
           
        } 
    }

    public static void endGame(CityManager city){
        System.out.println();
        System.out.println("🎮  Game Ended. Final City Status");
        city.showCityStats();
        System.out.println("📈  Rating: " + city.getCityRating());
    }

    public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }


}