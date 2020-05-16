package com.hl.multithreading;

import java.util.Scanner;

/**
 * @author Hailin
 * @date 2020/2/27
 */
public class Test {

    public static int getLastWordLength(String s){
        String[] strArray = s.split(" ");
        return strArray[strArray.length - 1].length();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";
        String s = "";
        int i = 0;
        int count = 0;
        while(input.hasNextLine()){
            if (i % 2 == 0) {
                str = input.nextLine().toUpperCase();
            } else {
                s = input.nextLine().toUpperCase();
                String[] strArray = str.split("");
                for (String s1 : strArray) {
                    if (s1.equals(s)) {
                        count++;
                    }
                }
                System.out.println(count);
                count = 0;
            }
            i++;
        }
    }
}
