package com.jackxue.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClustingMessage implements Serializable {
    public static final String QUEUE = "QUEUE_CLUSTERING";

    public static final String EXCHANGE = "EXCHANGE_CLUSTERING";

    /**
     * 编号
     */
    private Integer id;
}
