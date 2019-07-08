/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.dataformat.xml

import org.junit.Test

/**
 *
 *
 * @author Feixu
 * @version $Id: XmlReadWriteTest.java, v 0.1 2018/7/1 Feixu Exp $
 */
class XmlReadWriteTest {
    static final String books = '''
    <response version-api="2.0">
        <value>
            <books>
                <book available="20" id="1">
                    <title>Don Xijote</title>
                    <author id="1">Manuel De Cervantes</author>
                </book>
                <book available="14" id="2">
                    <title>Catcher in the Rye</title>
                   <author id="2">JD Salinger</author>
               </book>
               <book available="13" id="3">
                   <title>Alice in Wonderland</title>
                   <author id="3">Lewis Carroll</author>
               </book>
               <book available="5" id="4">
                   <title>Don Xijote</title>
                   <author id="4">Manuel De Cervantes</author>
               </book>
           </books>
       </value>
    </response>
'''

    @Test
    void readBooks(){
        def response = new XmlSlurper().parseText(books)

        def titles = response.'**'.findAll{ node-> node.name() == 'title' }
    }

    @Test
    void readIt(){
        File file = new File("/Users/biml/Documents/idcos/服务目录/测试/服务目录接口测试.jmx")
        def jmeterDatas = new XmlSlurper().parse(file)
        // HTTPSampler.path
        // HTTPSampler.method
        Set<RequestMethod> array = new HashSet<>()
        def infos = jmeterDatas.'**'.findAll{
            it.name() == 'HTTPSamplerProxy' //&& (null != it['@HTTPSampler.path'] || null != it['@HTTPSampler.method'])
        }

        infos.each {
            def path = it.'**'.find{ it.name() == 'stringProp' && it['@name'] == 'HTTPSampler.path' }.text()
            def method = it.'**'.find{ it.name() == 'stringProp' && it['@name'] == 'HTTPSampler.method' }.text()
            def testName = it['@testname'].text()
            if (path && path.length() > 0) {
                array << new RequestMethod(method, path, testName)
            }
        }

        array.sort{a,b -> a.path <=> b.path}
        array.each {
            if (it){
                println it.toString()
            }
        }
    }

    static class RequestMethod {
        private String method;
        private String path;
        private String description;

        RequestMethod(String method, String path, String description) {
            this.method = method
            this.path = path
            this.description = description
        }

        String getMethod() {
            return method
        }

        void setMethod(String method) {
            this.method = method
        }

        String getPath() {
            return path
        }

        void setPath(String path) {
            this.path = path
        }

        String getDescription() {
            return description
        }

        void setDescription(String description) {
            this.description = description
        }

        boolean equals(o) {
            if (this.is(o)) return true
            if (getClass() != o.class) return false

            RequestMethod that = (RequestMethod) o

            if (description != that.description) return false
            if (method != that.method) return false
            if (path != that.path) return false

            return true
        }

        int hashCode() {
            int result
            result = (method != null ? method.hashCode() : 0)
            result = 31 * result + (path != null ? path.hashCode() : 0)
            result = 31 * result + (description != null ? description.hashCode() : 0)
            return result
        }


        @Override
        String toString() {
            return method + " " + path + " " + description
        }
    }
}
