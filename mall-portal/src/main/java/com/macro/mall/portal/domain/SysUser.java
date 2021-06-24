package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.SessionSynchronization;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public enum age{
        zsw(12),
        ztyj(123);

        int age;

        age(int age) {
            this.age = age;
        }

        age(){
            System.out.println("-----调用无参数------");
        }

       public static void a(){
            System.out.println("a");
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("com.macro.mall.portal.domain.SysUser$age");
        Field[] fields = c.getFields();
        System.out.println(fields[1].getName()+"-------------"+fields[1].getType());
        Method[] methods = c.getMethods();
        System.out.println(methods[0]);
        System.out.println(c.getDeclaredMethods()[0]);
        Method a = c.getMethod("a");
        a.setAccessible(true);
        a.invoke(c.newInstance()); // 反射不能调用枚举类的私有构造器


    }
}

