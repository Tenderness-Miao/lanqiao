package com.example.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@ApiModel
public class User {
    @ApiModelProperty(value = "id", dataType = "integer",required = true)
    private Integer id;
    @ApiModelProperty(value = "用户名", dataType = "string", required = true)
    private String name;
    @ApiModelProperty(value = "年龄", dataType = "integer", required = true)
    private Integer age;
}