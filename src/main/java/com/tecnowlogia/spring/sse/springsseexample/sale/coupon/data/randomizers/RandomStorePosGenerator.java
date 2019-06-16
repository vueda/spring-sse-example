package com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.randomizers;

import com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.StorePos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStorePosGenerator {

    private static final Map<Integer, List<Integer>> posByStore = new HashMap<>();

    static {
        posByStore.put(1, Arrays.asList(10, 11));
        posByStore.put(2, Arrays.asList(2, 22));
    }

    public static StorePos getStorePos() {
        Integer store = getStore();
        Integer pos = getPos(store);
        return new StorePos(store, pos);
    }

    private static Integer getPos(Integer store) {
        List<Integer> pos = posByStore.get(store);
        return pos.get(ThreadLocalRandom.current().nextInt(pos.size()));
    }

    private static Integer getStore() {
        return ThreadLocalRandom.current().nextInt(1,3);
    }
}
