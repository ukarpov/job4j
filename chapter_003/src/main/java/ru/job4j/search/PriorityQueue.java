package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                break;
            } else {
                index++;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.remove(0);
    }

    public void print() {
        for (Task element : tasks) {
            System.out.println(element.getDesc());
        }
    }

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.put(new Task("4", 4));
        q.put(new Task("1", 1));
        q.put(new Task("3.2", 3));
        q.put(new Task("3.1", 3));
        q.put(new Task("3.3", 3));
        q.put(new Task("2", 2));
        q.print();
    }
}
