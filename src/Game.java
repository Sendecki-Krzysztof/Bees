import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    List<Bee> Bees = new ArrayList<>();

    Game() {
        Bees.add(new BlueBee());
        Bees.add(new BlueBee());
    }

    public Bee birthBee(Bee Bee1, Bee Bee2) {
        Bee temp = Bee1.breed(Bee2);
        this.Bees.add(temp);
        return temp;
    }
    public Bee generateNewBee(){
        Bee temp = new BlueBee();
        this.Bees.add(temp);
        return temp;
    }
    public void printBees() {
        for(int i = 0; i < this.Bees.size(); i++) {
            this.Bees.get(i).printBeeType();
            System.out.print(i + "'s ");
            this.Bees.get(i).printBeeInfo();
        }
    }
    public void playGame(Scanner input) {
        while(true) {
            printBees();
            System.out.println("Selected a breeding pair: (# #)");
            int firstBee = input.nextInt();
            int secondBee = input.nextInt();
            System.out.println("First Bee will be: " + firstBee + "!");
            System.out.println("Second Bee will be: " + secondBee + "!");

            if(firstBee == secondBee) {
                throw new RuntimeException();
            }

            birthBee(Bees.get(firstBee), Bees.get(secondBee));

        }
    }

    private void bestBirth(){
        Bee firstBee = this.Bees.get(0);
        Bee secondBee = this.Bees.get(1);
        for(int i = 1; i < this.Bees.size(); i++){
            if (this.Bees.get(i).getProduction() > firstBee.getProduction()) {
                secondBee = firstBee;
                firstBee = this.Bees.get(i);
            }
        }
        Bees.clear();
        Bees.add(firstBee);
        Bees.add(secondBee);
        birthBee(firstBee,secondBee);
    }
    public void autoPlayGame() {
        int count = 0;
        while(true) {
            printBees();
            bestBirth();
            System.out.println(count);
            System.out.println();
            count++;

            if(Bees.get(0).getValue() > 100) {
                break;
            }

        }
    }
}

