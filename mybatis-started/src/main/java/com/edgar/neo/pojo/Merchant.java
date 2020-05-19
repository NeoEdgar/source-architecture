package com.edgar.neo.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Merchant {

    private Long id;
    private String name;
    private String businessScope;
    private List<Integer> scopeList;

}
