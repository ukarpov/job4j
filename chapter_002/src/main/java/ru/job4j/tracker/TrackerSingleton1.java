package ru.job4j.tracker;

import java.util.ArrayList;

public enum TrackerSingleton1 {
    INSTANCE;

    private final Tracker t;

    {
        t = new Tracker();
    }

    public Item add(Item item) {
        return t.add(item);
    }

    /**
     * Получение заявки по id
     * @param id - ИД заявки
     * @return Найденный элемент. Если элемент не найден - возвращает null
     */
    public Item findById(String id) {
        return t.findById(id);
    }

    /**
     * Заменяет ячейку в массиве по id
     * @param id
     * @param item
     * @return Возвращает true если операция выполнена успешно, иначе false
     */
    public boolean replace(String id, Item item) {
        return t.replace(id, item);
    }

    /**
     * Удаление заявки
     * @param id
     * @return Возвращает true если операция выполнена успешно, иначе false
     */
    public boolean delete(String id) {
        return t.delete(id);
    }

    /**
     * Возвращает массив заявок
     * @return новый массив не-null элементов
     */
    public ArrayList<Item> findAll() {
        return t.findAll();
    }

    /**
     * Поиск заявок по имени
     * @param key
     * @return Массив найденных элементов
     */
    public ArrayList<Item> findByName(String key) {
        return t.findByName(key);
    }

    /**
     * Удаление всех заявок из массива
     */
    public void clear() {
        t.clear();
    }
}
