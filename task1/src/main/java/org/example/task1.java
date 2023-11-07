package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            array.add(i);
        }
        List<Integer> path = new ArrayList<>();
        path.add(1);
        int index = 0;
        while(true){
            index = (index + m - 1) % n;
            if(index == 0){
                break;
            }
            path.add(array.get(index));
        }
        System.out.println(path);
    }
}