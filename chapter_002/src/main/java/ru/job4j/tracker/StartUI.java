package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {

    private final Consumer<String> output;

    public StartUI(Consumer<String> output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        this.output.accept("Menu.");
        for (UserAction action : actions) {
            this.output.accept(actions.indexOf(action) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>(List.of(
                new CreateAction(0),
                new ShowAllAction(1),
                new EditItemAction(2),
                new DeleteItemAction(3),
                new FindItemByIdAction(4),
                new FindItemByNameAction(5),
                new ExitAction(6))
        );
        new StartUI(System.out::println).init(input, tracker, actions);
    }
}
