/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matthew
 */
public class masterMind {
    int numCases = 1;
    int positions;
    int numColors;
    List<String> cases = new ArrayList<>();
    String guess;
    String[] colors;
    
    public masterMind(String[] pegColors, int numPegs) {
        positions = numPegs;
        numColors = pegColors.length;
        for (int o = 0; o < positions; o++) {
            numCases *= pegColors.length;
        }
        for (int i = 0; i < numCases; i++) {
            cases.add((new String(new char[positions]).replace("\0", "0") + Integer.toString(i,pegColors.length)).substring(Integer.toString(i, pegColors.length).length()));
        }
        
        guess = (new String(new char[positions]).replace("\0", "0") + Integer.toString(11)).substring(Integer.toString(11).length());
        colors = pegColors;
    }
    
    public void response(int colorsRightPositionWrong, int positionsAndColorRight) {
        // we need to compare the list with the last guess
        int CRPW = 0;
        int PACR = 0;
        List<String> toRemove = new ArrayList<>();
        List<Integer> blackPegPos = new ArrayList<>();
        List<Integer> whitePegPos = new ArrayList<>();
        if (positionsAndColorRight == positions) {
            return;
        }
        for (int i = 0; i < cases.size(); i++) {
            for (int pos = 0; pos < positions; pos++) {
                if (guess.charAt(pos)==cases.get(i).charAt(pos)) {
                    PACR++;
                    blackPegPos.add(pos);
                }
            }
            for (int pos2 = 0; pos2 < positions; pos2++) {
                for (int pos3 = 0; pos3 < positions; pos3++) {
                    if (!blackPegPos.contains(pos2) && !blackPegPos.contains(pos3) && !whitePegPos.contains(pos3)) {
                        if (guess.charAt(pos2) == cases.get(i).charAt(pos3)) {
                            CRPW++;
                            whitePegPos.add(pos3); // so as to not double count a white peg
                        }
                    }
                }
            }     
            
            if (CRPW != colorsRightPositionWrong || PACR != positionsAndColorRight) {
                toRemove.add(cases.get(i)); // elements to be rmoved
            }
            CRPW = 0;
            PACR = 0;
            blackPegPos.clear();
            whitePegPos.clear();
        }
        for (String elem : toRemove) {
            cases.remove(elem);  // physically remove elements
        }
    }
    
    
    public void newGame() {
        guess = (new String(new char[positions]).replace("\0", "0") + Integer.toString(11)).substring(Integer.toString(11).length());
        cases.clear();
        for (int i = 0; i < numCases; i++) {
            cases.add((new String(new char[positions]).replace("\0", "0") + Integer.toString(i,numColors)).substring(Integer.toString(i, numColors).length()));
        }
    } // Reset the game 
    
    public  String [] nextMove() {
        guess = cases.get(0);
        String[] guessString = new String[positions];
        for (int p = 0; p < positions; p++) {
            guessString[p] = colors[Character.getNumericValue( guess.charAt(p))];
        }
        return guessString;
    } 
    
    public String guessToString() {
        String guessString = "";
        for (int p = 0; p < positions; p++) {
            guessString += (p == 0 ? "" : ",") + (p == 0 ? "" : " ") + colors[Character.getNumericValue( guess.charAt(p))];
        }
        return guessString;
    }
    
}
