//AJITH V KEERIKKATTIL
//4/30/2019

public class PointState extends State {
 	
    private int points_to_match;

    public PointState(State source) {
        super(source);
        points_to_match = source.getContext().getCurrentRoll();
    }

    public PointState(Dice dice) {
        super(dice);
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

    @Override
    public void transitionState() {
// ------------------------------------------------------------------------
// Second roll of dice:
// 7 Loss ("seven out")
// match of previous roll Win ("hits the points")
// any other, roll again
// ------------------------------------------------------------------------ 
    	
    	//if the current roll equals the result of the previous roll, win
        if (points_to_match == getContext().getCurrentRoll()) {
            getContext().setState(new Win(this));
        //If the current roll equals 7, loss   
        } else if (getContext().getCurrentRoll() == 7) {
            getContext().setState(new Loss(this));
        }
    }
}
