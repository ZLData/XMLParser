package com.xy.lr.java.keji;

import com.xy.lr.java.keji.entity.Configuration;

/**
 * Created by hadoop on 11/10/16.
 */
public class XMLParserTest {
    public static void main(String[] args) {
        ConfigurationUtil xmlParser = new ConfigurationUtil();

        Configuration xmlDocument = xmlParser.parser("xml_format_file.xml");
    }
}
