package state.content;

import state.state.TransformerState;

//state (состояние) - замена многосложным if-ам
public class TransformerContext implements TransformerState {

    private TransformerState state;

    public TransformerState getState() {
        return state;
    }

    public void setState(TransformerState state) {
        this.state = state;
    }

    public void action() {
        this.state.action();
    }

}
