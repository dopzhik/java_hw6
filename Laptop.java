package Homework6;

import java.text.DecimalFormat;


public class Laptop extends HardwareStore {

    int capacityHD;
    int RAM;
    DecimalFormat df = new DecimalFormat("0.00");

    public Laptop(double price, String manufacturer, int capacityHD, int RAM) {
        super(price, manufacturer);
        this.capacityHD = capacityHD;
        this.RAM = RAM;

        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + manufacturer
                + ", Объем жесткого диска: " + capacityHD + " Гб"
                + ", Объем опертивной памяти: " + RAM + " Гб"
                + ", цена: " + df.format(price) + " рублей";
    }
}