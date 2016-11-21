package com.xy.lr.java.keji.entity;

import org.dom4j.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 系统启动初始配置文件 Configuration
 * Created by hadoop on 11/10/16.
 */
public class Configuration implements Serializable {
    //
    private List<KeJiResource> keJiResource;

    /**
     * 构造函数
     */
    public Configuration(){
        this.keJiResource = new ArrayList<KeJiResource>();
    }

    public void setConfiguration(Element xmlDocumentRoot){
        //遍历Document中的所有数据
        Iterator rootIt = xmlDocumentRoot.elementIterator();

        while(rootIt.hasNext()) {
            Element tmpElement = (Element) rootIt.next();

            KeJiResource keJi = new KeJiResource();
            keJi.setKeJiResource(tmpElement);

            this.keJiResource.add(keJi);
        }
    }

    /**
     *
     * @return
     */
    public List<KeJiResource> getKeJiResource() {
        return keJiResource;
    }

    /**
     *
     * @param keJiResource
     */
    public void setKeJiResource(List<KeJiResource> keJiResource) {
        this.keJiResource = keJiResource;
    }
}
