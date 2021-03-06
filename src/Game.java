import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    List<Bee> Bees = new ArrayList<>();
    Display display;
    private Rectangle rectangle;

    Game(int width, int height) {
        this.display = new Display(width,height);
        rectangle = new Rectangle(0,0, 50, 50);

        Bees.add(new Bee());
        Bees.add(new Bee());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void update(){
        rectangle.setLocation((int) rectangle.getX() + 1, (int) rectangle.getY() + 1);
    }

    public void render(){
        display.render(this);
    }


    public Bee birthBee(Bee Bee1, Bee Bee2) {
        Bee temp = Bee1.breed(Bee2);
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

            if(Bees.get(0).getSellingValue() > 1000) {
                break;
            }

        }
    }
}

