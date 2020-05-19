package com.edgar.neo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Blog implements Serializable {

    private Integer bid;
    private String name;
    private Integer authorId;

}
