/**
 *
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.smartx.findresult

import org.junit.Test

/**
 *
 * @author Feixu
 * @version $Id: IdeaFindResultManageTest.java, v 0.1 2018/2/10 Feixu Exp $$
 */
class IdeaFindResultManageTest {
    def data = '''const data = yield call(get, '/catalog/categoryTree/all')
const ret = yield call(get, '/catalog/auth/usergroup/all')
const ret = yield call(get, `/catalog/userGroup/${id}`)
const usergroups = await get('/catalog/auth/usergroups/approval')
const checkGroups = await get('/catalog/auth/userGroups/recheck')
let serviceTreeData = await get('/catalog/categoryTree/all')
20// let appTreeData = await get('/catalog/categoryTree/all') //获取应用ID
const ret = await get(`/catalog/srv/${action.payload.records.id}`)
type: `service/catalog/loading`
type: `service/catalog/load-success`,
const url = `/catalog/wf/template/${wfId}`
const ret = await post(`/catalog/inst/`, data)
const jobSpecRet = yield call(get, '/catalog/all/statistics');//当天任务分类占比
const ret = await post(`/catalog/inst/`, data)
put(`/catalog/srv/offline`,
put(`/catalog/srv/${node.id}/offline`).then(
const catalogUrl = `/catalog/auth/logout/${userId}`
api={`/catalog/inst/run/${srvNo}`}
return post('/catalog/inst/', data);
return post(`/catalog/inst/third/${srvcode}`, form);
const ret = await get(`/catalog/srv/${this.props.id}`)
datasource: '/catalog/wf/template',
return post('/catalog/v2/inst/srvinst', data)
return post('/catalog/all', data)
return get('/catalog/v2/inst/srvnum')
endpoints": ["/catalog/*"]
api={"/catalog/categoryTree/delete/" + node.id}
return post('/catalog/v2/inst/srvinst', data)
return post('/catalog/all', data)
return get('/catalog/v2/inst/srvnum')
window.open(`/catalog/inst/approvalinfo/page=${query.page}&limit=${query.limit}&keyword=${query.keyword}`)
datasource: "/catalog/inst/approvalinfo"
ret = await put(`/catalog/srv/updateSrvInfo/${self.props.records.id}`, {
ret = await post(`/catalog/srv/createSrvInfo`, data)
const ret = yield call(post, "/catalog/inst/srvinst", {});
const ret = yield call(post, "/catalog/inst/srvinst", {});
del(`/catalog/srv/delete`,
api={`/catalog/userGroup/${options.initialValue.id}`}
put(`/catalog/srv/release`,
api={`/catalog/categoryTree/update/${options.initialValue.id}`}
api={`/catalog/srv/${node.id}/delete`}
api={`/catalog/categoryTree/create`}
put(`/catalog/srv/${node.id}/release`).then(
return `/catalog/srv/all/${folderId}`
return `/catalog/srv/all/`
return post('/catalog/v2/inst/srvinst', data)
return post('/catalog/all', data)
return get('/catalog/v2/inst/srvnum')
/catalog/approval/${srvNo}?approvalStatus=${approvalStatus}&approvalIssue=${encodeURIComponent(
datasource: '/catalog/srv/all/',
const ret = yield call(get, `/catalog/srv/${action.payload.id}`);
type: `service-apply/catalog/loading`
type: `service-apply/catalog/load-success`,
41//   const ret = yield call(get, '/catalog/all')
62//   const ret = yield call(get, '/catalog/all')
const ret = yield call(post, "/catalog/inst/srvinst", {});
return post('/catalog/v2/inst/srvinst', data)
return post('/catalog/all', data)
return get('/catalog/auth/usergroup/all')
return get('/catalog/v2/inst/srvnum')
return post(`/catalog/userGroup/${id}`, form)
return get(`/catalog/userGroup/${id}`)
return get(`/catalog/v2/inst/srvinst/${instId}`)
return getWithArgs('/catalog/inst/findBySrvInstanceId', {
/catalog/approval/${srvNo}?approvalStatus=${approvalStatus}&approvalIssue=${encodeURIComponent(
return post(`/catalog/inst/run/${srvNo}`, {'''
    @Test
    void analyseUrlUsage(){
        def prefix = '/catalog/'
        def array = []
        def actions = ['post', 'get', 'put', 'del']
        println "| index | url | action |\n| ---- | ---- | ---- |"
        data.eachLine {
            if(it.length() > prefix.length()) {
                def prefixeIndex = it.indexOf(prefix)
                if (-1 != prefixeIndex) {
                    def temp = it.substring(prefixeIndex)
                    def beforePrefix = it.substring(0, prefixeIndex)
                    def action = ''
                    actions.each {
                        if (-1 != beforePrefix.lastIndexOf("${it}(")) {
                            action = it
                        }
                    }
                    def m = temp =~ "(/catalog/)(.*)?(`| ' |\")"
                    while (m.find()) {
                        def ret = "|${m.group(1)}${m.group(2)}|${action}|"
                        if (!array.contains(ret)) {
                            array << ret
                        }
                    }
                }
            }
        }
        def index = 0
        array.sort().each {
            index++
            println("|${index} ${it}")
        }
    }
}
