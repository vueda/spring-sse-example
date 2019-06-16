package com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

    private String vendorName;
    private Integer vendorKey;
}
