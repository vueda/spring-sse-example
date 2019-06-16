package com.tecnowlogia.spring.sse.springsseexample;

import com.tecnowlogia.spring.sse.springsseexample.sale.coupon.RandomSalesCouponGenerator;
import com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.Coupon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SalesCouponGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesCouponGenerator.class);

    private static final int TEN_SECONDS = 10000;
    private static final int DELAY_FIVE_SECONDS = 5000;

    private final SalesStreamManager salesStreamManager;
    private final RandomSalesCouponGenerator randomSalesCouponGenerator;

    public SalesCouponGenerator(SalesStreamManager salesStreamManager,
                                RandomSalesCouponGenerator randomSalesCouponGenerator) {
        this.salesStreamManager = salesStreamManager;
        this.randomSalesCouponGenerator = randomSalesCouponGenerator;
    }

    @Scheduled(fixedRate = TEN_SECONDS, initialDelay = DELAY_FIVE_SECONDS)
    public void generateCoupon() {
        Coupon newSale = randomSalesCouponGenerator.generateRandomCoupon();

        LOGGER.info("Sending new sale notification. {}", newSale);

        salesStreamManager.notifySale(newSale);

    }

}
