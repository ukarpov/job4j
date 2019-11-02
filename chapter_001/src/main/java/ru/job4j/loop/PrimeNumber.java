package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;

        for (int i=2; i<=finish;i++){
            boolean is_prime = true;
            for (int j=2; j<=9; j++) {
                if((j != i)&&(i%j==0)){
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) {
                count++;
            }
        }

        return count;
    }
}
