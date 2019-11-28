package ru.job4j.tracker;

public abstract class AbstractAction implements UserAction {
    private final int key;
    private final String name;

    protected AbstractAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }

    @Override
    public String name() {
        return this.name;
    }
}
