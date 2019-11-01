package ru.job4j.condition;

public class SqMax {
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    //result = third; // first
                    result = first;
                }
            }
        } else if (second > third) {
            if (second > forth) {
                //result = first;
                result = second;
            }
        } else if (third > forth) {
            //result = second;
            result = third;
        }
        return result;
    }
}
