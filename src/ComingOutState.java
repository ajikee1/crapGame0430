//AJITH V KEERIKKATTIL--
//4/30/2019

public class ComingOutState extends State {
	
    public ComingOutState(Dice dice) {
        super(dice);
    }

    public ComingOutState(State source) {
        super(source);
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

    @Override
    public void transitionState() {
    	
// ------------------------------------------------------------------------
// First roll of dice:
// 2,3, or 12 Loss ("craps")  
// 7 or 11 Win ("natural")
// any other (4,5,6,8,9,10) establishes "points"
// ------------------------------------------------------------------------
    	//If a 2 3, or 12 is rolled, loss
        if (getContext().getCurrentRoll() == 2 || getContext().getCurrentRoll() == 3 || getContext().getCurrentRoll() == 12) {
            System.out.print("(Craps)");
        	getContext().setState(new Loss(this));
        } else if (getContext().getCurrentRoll() == 7 || getContext().getCurrentRoll() == 11) {
        //If a 7 or 11 is rolled, win
            System.out.print("(Win)");
        	getContext().setState(new Win(this));
        } else {
            //If the number does not match the above, transition to the Point State
            System.out.print("(Point)");
            getContext().setState(new PointState(this));
        }

    }

}
