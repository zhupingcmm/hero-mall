package com.hero.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: pzhu
 * @Date: 2023/6/26 10:19
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    private Long total;
    private List<T> rows;

}
