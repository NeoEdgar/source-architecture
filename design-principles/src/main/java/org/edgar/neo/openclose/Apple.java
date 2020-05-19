package org.edgar.neo.openclose;

import java.math.BigDecimal;

public class Apple implements IFruit {

    private Integer id;
    private String name;
    private BigDecimal price;

    public Apple(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
