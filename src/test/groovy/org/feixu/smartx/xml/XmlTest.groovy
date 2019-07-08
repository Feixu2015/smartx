/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.xml

import org.junit.Test
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

/**
 *
 *
 * @author Feixu
 * @version $Id: XmlTest.java, v 0.1 2018/7/18 Feixu Exp $
 */
class XmlTest {

    @Test
    void readIt() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance()
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder()
            File file = new File("flow.xml")
            Document doc = builder.parse(file)
            NodeList nodes = doc.getElementsByTagName("conditionExpression")
            for (int i = 0; i < nodes.length; i++) {
                println "index:${i}"
                String text = nodes.item(i).textContent
                Node sequenceFlow = nodes.item(i).parentNode
                println "content:${text}"
                println "parentNode:${sequenceFlow}"
            }
        } catch (e) {
            println e
        }

    }
}
