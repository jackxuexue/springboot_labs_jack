package com.jackxue.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class DemoMessage implements Serializable {

    public static final String QUEUE = "CONCURRENT_QUEUE";
    public static final String EXCHANGE = "CONCURRENT_EXCHANGE";
    public static final String ROUTE_KEY = "CONCURRENT_ROUTING_KEY";

    private Long id;
}
