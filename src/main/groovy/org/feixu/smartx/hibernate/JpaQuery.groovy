/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.hibernate

/**
 *
 *
 * @author Feixu
 * @version $Id: JpaQuery.java, v 0.1 2018/3/13 Feixu Exp $
 */
class JpaQuery {
    void jpaQueryFields2VOConstructorArgs(String fields){
        def resultArray = []
        fields.split(',').each {
            def data = it.replace(' ', '')
            def index = data.indexOf('.')
            resultArray << 'String ' + data.substring(index+1)
        }
        println resultArray.join(',\r\n')
    }
    void jpaQueryFields2VOConstructorSetter(String fields){
        fields.split(',').each {
            def data = it.replace(' ', '')
            def index = data.indexOf('.')
            println "this.${data.substring(index+1)} = ${data.substring(index+1)};"
        }
    }
}
