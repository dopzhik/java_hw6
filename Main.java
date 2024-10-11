package Homework6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputLaptop lp = new InputLaptop();
        HashSet<Laptop> setLaptop = new HashSet<>();
        HashMap<String, Object> filters = new HashMap<>();
        boolean exitAdmin = true;
        boolean mainExit = true;
        boolean exitClient = true;
        boolean continueFiltering = true;

        HashMap<Integer, String> menuClient = new HashMap<>();
        menuClient.put(1, "Показать все модели");
        menuClient.put(2, "Поиск по критериям");
        menuClient.put(3, "Выход");

        HashMap<Integer, String> menuAdmin = new HashMap<>();
        menuAdmin.put(1, "Добавить данные");
        menuAdmin.put(2, "Сохранить данные");
        menuAdmin.put(3, "Показать все данные");
        menuAdmin.put(4, "Очистить данные");
        menuAdmin.put(5, "Выход");

        HashMap<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "Объем опертивной памяти");
        criteria.put(2, "Объем жесткого диска");
        criteria.put(3, "Производитель");
        criteria.put(4, "Цена");

        Scanner scanner = new Scanner(System.in);
        setLaptop = (HashSet<Laptop>) readFile();

        // Laptop lp01 = new Laptop(2500.00, "MSI", 512, 16);
        // Laptop lp02 = new Laptop(2300.00, "Samsung", 512, 8);
        // Laptop lp03 = new Laptop(2400.00, "Acer", 1028, 8);
        // Laptop lp04 = new Laptop(3000.00, "Apple", 512, 16);
        // Laptop lp05 = new Laptop(2500.00, "Asus", 512, 8);
        // Laptop lp06 = new Laptop(2100.00, "Lenovo", 256, 12);
        // Laptop lp07 = new Laptop(2800.00, "Huawei", 1028, 16);
        while (mainExit) {
            System.out.println("Введите команду => \n1 - если вы админ \n2 - если вы клиент \n3 - Выход");
            int command = scanner.nextInt();
            if (command <= 3 && command > 0) {
                switch (command) {

                    case 1:
                        while (exitAdmin) {
                            System.out.println("Введите соответствующую команду=> ");
                            for (Map.Entry<Integer, String> entry : menuAdmin.entrySet()) {
                                System.out.println(entry.getKey() + " - " + entry.getValue());
                            }

                            int command1 = scanner.nextInt();
                            if (command1 <= 5 && command1 > 0) {
                                switch (command1) {

                                    case 1 ->
                                        setLaptop.add(new Laptop(lp.inputPrice(), lp.inputManufacturer(), lp.inputCapacityHD(), lp.inputRAM()));
                                    case 2 -> {
                                        writeFile(setLaptop);
                                        setLaptop = (HashSet<Laptop>) readFile();
                                    }
                                    case 3 -> {
                                        for (Laptop set : setLaptop) {
                                            System.out.println(set);
                                        }
                                    }
                                    case 4 -> {
                                        clearFile();
                                        setLaptop = (HashSet<Laptop>) readFile();
                                    }
                                    case 5 ->
                                        exitAdmin = false;
                                    default -> {
                                    }
                                }

                            } else {
                                System.out.println("Введите число от 1 до 5 => ");
                            }

                        }
                        exitAdmin = true;
                        break;

                    case 2:
                        while (exitClient) {
                            System.out.println("Введите соответствующую команду=> ");
                            for (Map.Entry<Integer, String> entry : menuClient.entrySet()) {
                                System.out.println(entry.getKey() + " - " + entry.getValue());
                            }

                            int command2 = scanner.nextInt();
                            if (command2 <= 3 && command2 > 0) {
                                switch (command2) {
                                    case 1 -> {
                                        for (Laptop set : setLaptop) {
                                            System.out.println(set);
                                        }
                                    }
                                    case 2 -> {
                                        while (continueFiltering) {
                                            System.out.println("Введите цифру, соответствующую необходимому критерию => ");
                                            for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
                                                System.out.println(entry.getKey() + " - " + entry.getValue());
                                            }
                                            int criterion = scanner.nextInt();
                                            scanner.nextLine();
                                            switch (criterion) {
                                                case 1:
                                                    System.out.print("Введите минимальное значение объема оперативной памяти (в ГБ): ");
                                                    filters.put("ram", scanner.nextInt());
                                                    scanner.nextLine();
                                                    break;
                                                case 2:
                                                    System.out.print("Введите минимальное значение объема жесткого диска (в ГБ): ");
                                                    filters.put("hdd", scanner.nextInt());
                                                    scanner.nextLine();
                                                    break;
                                                case 3:
                                                    System.out.print("Введите производителя:");
                                                    filters.put("man", scanner.nextLine());
                                                    break;
                                                case 4:
                                                    System.out.print("Введите минимальную цену: ");
                                                    filters.put("price", scanner.nextInt());
                                                    scanner.nextLine();
                                                    break;
                                                default:
                                                    System.out.println("Некорректный критерий.");
                                            }
                                            System.out.print("Хотите добавить еще один критерий? (yes/no): ");
                                            // scanner.nextLine();
                                            String response = scanner.nextLine();
                                            System.out.println(response);                                           
                                            continueFiltering = response.equalsIgnoreCase("yes");
                                        }
                                        filterLaptops(setLaptop, filters);
                                        continueFiltering = true;

                                    }

                                    case 3 ->
                                        exitClient = false;
                                    default -> {
                                    }
                                }

                            } else {
                                System.out.println("Введите число от 1 до 3 => ");
                            }

                        }
                        exitClient = true;
                        break;
                    case 3:
                        mainExit = false;
                        break;
                    default:
                        break;

                }

            } else {
                System.out.println("Введите число от 1 до 3 => ");
            }
        }

    }

    public static void writeFile(HashSet<Laptop> set) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("laptop.dat"))) {
            oos.writeObject(set);
            System.out.println("Данные сохранены!");
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static Object readFile() {
        Object set = new HashSet<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("laptop.dat"))) {
            set = ois.readObject();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return set;
    }

    public static void clearFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("laptop.dat"))) {
            oos.writeObject(new HashSet<Laptop>());
            System.out.println("Данные очищены!");
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void filterLaptops(HashSet<Laptop> laptops, HashMap<String, Object> filters) {
        System.out.println("Список по вашим критериям:");
        for (Laptop laptop : laptops) {
            boolean matches = true;
            if (filters.containsKey("ram") && laptop.RAM < (int) filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("hdd") && laptop.capacityHD < (int) filters.get("hdd")) {
                matches = false;
            }
            if (filters.containsKey("man") && !laptop.manufacturer.equalsIgnoreCase((String) filters.get("man"))) {
                matches = false;
            }
            if (filters.containsKey("price") && laptop.price < (int) filters.get("price")) {
                matches = false;
            }
            if (matches) {
                System.out.println(laptop);
            }
        }
    }
    }
