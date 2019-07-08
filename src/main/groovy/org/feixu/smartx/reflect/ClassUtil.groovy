/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.reflect

/**
 *
 *
 * @author Feixu
 * @version $Id: ClassUtil.java, v 0.1 2018/3/21 Feixu Exp $
 */
class ClassUtil {
    static void printFields(){
        def fieldsWithQuotationMarksdArray = []
        def fieldsArray = []
        String.declaredFields.sort{a,b -> return a.name <=> b.name }.each {
            if(it.name != "serialVersionUID") {
                fieldsArray << it.getName()
                fieldsWithQuotationMarksdArray << "\"${it.name}\""
            }
        }
//println fieldsWithQuotationMarksdArray.join(",")

        fieldsArray.each {
            println "srvInst.get${it[0].toUpperCase()}${it[1..-1]}(),"
        }
    }
}
