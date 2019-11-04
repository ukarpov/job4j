package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;

        for(int i=word.length-1,j=post.length-1; j>=0 && result; i--,j--){
            result &= (word[i]==post[j]);
        }

        return result;
    }
}
