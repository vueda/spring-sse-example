package com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

    private Vendor vendor;
    private BigDecimal value;
    private BigDecimal quantity;
    private StorePos storePos;

    public boolean isFromStore(int storeKey) {
        return storePos.isFromStore(storeKey);
    }

    public boolean hasVendor() {
        return vendor != null;
    }
}