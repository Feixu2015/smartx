/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx

import groovy.json.JsonSlurper
import org.junit.Test
/**
 *
 * @author Feixu
 * @version $Id: CloudResTest.java, v 0.1 2017/12/6 Feixu Exp $$
 */
class CloudResTest {
    @Test
    void abc(){
        def str = """{
            "clusterId": "57705162-2ebf-493a-a947-a280abf21d3b",
            "cpu": 1,
            "createMethod": "clone",
            "dataDisks": [
                1024
        ],
            "hostId": "15815f16-a35d-455d-b342-35b920ffd723",
            "memory": 1024,
            "networks": [
                {
                    "gateway": "192.168.1.1",
                    "ipInfo": "192.168.1.12",
                    "network": "6cdedd0e-b899-4a4d-9029-45069a90825d",
                    "subnetMask": "255.255.255.0"
                }
        ],
            "num": 2,
            "prefix": "123",
            "productId": "",
            "resPoolId": "b3cdc933-0a7a-4813-9410-12c4cd28df6d",
            "storageId": "0715b017-788f-4042-82b0-5039cc4e5b60",
            "vmId": "04f84c83-6667-42e4-b986-e995c99bb727",
            "isoFile": "[192.168.1.120]path/file.iso"
        }"""
        def abc = new JsonSlurper().parseText(str)
        abc.each{key,value ->
            println """
 /**
  *
  */
 private String ${key};"""
        }
    }
}
