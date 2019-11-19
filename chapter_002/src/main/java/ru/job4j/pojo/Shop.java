package ru.job4j.pojo;

public class Shop {

    /**
     *
     * Сроздает новый массив, в котором нет удаляемого элемента
     *
     * @param products - Массив элементов
     * @param index - индекс удаляемого элемента
     * @return Новый массив без удаленного элемента
     */
    public Product[] delete(Product[] products, int index) {
        Product[] result = new Product[products.length - 1];
        for (int i = 0; i < result.length; i++) {
            if (i < index) {
                result[i] = products[i];
            } else {
                result[i] = products[i + 1];
            }
        }
        return result;
    }

    /**
     *
     * Присваивает удаляемому элементу значение null и сдвигает в конец массива
     *
     * @param products - Массив элементов
     * @param index - индекс удаляемого элемента
     */
    public void remove(Product[] products, int index) {
        for (int i = index; i < products.length; i++) {
            if (i + 1 >= products.length) {
                products[i] = null;
            } else {
                products[i] = products[i + 1];
            }
        }
    }

    public static void printProducts(Product[] p) {
        for (int index = 0; index < p.length; index++) {
            Product pr = p[index];
            if (pr != null) {
                System.out.println(pr.getName() + " - " + pr.getCount());
            } else {
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);

        Product[] prods = new Product[3];

        prods[0] = milk;
        prods[1] = bread;
        prods[2] = egg;

        System.out.println("All products");
        printProducts(prods);

        Shop sh = new Shop();
        Product[] noBread = sh.delete(prods, 1);
        System.out.println();
        System.out.println("After delete index=1");
        printProducts(noBread);

        sh.remove(prods, 1);
        System.out.println();
        System.out.println("After remove index=1");
        printProducts(prods);

    }
}
