package com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorePos {

    private Integer store;
    private Integer pos;

    boolean isFromStore(int storeKey) {
        return storeKey == store;
    }
}
