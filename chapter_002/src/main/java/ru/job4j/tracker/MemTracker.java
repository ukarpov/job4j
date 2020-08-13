package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemTracker implements Store {
    private final ArrayList<Item> items = new ArrayList<>();

    @Override
    public void init() {
    }

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
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
            result = this.items.get(idx);
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
            item.setId(id);
            this.items.set(idx, item);
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
            this.items.remove(idx);
            result = true;
        }
        return result;
    }

    /**
     * Возвращает массив заявок
     * @return новый массив не-null элементов
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Поиск заявок по имени
     * @param key
     * @return Массив найденных элементов
     */
    public List<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item itm : this.items) {
            if (itm.getName().equals(key)) {
                result.add(itm);
            }
        }
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
        for (Item itm : this.items) {
            if (itm.getId().equals(id)) {
                index = this.items.indexOf(itm);
                break;
            }
        }
        return index;
    }

    /**
     * Удаление всех заявок из массива
     */
    public void clear() {
        this.items.clear();
    }

    @Override
    public void close() throws Exception {
    }
}
