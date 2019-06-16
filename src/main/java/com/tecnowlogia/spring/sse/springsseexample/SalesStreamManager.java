package com.tecnowlogia.spring.sse.springsseexample;

import com.tecnowlogia.spring.sse.springsseexample.sale.coupon.data.Coupon;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

import java.time.Duration;

@Service
public class SalesStreamManager {

    private final FluxProcessor<Coupon, Coupon> processor;
    private final FluxSink<Coupon> sink;

    public SalesStreamManager() {
        processor = DirectProcessor.<Coupon>create().serialize();
        sink = processor.sink();
    }

    void notifySale(final Coupon coupon) {
        sink.next(coupon);
    }

    Flux<ServerSentEvent<Coupon>> listenSales(int storeKey) {
        return processor
                .filter(c -> c.isFromStore(storeKey))
                .filter(Coupon::hasVendor)
                .map(c -> ServerSentEvent
                        .builder(c)
                        .event("sales-event")
                        .retry(Duration.ofSeconds(20))
                        .build());
    }
}
