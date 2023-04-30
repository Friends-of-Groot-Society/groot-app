package com.friendsofgroot.app.util

import spock.lang.*
import java.sql.Connection

class JDBCConnectionTest extends Specification {
    def testObj = new JDBCConnection()
    def conn = Mock(Connection)
    def expectedResult
    def setup() {

        testObj.conn = conn
    }


    @Unroll
    def "getJDBCKey"() {
        when:
          expectedResult = JDBCConnection.getJDBCKey()

        then: "验证返回结果里属性值是否符合预期"
        if(expectedResult!=null) {
            with(expectedResult) {

            }
        }
        where: "表格方式验证多种分支调用场景"
        expectedResult << "expectedResult"
    }
}

