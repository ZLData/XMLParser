package com.xy.lr.java.keji.entity;

import org.dom4j.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 源
 * Created by hadoop on 11/10/16.
 */
public class Source implements Serializable {
    private int type;

    private String name;

    private List<DataSource> dataSources;

    public Source() {
        this.type = 0;
        this.name = new String("null");
        this.dataSources = new ArrayList<DataSource>();
    }

    /**
     *
     * @param element
     */
    public void setSource(Element element) {
        this.name = element.attributeValue("value");
        System.out.println("  Source_type " + this.name);

        List<Element> dSources = new ArrayList<Element>();
        Iterator it = element.elementIterator();
        while (it.hasNext()) {
            Element tmpElement = (Element) it.next();

            System.out.println(tmpElement.getName() + "\t" + tmpElement.attributeValue("value"));
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

        System.out.println("dataSource_" + dSources.size());

        for(Element element1 : dSources){
            DataSource dataSource = new DataSource();
            dataSource.setDataSource(element1);

            this.dataSources.add(dataSource);
        }
    }
}
