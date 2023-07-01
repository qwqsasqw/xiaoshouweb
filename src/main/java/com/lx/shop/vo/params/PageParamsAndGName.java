package com.lx.shop.vo.params;

import lombok.Data;

@Data
public class PageParamsAndGName {

    private int page=1;

    private int pageSize=4;

    private String gname;
}
