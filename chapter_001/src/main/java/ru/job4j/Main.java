package ru.job4j;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello, job4j!");

        byte age = 38;

//- пол
        char gender = 'M';

//- рост
        short height = 172;

//- количество кирпичей для постройки дома
        int bricksNum = 123456789;

//- количество бактерий
        long bacterium = 987654321;

//- расстояние до космических объектов
        double marsDistance = 225_000_000;

//- разрешение на работу
        boolean workPermit = true;

//- размер файла.
        long fileSize = 83_772_309;
	    
	    if (Double.MAX_VALUE > Long.MAX_VALUE) System.out.println("Double");

    }
}
