package com.bz.dto;

import lombok.Data;

@Data
public class DeptDto {

    private Integer id;

    private Integer parentId;

    private String checkArr = "0";

    private String title;
}
