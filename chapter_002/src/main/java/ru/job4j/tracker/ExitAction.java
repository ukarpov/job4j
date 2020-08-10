package ru.job4j.tracker;

public class ExitAction extends AbstractAction {

    public ExitAction(int key) {
        super(key, "=== Exit ===");
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
