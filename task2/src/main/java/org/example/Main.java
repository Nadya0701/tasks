package org.example;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(System.in);
        String fileName1 = scanner1.nextLine();
        String fileName2 = scanner1.nextLine();
        File circleFile = new File(fileName1);
        File pointsFile = new File(fileName2);
        try (Scanner scanner = new Scanner(circleFile)) {
            float x = scanner.nextFloat();
            float y = scanner.nextFloat();
            float r = scanner.nextFloat();
            try (Scanner pointsScanner = new Scanner(pointsFile)) {
                while (pointsScanner.hasNextLine()) {
                    String[] coords = pointsScanner.nextLine().split(" ");
                    float x1 = Float.parseFloat(coords[0]);
                    float y1 = Float.parseFloat(coords[1]);
                    double d = Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
                    if (d < r) {
                        System.out.println(1);
                    } else if (d > r) {
                        System.out.println(2);
                    } else {
                        System.out.println(0);
                    }
                }
            }
        }
    }
}