package com.friendsofgroot.app.util

import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

import java.sql.Connection
import static org.mockito.Mockito.*

class JDBCConnectionTest extends Specification {
    def testObj = new JDBCConnection()
    def conn = Mock(Connection)
    def expectedResult
    def setup() {

        testObj.conn = conn
    }

    @Unroll
    def "getConnection"() {
        when:
        expectedResult = JDBCConnection.getConnection()

        then: "验证返回结果里属性值是否符合预期"
        if(expectedResult!=null) {
            with(expectedResult) {

            }
        }
        thrown(NullPointerException)
        where: "表格方式验证多种分支调用场景"
        expectedResult << null
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

