package com.edgar.neo.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Fee {
    private Long id;
    private BigDecimal feeAmt;
    private LocalDate feeDate;
}
