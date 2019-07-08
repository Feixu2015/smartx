/**
 *
 * http://www.idcos.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package org.feixu.smartx.dataformat.yaml

import com.alibaba.fastjson.JSONObject
import org.junit.Test
import org.yaml.snakeyaml.Yaml

/**
 * Yaml Related
 *
 * @author Feixu
 * @version $Id: YamlTest.java, v 0.1 2018/7/2 Biminli Exp $
 */
class YamlTest {
    @Test
    void readYamlFromText(){
        Yaml yaml = new Yaml()
        def obj = yaml.load("""
data_relationship_template:
  pool_to_os_to_spec:
    cname: select_pool
    data: datasource_pool
    sub: 
      - select_spec:
        cname: select_spec
        data: datasource_spec
      select_os:
        data: datasource_os
""")
        println JSONObject.toJSONString(obj)
    }

    @Test
    void parseYamlText(){
        def abc = [
                a: 1,
                b: 2,
                c: [
                        [
                                a1: 1,
                                a2: 2
                        ],
                        [
                                a1: 3,
                                a2: 4
                        ]
                ]
        ]
        Yaml yaml = new Yaml()
        def obj = yaml.dump(abc)
        println obj
    }
}
