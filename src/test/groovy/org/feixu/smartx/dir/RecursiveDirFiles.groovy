/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.dir

import groovy.json.JsonBuilder
import org.junit.Test
/**
 * @author Feixu
 * @version $Id: RecursiveDirFiles.java, v 0.1 2018/2/9 Feixu Exp $$
 */
public class RecursiveDirFiles {
    def PROJECT_NAME = "yylm-fcs-iaas-flow-script"
    private String PATH = "D:\\hf\\sources\\${PROJECT_NAME}\\"
    @Test
    void fileRead(){
        def json = new JsonBuilder()
        def array = []
        listAll(PATH, array)
        json{
            files(array)
        }
        new File("D:\\hf\\sources\\${PROJECT_NAME}.json").withWriter {
            it.write(json.toPrettyString())
        }
    }

    def listAll(path, array) {
        def file = new File(path)
        if (file.isDirectory()) {
            file.listFiles().each { subFile ->
                if(![".git",".mvn", ".idea", ".DS_Store"].contains(subFile.getName()) && "target" != subFile.absolutePath.replace(PATH, "")) {
                    //def targetFile = new File(target+file.absolutePath.replace(path,"")).mkdirs()
                    listAll(subFile.absolutePath, array)
                }
            }
        } else {
            println file.absolutePath
            array << [
            path   : file.absolutePath.substring(PATH.length()),
                    content: "${file.getText("UTF-8")}"
            ]
        }
    }

    private String basePath = '/Users/biml/Documents/idcos/服务目录/code/hf-srv-catalog/'
    @Test
    void listAllFiles(){
        println("| path | file | operation |\n| ---- | ---- | ---- |")
        listAllPaths("${basePath}src/")
    }

    def listAllPaths(path) {
        def file = new File(path)
        if (file.isDirectory()) {
            file.listFiles().each { subFile ->
                if(![".git",".mvn", ".idea", ".DS_Store"].contains(subFile.getName()) && "target" != subFile.absolutePath.replace(PATH, "")) {
                    //def targetFile = new File(target+file.absolutePath.replace(path,"")).mkdirs()
                    listAllPaths(subFile.absolutePath)
                }
            }
        } else {
            def absolutePath = file.absolutePath.substring(basePath.length())
            println("| ${absolutePath.replace(file.name, '')} | ${file.name} | |")
        }
    }

    @Test
    void joinIt(){
        def text = """<acronym>
<applet>
<basefont>
<big>
<center>
<dir>
<font>
<frame>
<frameset>
<noframes>
<strike>
<tt>"""
        def array = []
        text.eachLine {
            array << (it.replace('<', '').replace('>', ''))
        }
        println array.join(', ')
    }
}
