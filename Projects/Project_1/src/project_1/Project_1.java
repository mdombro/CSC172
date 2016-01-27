/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author matthew
 */
public class Project_1 {

    /**
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char again = 'y';
        
        
        
        System.out.println("Input the colors of the pegs. Press <Enter> after each color. Type 'done' or 'Done to stop: ");
        List<String> colorsTemp = new ArrayList<>();
        String c = "";
        try{
            while ((c = in.readLine()) != null && !c.equalsIgnoreCase("done")) {
                colorsTemp.add(c);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        String[] colors = new String[colorsTemp.size()];
        for (int i = 0; i < colorsTemp.size(); i++) {
            colors[i] = colorsTemp.get(i);
        }
        //String[] colors = {"green", "blue", "red", "yellow", "orange", "pink"};

        int positions = 4; // set a default in case read messes up
        System.out.println("\nHow many positions should there be: ");
        try {
            positions = Integer.parseInt(in.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nHow many tries should there be? ");
        int maxTries = 8;
        try {
            maxTries = Integer.parseInt(in.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        masterMind game = new masterMind(colors, positions);
        //System.out.println(game.cases);

        while (again == 'y' || again == 'Y') {
            int CRPW = 0;
            int PACR = 0;
            int tries = 0;
            String[] colorsGuessed = new String[positions];
            System.out.println("Current guess is " +  game.guessToString());
            while (tries < maxTries) {
                System.out.println("How many white pegs are there?");
                try {
                    CRPW = Integer.parseInt(in.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }

                System.out.println("How many red pegs are there?");
                try {
                    PACR = Integer.parseInt(in.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                if (PACR == positions) {
                    break;
                }
                game.response(CRPW, PACR);
                System.out.println("\nColors guessed: ");
                //System.out.println(game.cases);
                try {
                    colorsGuessed = game.nextMove();
                    for (int i = 0; i < positions; i++) {
                        System.out.print(colorsGuessed[i] + (i == positions-1 ? "\n\n": ", "));
                    }
                }
                catch(IndexOutOfBoundsException e) {
                    System.out.println("There are no more cases to chose from!! Did you incorrectly enter peg feedback?");
                    break;
                }

                //System.out.println(game.guess);
                tries++;
            }
            if (PACR == positions) {
                System.out.println("\nThe computer won!!");
            }
            else if (tries == maxTries) {
                System.out.println("\nThe computer lost!!");
            }
            
            System.out.println("Do you want to play another game?");
            try {
                again = in.readLine().charAt(0);
            }
            catch(IOException g) {
                g.printStackTrace();
            }
            
            if (again == 'y' || again == 'Y') {
                System.out.println("Let's play another game!");
                game.newGame();
            }
            else {
                System.out.println("Goodbye!");
            }
        }
    }
}


 