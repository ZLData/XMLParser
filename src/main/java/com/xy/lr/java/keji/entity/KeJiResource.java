package com.xy.lr.java.keji.entity;

import org.dom4j.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 科技厅系统初始配置项
 * Created by hadoop on 11/11/16.
 */
public class KeJiResource implements Serializable{
    //source or destination
    private String sourceValue;

    //1 or 2
    private int type;

    //存储文献库、人才库等等信息
    private String name;

    //数据库信息
    private List<DataSource> dataSources;

    /**
     * 构造函数
     */
    public KeJiResource() {
        this.sourceValue = "null";
        this.type = 0;
        this.name = "null";
        this.dataSources = new ArrayList<DataSource>();
    }

    /**
     * 设置信息
     * @param element element
     */
    public void setKeJiResource(Element element) {
        this.sourceValue = element.getName();
        this.name = element.attributeValue("value");

        List<Element> dSources = new ArrayList<Element>();
        Iterator it = element.elementIterator();
        while (it.hasNext()) {
            Element tmpElement = (Element) it.next();

            if(tmpElement.getName().equals("type")){
                this.type = Integer.valueOf(tmpElement.attributeValue("value"));

                //dataSource
                Iterator tmpIt = tmpElement.elementIterator();
                while(tmpIt.hasNext()) {
                    Element dSElement = (Element) tmpIt.next();
                    if(dSElement.getName().equals("datasource")){
                        dSources.add(dSElement);
                    }
                }
            }
        }

        for(Element element1 : dSources){
            DataSource dataSource = new DataSource();
            dataSource.setDataSource(element1);

            this.dataSources.add(dataSource);
        }
    }
}
