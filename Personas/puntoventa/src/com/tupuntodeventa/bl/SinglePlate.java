package com.tupuntodeventa.bl;

import java.util.Objects;

public class SinglePlate extends Product {
    private int price;
    private String descript;

    public SinglePlate(int code, int price, String descript) {
        super(code);
        this.price = price;
        this.descript = descript;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public String toString() {
        return "SinglePlate{" +
                "" + super.toString() +
                "price=" + price +
                ", descript='" + descript + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  SinglePlate)) return false;
        if (!super.equals(o)) return false;
        SinglePlate that = (SinglePlate) o;
        return super.equals(that);
    }
}
