package org.feixu.smartx.util

/**
 * param convert
 *
 * @author biml
 * @version $Id: MyUtil.java, v 0.1 2017/5/20 biml Exp $$
 */
class MyUtil {
    private def static convert(String json) {
        /*{
            "executionTypeCode": "OPENSTACK",
            "outBizNo": "881bb133-e141-4d97-86f5-8b7955255872",
            "outBizTypeCode": "someBizTypeCode",
            "description": "For Open Stack VM Create",
            "opCode": "HOST::ADAPTER::GET_TOKEN",
            "globalParams": "",
            "traceId": "20161213",
            "command": {
                "apiUrl": "http://55.15.4.128:35357/v2.0",
                "tenantId": "d5da224823724b4896a0f82f5024f1c1",
                "username": "liudong",
                "password": "E0YTQL8ZpmndfCYGwlpjZDeXVu4+qFtMQtna6z0PIAg=",
                "region": "pdcdev",

                "blockStorageV1Endpoint": "http://55.15.4.128:8776/v1/d5da224823724b4896a0f82f5024f1c1",
                "computeV2Endpoint": "http://55.15.4.128:8774/v2/d5da224823724b4896a0f82f5024f1c1",
                "networkV2Endpoint": "http://55.15.4.128:9696/v2.0",
                "tokenId": "b4da6a8df16548969222a5423fae2392",

                "adminPass": "dcgv8M4wceSUNizVEdW1XomrpQvswpO6Gd0K58zLI0w=",
                "flavorRef": "5b5bcca7-2ff2-4977-bbdf-510c8dea8c92",
                "systemVolumeImageId": "870ee92d-a303-487d-b3a5-3f75698f0174",
                "name": "201612031807",
                "ports": [
                        {
                            "portAdminStateUp": true,
                            "portNetworkId": "0cdd43d2-be3a-459f-a4c4-71c3e3bf2afa"
                        }
                ],

                "serverId": "dc73d845-08cb-463e-9169-b498b7c93c32"

            }
        }*/
        /*
        server {
            adminPass decryptedAdminPass
            networks [
                    {
                        uuid : {serverId}
                        port : {portNetworkId}

                    }
            ]
        }
        */

    }

    /**
     * 将数据库表名转为首词小写驼峰格式
     * @param tableName 数据库表名字符串
     * @return 首词小写驼峰格式字符串
     */
    def static tableNameToLowerCamel(tableName) {
        camelTrim(tableName, "_", "^_")
    }

    /**
     * 将数据库表名转为首词大写驼峰格式
     * @param tableName 数据库表名字符串
     * @return 首词大写驼峰格式字符串
     */
    def static tableNameToUpperCamel(tableName) {
        camelTrim(tableName, "_", "^_", false)
    }

    /**
     * 指定分隔符的字符串转为过滤分隔符后的首字母小写驼峰形式，
     * 例如 "Create_firewall_policies"转为"createFirewallPolicies"
     *
     * @param src 需要转换的字符串
     * @param pattern 分隔符 例如 \s
     * @param reversePattern 分隔符的反  \S
     * @param isFirstWordLower 是否首字母小写
     * @return
     */
    def static camelTrim(src, pattern, reversePattern, isFirstWordLower = true) {
        def isFirst = true
        src.replaceAll(/[$reversePattern]+/) {
            if (isFirst && isFirstWordLower) {
                isFirst = false
                it[0..-1].toLowerCase()
            } else {
                it[0].toUpperCase() + it[1..-1].toLowerCase()
            }
        }.replaceAll(/$pattern/, '')
    }

    /**
     * 深层拷贝
     * @param orig
     * @return
     */
    def static deepcopy(orig) {
        def bos = new ByteArrayOutputStream()
        def oos = new ObjectOutputStream(bos)
        oos.writeObject(orig); oos.flush()
        def bin = new ByteArrayInputStream(bos.toByteArray())
        def ois = new ObjectInputStream(bin)
        return ois.readObject()
    }
}
