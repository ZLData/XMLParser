package com.xy.lr.java.keji.entity;

import org.dom4j.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 数据库表结构
 * Created by hadoop on 11/10/16.
 */
public class Table implements Serializable {
    //表名
    private String tableName;

    //表结构
    private List<MetaData> tableMetaDatas;

    /**
     * 构造函数
     */
    public Table() {
        this.tableName = "null";
        this.tableMetaDatas = new ArrayList<MetaData>();
    }

    /**
     * 设置表
     * @param element xml Element
     */
    public void setTable(Element element) {
        //设置表名
        this.tableName = element.attributeValue("name");

//        System.out.println("TableName : " + this.name);
        //遍历xml
        Iterator iterator = element.elementIterator();
        while(iterator.hasNext()) {
            Element tmpElement = (Element) iterator.next();
//            System.out.println("MetaName :" + tmpElement.getName());
            //设置表结构
            if(tmpElement.getName().equals("metadata")){
//                System.out.println("true");
                MetaData metaData = new MetaData();

                metaData.setName(tmpElement.attributeValue("name"));
                metaData.setType(tmpElement.attributeValue("type"));
                metaData.setLength(tmpElement.attributeValue("length"));

//                System.out.println("  MetaData : " + metaData.getName() + metaData.getType() + metaData.getLength());

                this.tableMetaDatas.add(metaData);
            }else {
                System.out.println("Error Table");
            }
        }
    }

    /**
     * 获得表名
     * @return 表名
     */
    public String getTableName() {
        return this.tableName;
    }

    /**
     * 获得表结构
     * @return 表结构
     */
    public List<MetaData> getTableMetaDatas() {
        return tableMetaDatas;
    }
}
