package com.lx.shop.vo.params;

import lombok.Data;

@Data
public class GoodsParam {

   private Integer gid;
   private String gname;
   private Integer gstock;
   private Double gprice;
   private Double gcurrent;
   private String gimg;
   private String gdesc;
   private Integer gsales;
   private Double gweight;


}
