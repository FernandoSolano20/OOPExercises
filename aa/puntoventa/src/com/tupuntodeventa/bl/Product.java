package com.tupuntodeventa.bl;

import java.util.Objects;

public class Product {
    private int code;

    public Product(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof  Product)) return false;
        Product product = (Product) o;
        return code == product.code;
    }
}
