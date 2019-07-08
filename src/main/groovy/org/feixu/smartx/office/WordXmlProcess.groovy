/**
 *
 * http://www.idcos.com
 * Copyright (c) 2015 All Rights Reserved.
 */
package org.feixu.smartx.office

/**
 * word xml 处理类
 *
 * @author Feixu
 * @version $Id: WordXmlProcess.java, v 0.1 2017/10/16 Feixu Exp $$
 */
class WordXmlProcess {

    /**
     * 将word生成的不规则变量转为规则变量
     *
     * @param srcFile   word file in xml format
     * @param targetFile    word file processed
     * @param srcFileEncoding   source file encoding, default "UTF-8"
     * @param targetFileEncoding    target file encoding, default "UTF-8"
     */
    static void replaceVariables(String srcFile, String targetFile, String srcFileEncoding = "UTF-8", String targetFileEncoding = "UTF-8") {
        new File(srcFile).withReader(srcFileEncoding) { reader ->
            def map = [:]
            def content = reader.readLines().join("")
            def matcher = content =~ /\$\{(.*?)\}/
            def i = 1
            while (matcher.find()) {
                def value = matcher.group()
                def subMatcher = value.trim() =~ /(>(.*?)(<|\}))/
                def isSubMatch = false
                def trimedValue = new StringBuilder("")
                while (subMatcher.find()) {
                    def subValue = subMatcher.group(2)
                    trimedValue << subValue
                    isSubMatch = true
                }
                if (isSubMatch) {
                    def newValue = "${'${'}${trimedValue}${'}'}"
                    println "${i}:${newValue}"
                    map.put value, newValue
                } else {
                    println "${i}:${value}"
                }
                i++
            }

            map.each { key, value ->
                content = content.replace key, value
            }

            new File(targetFile).withWriter(targetFileEncoding) { writer ->
                writer.write(content)
            }
        }
    }

    /**
     * 验证是否已替换完毕
     *
     * @param srcFile   word source file, xml format
     * @param srcFileEncoding   source file encoding, default "UTF-8"
     */
    static void validateVariables(String srcFile, String srcFileEncoding = "UTF-8") {
        new File(srcFile).withReader(srcFileEncoding) { reader ->
            def content = reader.readLines().join("")
            def matcher = content =~ /\$\{(.*?)\}/
            def i = 1
            def ret = true
            while (matcher.find()) {
                def value = matcher.group()
                def isMatch = value ==~ /\$\{[0-9 a-z A-Z \.]+?\}/
                println "${i}:${isMatch}:${value}" // /\$\{.*(>|<).*\}/
                ret = ret & isMatch
                if(!ret){
                    throw new Exception("not match ${value}")
                }
                i++
            }
        }
    }
}
