package com.lx.shop.vo.params;

import lombok.Data;

@Data
public class GoodsInfoParam {

    private Integer gid;
    private String gimg;
    private String gname;
    private String type;
    private String gbName;
    private String gdesc;
    private Double gprice;
    private Double gcurrent;
    private Integer gsales;
    private Double gweight;
    private Integer gstock;

}
