package com.lx.shop.dao.pojo;

import lombok.Data;

@Data
public class Recharge {

    private String traceNo;
    private Double totalAmount;
    private String subject;
    private String alipayTraceNo;
    private String returnUrl;
}
