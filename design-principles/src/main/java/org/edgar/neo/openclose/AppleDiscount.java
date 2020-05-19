package org.edgar.neo.openclose;

import java.math.BigDecimal;

public class AppleDiscount extends Apple {

    public AppleDiscount(Integer id, String name, BigDecimal price) {
        super(id, name, price);
    }

//    @Override
//    public BigDecimal getPrice() {
//        return super.getPrice().multiply(new BigDecimal("0.6"));
//    }

    public BigDecimal getDiscountPrice(){
        return super.getPrice().multiply(new BigDecimal(0.6));
    }
}
