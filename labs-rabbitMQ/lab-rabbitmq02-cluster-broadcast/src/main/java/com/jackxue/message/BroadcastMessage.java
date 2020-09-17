package com.jackxue.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class BroadcastMessage implements Serializable {
    public static final String QUEUE = "QUEUE_BROADCAST";

    public static final String EXCHANGE = "EXCHANGE_BROADCAST";

    /**
     * 编号
     */
    private Long id;
}
