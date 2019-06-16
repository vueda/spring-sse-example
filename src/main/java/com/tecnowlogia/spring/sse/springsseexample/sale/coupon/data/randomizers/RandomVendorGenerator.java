package com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.randomizers;

import com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.Vendor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomVendorGenerator {

    private static final List<Vendor> VENDORS = Arrays.asList(
            getVendor("Spider Man", 1),
            getVendor("Doctor Strange", 2),
            getVendor("Captain America", 3),
            getVendor("Iron Man", 4),
            getVendor("Captain Marvel",5),
            getVendor("Scarlet Witch", 6),
            getVendor("Thor", 7),
            getVendor("Black Widow", 8),
            null);

    private static Vendor getVendor(String name, int vendorKey) {
        return new Vendor(name, vendorKey);
    }

    public static Vendor getRandomVendor() {
        return VENDORS.get(ThreadLocalRandom.current().nextInt(VENDORS.size()));
    }
}
