package state;

import state.content.TransformerContext;
import state.state.FireState;
import state.state.MoveState;

public class Start {

    public static void main(String[] args) {

        TransformerContext context = new TransformerContext();

        FireState fireState = new FireState();
        MoveState moveState = new MoveState();

        context.setState(fireState);
        context.action();

        context.setState(moveState);
        context.action();

    }

}
