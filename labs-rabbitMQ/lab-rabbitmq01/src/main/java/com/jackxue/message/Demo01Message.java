package com.jackxue.message;

import lombok.Data;
import java.io.Serializable;

@Data
public class Demo01Message implements Serializable {
    public static final String QUEUE = "QUEUE_DEMO_01";
    public static final String EXCHANGE = "EXCHANGE_DEMO_01";
    public static final String ROUTING_KEY = "ROUTING_KEY_01";

    private int id;
}
