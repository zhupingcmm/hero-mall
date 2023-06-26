package com.hero.goods.pojo;

import com.hero.util.BaseBean;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: pzhu
 * @Date: 2023/6/26 13:06
 */
@Getter
@Setter
@Table(name="tb_brand")
public class Brand extends BaseBean {

    @Id
    private Integer id;//品牌id
    private String name;//品牌名称
    private String image;//品牌图片地址
    private String letter;//品牌的首字母
    private Integer seq;//排序

}
