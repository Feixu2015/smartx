package org.feixu.smartx.reflect

import groovy.json.JsonBuilder
import javassist.Modifier;
import org.junit.Test;

/**
 * @author Feixu
 * @version $Id: ClassUtilTest.java, v 0.1 2018/3/21 Feixu Exp $
 */
class ClassUtilTest {
    private String abc;
    private Integer ghf;

    @Test
    public void test1() {
        def fieldsWithQuotationMarksdArray = []
        def fieldsArray = []
        String.declaredFields.sort{a,b -> return a.name <=> b.name }.each {
            fieldsArray << it.getName()
            fieldsWithQuotationMarksdArray << "\"${it.name}\""
        }
//println fieldsWithQuotationMarksdArray.join(",")

        fieldsArray.each {
            println "srvInst.get${it[0].toUpperCase()}${it[1..-1]}(),"
        }
    }

    @Test
    void good(){
        Map<String, List<String>> typePropMap = new TreeMap<>();
        ClassUtilTest.declaredFields.each {
            if(it){
                if(!typePropMap.containsKey(it.type.simpleName)){
                    typePropMap.put(it.type.simpleName, new ArrayList<String>())
                }
                typePropMap.get(it.type.simpleName).add(it.name)
            }
        }
        def js = new JsonBuilder(typePropMap)
        println js.toPrettyString()
    }

    @Test
    void findUselessMethodsInImpl(){
        def className1 = SrvCatalogInstDAOImpl.class.name
        def className2 = SrvCatalogInstDAO.class.name
        SrvCatalogInstDAOImpl.declaredMethods.each {
            if (it && Modifier.isPublic(it.modifiers)) {
                def isMatch = false
                def methodName1 = it.name.replace(className1, '')
                SrvCatalogInstDAO.declaredMethods.each { dao ->
                    if (dao && Modifier.isPublic(dao.modifiers)) {
                        def methodName2 = it.name.replace(className2, '')
                        if (methodName1 == methodName2) {
                            isMatch = true
                        }
                    }
                }
                if (!isMatch) {
                    println 'not match:' + methodName1
                }
            }
        }
    }

    def declaredFieldsNotMath(Class a, Class b) {
        println "Class A:${a.simpleName}"
        println "Class B:${b.simpleName}"
        def fieldsNotMath = []
        a.declaredFields.each {
            if (it) {
                def isMatch = b.declaredFields.any{ innerIt ->
                    if (innerIt) {
                        if (it.name == innerIt.name) {
                            return true
                        }
                    }
                }
                if (!isMatch) {
                    fieldsNotMath << it.name
                }
            }
        }
        fieldsNotMath
    }

    @Test
    void generateBuilder(){
        print "inst";
        TaskInputDTO.declaredMethods.findAll{it.name.startsWith("set")}.each {
            println ".${it.name}()"
        }
    }
}