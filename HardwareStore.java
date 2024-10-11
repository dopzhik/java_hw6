package Homework6;

import java.io.Serializable;
import java.util.Objects;


public abstract  class HardwareStore implements Serializable {
    short id = 1111;
    double price;
    String manufacturer;
    

    

    public HardwareStore(double price, String manufacturer) {
        this.price = price;
        this.manufacturer = manufacturer;
        this.id = ++id;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + Objects.hashCode(this.price);
        hash = 31 * hash + Objects.hashCode(this.manufacturer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HardwareStore other = (HardwareStore) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return Objects.equals(this.manufacturer, other.manufacturer);
    }

    

    

    

}
