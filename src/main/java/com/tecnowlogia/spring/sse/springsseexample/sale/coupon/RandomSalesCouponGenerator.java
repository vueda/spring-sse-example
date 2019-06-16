package com.tecnowlogia.spring.sse.springsseexample.sale.coupon;

import com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.Coupon;
import com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.StorePos;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

import static com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.randomizers.RandomStorePosGenerator.getStorePos;
import static com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.randomizers.RandomVendorGenerator.getRandomVendor;

@Component
public class RandomSalesCouponGenerator {

    private static final double MIN_AMOUNT = 1.15;
    private static final double MAX_AMOUNT = 70.99;

    private static final double MAX_QUANTITY = 7.890;
    private static final double MIN_QUANTITY = 0.250;

    public Coupon generateRandomCoupon() {

        StorePos storePos = getStorePos();

        return new Coupon(
                getRandomVendor(),
                getRandomAmount(),
                getRandomQuantity(),
                storePos
        );
    }

    private BigDecimal getRandomQuantity() {
        double quantity = ThreadLocalRandom.current().nextDouble(MIN_QUANTITY, MAX_QUANTITY);
        return BigDecimal.valueOf(quantity).setScale(2, RoundingMode.HALF_DOWN);
    }

    private BigDecimal getRandomAmount() {
        double amount = ThreadLocalRandom.current().nextDouble(MIN_AMOUNT, MAX_AMOUNT);
        return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_DOWN);
    }

}
