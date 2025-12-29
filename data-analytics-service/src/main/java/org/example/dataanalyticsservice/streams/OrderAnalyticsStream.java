package org.example.dataanalyticsservice.streams;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.KeyValue;
import org.example.dataanalyticsservice.events.OrderCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class OrderAnalyticsStream {

    @Bean
    public KStream<String, OrderCreatedEvent> kStream(StreamsBuilder builder) {
        KStream<String, OrderCreatedEvent> stream = builder.stream("orders-topic",
                Consumed.with(new Serdes.StringSerde(), new JsonSerde<>(OrderCreatedEvent.class)));

        TimeWindows window = TimeWindows.ofSizeWithNoGrace(Duration.ofSeconds(5));

        KTable<Windowed<String>, Long> orderCount = stream
                .groupByKey()
                .windowedBy(window)
                .count();

        KTable<Windowed<String>, Double> orderTotal = stream
                .groupByKey()
                .windowedBy(window)
                .aggregate(
                        () -> 0.0,
                        (key, order, aggregate) -> aggregate + order.getTotalPrice(),
                        Materialized.with(Serdes.String(), Serdes.Double())
                );

        orderCount.toStream()
                .map((windowedKey, count) -> KeyValue.pair(windowedKey.key(), count))
                .to("orders-count-topic", Produced.with(Serdes.String(), Serdes.Long()));

        orderTotal.toStream()
                .map((windowedKey, total) -> KeyValue.pair(windowedKey.key(), total))
                .to("orders-total-topic", Produced.with(Serdes.String(), Serdes.Double()));

        return stream;
    }
}
