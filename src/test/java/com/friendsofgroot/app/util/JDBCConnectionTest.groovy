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

        then: "then"
        if(expectedResult!=null) {
            with(expectedResult) {

            }
        }
        thrown(NullPointerException)
        where: "where"
        expectedResult << null
    }

    @Unroll
    def "getJDBCKey"() {
        when:
          expectedResult = JDBCConnection.getJDBCKey()

        then: "then"
        if(expectedResult!=null) {
            with(expectedResult) {

            }
        }
        where: "where"
        expectedResult << "expectedResult"
    }
}

