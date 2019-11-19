package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Получение заявки по id
     * @param id - ИД заявки
     * @return Найденный элемент. Если элемент не найден - возвращает null
     */
    public Item findById(String id) {
        Item result = null;
        int idx = findIndexById(id);
        if (idx >= 0) {
            result = this.items[idx];
        }
        return result;
    }

    /**
     * Заменяет ячейку в массиве по id
     * @param id
     * @param item
     * @return Возвращает true если операция выполнена успешно, иначе false
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int idx = findIndexById(id);
        if (idx >= 0) {
            this.items[idx] = item;
            result = true;
        }
        return result;
    }

    /**
     * Удаление заявки
     * @param id
     * @return Возвращает true если операция выполнена успешно, иначе false
     */
    public boolean delete(String id) {
        boolean result = false;
        int idx = findIndexById(id);
        if (idx >= 0) {
            System.arraycopy(this.items, idx + 1, this.items, idx, this.items.length - idx - 1);
            // ставим null для хвоста массива
            for (int i = this.position; i < this.items.length; i++) {
                this.items[i] = null;
            }
            this.position--;
            result = true;
        }
        return result;
    }

    public Item[] findAll() {
        Item[] result = new Item[this.position];
        System.arraycopy(this.items, 0, result, 0, result.length);
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Поиск индекса элемента в массиве по id элемента
     * @param id - идентификатор заявки
     * @return Индекс элемента в массиве. Если не найден, то -1
     */
    private int findIndexById(String id) {
        int index = -1;
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

//    получение списка всех заявок - public Item[] findAll();
//    получение списка по имени - public Item[] findByName(String key);
//            4. Метод public Item[] findAll() возвращает копию массива this.items без null элементов;
//5. Метод public Item[] findByName(String key) проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName класса Item) с аргументом метода String key. Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
// тесты
// findById - сравнение с null
//    получение списка всех заявок - public Item[] findAll();
//    получение списка по имени - public Item[] findByName(String key);
}
