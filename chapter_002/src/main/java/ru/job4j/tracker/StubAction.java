package ru.job4j.tracker;

public class StubAction extends AbstractAction {
    private boolean call = false;

    public StubAction(int key) {
        super(key, "Stub action");
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }

}
