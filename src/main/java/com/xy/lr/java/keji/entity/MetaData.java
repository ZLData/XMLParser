package com.xy.lr.java.keji.entity;

import java.io.Serializable;

/**
 * 表结构
 * Created by hadoop on 11/10/16.
 */
public class MetaData implements Serializable {
    //列名
    private String name;

    //类型
    private String type;

    //长度
    private String length;

    /**
     * 构造函数
     */
    public MetaData() {
        this.name = "null";
        this.type = "null";
        this.length = "null";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
