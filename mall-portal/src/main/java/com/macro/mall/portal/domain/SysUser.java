package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author zsw
 * @date 2021/5/11 14:17
 * @description : 测试mongo  的实体类
 */
@Document(collection = "sysUser") // 配置对应的mongo 集合
@Data
@ApiModel
public class SysUser implements Serializable {
    @Id
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
}
