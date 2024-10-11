package Homework6;

import java.util.Scanner;

public class InputLaptop {

    int num = 0;
    String line = "";
    double dobl = 0.0;
    Scanner sc = new Scanner(System.in);
    Boolean isTrue = true;

    public int inputCapacityHD() {
        isTrue = true;
        System.out.println("Введите объем жесткого диска => ");
        while (isTrue) {
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                isTrue = false;

            } else {
                System.out.println("Вы ввели неверные данные, введите, пожалуйста, число=> ");
                sc.nextLine();
            }
        }
        return num;
    }

    public int inputRAM() {
        isTrue = true;
        System.out.println("Введите объем оперативной памяти=> ");
        while (isTrue) {
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                isTrue = false;

            } else {
                System.out.println("Вы ввели неверные данные, введите, пожалуйста, объем оперативной памяти=> ");
                sc.nextLine();
            }
        }
        return num;
    }

    public String inputManufacturer() {
        System.out.println("Введите производителя => ");
        return sc.nextLine();
    }

    public double inputPrice() {
        isTrue = true;
        System.out.println("Введите цену => ");
        while (isTrue) {
            if (sc.hasNextDouble()) {
                dobl = sc.nextDouble();
                sc.nextLine();
                isTrue = false;

            } else {
                System.out.println("Вы ввели неверные данные, введите, пожалуйста, цену=> ");
                sc.nextLine();
            }
        }
        return dobl;
    }

}
