package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        int[] nums = readNumbersFromFile(filename);
        int moves = minMovesToEqualize(nums);
        System.out.println(moves);
    }
    public static int minMovesToEqualize(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int average = sum / nums.length;
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - average);
        }
        return moves;
    }
    public static int[] readNumbersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            int[] nums = new int[1000];
            while ((line = reader.readLine()) != null) {
                nums[count] = Integer.parseInt(line);
                count++;
            }
            int[] result = new int[count];
            System.arraycopy(nums, 0, result, 0, count);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return new int[0];
        }
    }
}