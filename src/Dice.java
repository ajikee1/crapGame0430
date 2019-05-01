//AJITH V KEERIKKATTIL - FINAL
//4/30/2019

import java.util.Random;

public class Dice {
    // Context class - current roll of the dice

    private int currentRoll;
    private State objState;

    public Dice() {
        objState = State.InitialState(this);
    }

    public void setState(State newState) {
        objState = newState;
    }

    public State getState() {
        return objState;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public void rollDice() {
        currentRoll = generateRoll();
        System.out.println("ROLLED A " + currentRoll);
        objState.roll_dice();
        
    }

    private int generateRoll() {
    	// Randomly generated number between 2-12
        Random rand = new Random();
        int low = 2;
        int high = 12;
        return rand.nextInt((high - low) + 1) + low;
    }
    

}
