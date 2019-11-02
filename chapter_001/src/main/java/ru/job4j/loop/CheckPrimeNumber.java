package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int num) {
        boolean prime = true;

        for (int i=2; i<=num; i++) {
            if((i != num)&&(num%i==0)){
                prime = false;
                break;
            }
        }

        return prime;
    }

}
