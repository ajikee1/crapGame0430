public class Win extends State {

    public Win(Dice dice) {
        super(dice);
    }

    public Win(State source) {
        super(source);
    }

    @Override
    public void transitionState() {
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

}
