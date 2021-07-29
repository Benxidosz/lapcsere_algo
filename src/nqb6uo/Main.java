package nqb6uo;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Memory memory = new Memory();
        String line = scanner.nextLine();
        String[] splitted = line.split(",");
        for (String page : splitted) {
            memory.process(Math.abs(Integer.parseInt(page)));
        }
        System.out.print("\n");
        System.out.println(memory.error);
    }
}
