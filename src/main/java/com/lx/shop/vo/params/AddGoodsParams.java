package com.lx.shop.vo.params;

import lombok.Data;

@Data
public class AddGoodsParams {

    private String gname;
    private Integer gclassId;
    private Integer gbrandId;
    private Integer gstock;
    private Double gprice;
    private Double gcurrent;
    private String gimg;
    private String gdesc;
    private Double gweight;

}
