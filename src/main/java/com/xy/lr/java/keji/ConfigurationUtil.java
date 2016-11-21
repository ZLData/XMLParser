package com.xy.lr.java.keji;

import com.xy.lr.java.keji.entity.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Created by hadoop on 11/10/16.
 */
public class ConfigurationUtil {
    //创建SAXReader的对象saxReader
    private SAXReader saxReader;

    //xml 文件对象
    private Document document;

    /**
     * 构造函数
     */
    public ConfigurationUtil () {
        saxReader = new SAXReader();
    }

    /**
     * 给定一个输入路径，解析xml数据，得到XMLDocument对象
     * */
    public Configuration parser(String filePath) {
        //通过saxReader对象的
        try {
            document = saxReader.read( new File( filePath ) );
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //通过 document 对象获取根节点 rootElement
        Element xmlDocumentRoot = document.getRootElement();

        //XMLDocument 对象
        Configuration conf = new Configuration();
        //设置内容
        conf.setConfiguration(xmlDocumentRoot);

        return conf;
    }

    /**
     * 输出XMLDocument对象中所有的数据信息
     * */
    public void printAll(Configuration xmlDocument) {
//        xmlDocument.printAll();
    }

    /**
     * 获得分词列表
     *
    public ChineseWordSegment wordSegment(XMLDocument xmlDocument) {
        //分词的结果
        ChineseWordSegment chineseWordSegment = new ChineseWordSegment();

        //得到文档的内容
        Content content = xmlDocument.getContent();
        //得到文档中的所有句子
        ArrayList<Sentence> sentences = content.getSentences();
        //得到所有的Token列表
        ArrayList<Token> tokenList = getTokenList(sentences);
        //获得分词的结果
        chineseWordSegment.setWordSegmentList(tokenList);

        return chineseWordSegment;
    }*/

    /**
     * 获得所有的一级Token列表
     *
    private ArrayList<Token> getTokenList(ArrayList<Sentence> sentences) {
        //所有的一级Token列表
        ArrayList<Token> tokenList = new ArrayList<Token>();
        //遍历所有的Sentence
        for(Sentence sentence : sentences) {
            ArrayList<Token> token = sentence.getTokens();
            tokenList.addAll(token);
//			System.out.println( sentence.getSentenceNumber() + "\t" + sentence.getTokens().size());
        }

        return tokenList;
    }*/
}
