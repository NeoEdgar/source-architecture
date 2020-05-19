package org.edgar.neo.framework.aop.config;

import lombok.Data;

@Data
public class NeoAopConfig {
    private String pointCut;
    private String aspectClass;
    private String aspectBefore;
    private String aspectAfter;
    private String aspectAfterThrow;
    private String aspectAfterThrowingName;
}
