package com.lx.shop.vo.params;

import lombok.Data;

@Data
public class PageParamCondition {

    private int page=1;

    private int pageSize=4;

    private Integer gclassId;

    private Integer gbrandId;

    private String sortFlag;
}
