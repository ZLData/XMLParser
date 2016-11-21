package com.xy.lr.java.keji.entity;

import org.dom4j.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 数据库信息
 * Created by hadoop on 11/10/16.
 */
public class DataSource implements Serializable {
    //数据库地址
    private String url;

    //数据库用户名
    private String userName;

    //数据库密码
    private String passWord;

    //数据库名
    private String spaceName;

    //数据库中的表集和
    private List<Table> tables;

    /**
     * 构造函数
     */
    public DataSource() {
        this.url = "null";
        this.userName = "null";
        this.passWord = "null";
        this.spaceName = "null";

        this.tables = new ArrayList<Table>();
    }

    /**
     * 设置数据库信息
     * @param element element
     */
    public void setDataSource(Element element) {
        //设置数据库基本信息
        this.url = element.attributeValue("url");
        this.userName = element.attributeValue("username");
        this.passWord = element.attributeValue("password");
        this.spaceName = element.attributeValue("spacename");

//        System.out.println("url : " + this.url + " username : " + this.userName + "" +
//                " password : " + this.passWord + " spacename : " + this.spaceName);

        Iterator iterator = element.elementIterator();
        while (iterator.hasNext()) {
            Element tmpElement = (Element) iterator.next();

            //设置表
            if(tmpElement.getName().equals("table")) {
                Table table = new Table();
                table.setTable(tmpElement);

                this.tables.add(table);
            } else {
                System.out.println("Error DataSource");
            }

//            System.out.println(tmpElement.getName());
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
