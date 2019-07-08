/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.reflect

import groovy.json.JsonBuilder
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RequestMapping
/**
 *
 *
 * @author Feixu
 * @version $Id: AnnotationUtil.java, v 0.1 2018/3/26 Feixu Exp $
 */
class AnnotationUtil {
    void test(){
        def array = []
        def basePath = String.class.getAnnotation(RequestMapping.class).value()[0]
        String.class.declaredMethods.each {
            RequestMapping requestMapping = it.getAnnotation(RequestMapping.class)
            ApiOperation apiOperation = it.getAnnotation(ApiOperation.class)

            array << [
                    action: requestMapping.method()[0],
                    path: "${basePath}${requestMapping.value()[0]}",
                    description: apiOperation.value()
            ]
        }
        def json = new JsonBuilder(array)
        println json.toPrettyString()
    }
}
