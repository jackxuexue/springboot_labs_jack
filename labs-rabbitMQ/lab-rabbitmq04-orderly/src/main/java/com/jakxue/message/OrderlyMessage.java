package com.jakxue.message;


import java.io.Serializable;

public class OrderlyMessage implements Serializable {
    public static final String QUEUE_BASE = "ORDER_QUEUE_";
    public static final String QUEUE_0 = QUEUE_BASE + "0";
    public static final String QUEUE_1 = QUEUE_BASE + "1";
    public static final String QUEUE_2 = QUEUE_BASE + "2";
    public static final String QUEUE_3 = QUEUE_BASE + "3";

    public static final int QUEUE_COUNT = 4;

    public static final String ORDER_EXCHANG = "ORDER_EXCHANGE";

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderlyMessage{" +
                "id=" + id +
                '}';
    }
}
