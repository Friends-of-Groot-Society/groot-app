package com.friendsofgroot.app.controllers

import com.friendsofgroot.app.dto.UserDto
import com.friendsofgroot.app.models.Address
import com.friendsofgroot.app.models.Attribute
import com.friendsofgroot.app.models.Chain
import com.friendsofgroot.app.models.Metadata
import com.friendsofgroot.app.models.Nft
import com.friendsofgroot.app.models.NftAddress
import com.friendsofgroot.app.models.Role
import com.friendsofgroot.app.models.User
import com.friendsofgroot.app.security.AuthService
import com.friendsofgroot.app.service.UsersService
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class UsersControllerTest extends Specification {
    def testObj = new UsersController()
    def bcrypt = Mock(PasswordEncoder)
    def usersService = Mock(UsersService)
    def authService = Mock(AuthService)
    def expectedResult
    def setup() {

        testObj.bcrypt = bcrypt
        testObj.usersService = usersService
        testObj.authService = authService
    }

    @Unroll
    def "loginUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        authService.login(_) >> "loginResponse"

        when:
        expectedResult = testObj.loginUser(usernameOrEmail, password)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        password   | usernameOrEmail   || expectedResult
        "password" | "usernameOrEmail" || null
    }

    @Unroll
    def "registerUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        authService.register(_) >> "registerResponse"

        when:
        expectedResult = testObj.registerUser(email, password, firstName, lastName)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        firstName   | lastName   | password   | email   || expectedResult
        "firstName" | "lastName" | "password" | "email" || null
    }

    @Unroll
    def "createUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersService.createUser(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResult = testObj.createUser(userDto)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        userDto || expectedResult
        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || null
    }

    @Unroll
    def "getUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersService.getUser(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResult = testObj.getUser(userId)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        userId || expectedResult
        0      || null
    }

    @Unroll
    def "getUserByEmail"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersService.getUser(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResult = testObj.getUserByEmail(email)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        email   || expectedResult
        "email" || null
    }

    @Unroll
    def "getUsers"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersService.getUsers() >> [new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)]

        when:
        expectedResult = testObj.getUsers()

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        expectedResult << null
    }

    @Unroll
    def "updateUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersService.createUser(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResult = testObj.updateUser(userDto)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        userDto || expectedResult
        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || null
    }

    @Unroll
    def "deleteUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersService.getUser(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
        usersService.deleteUser(_) >> true

        when:
        expectedResult = testObj.deleteUser(userId)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        userId || expectedResult
        0      || null
    }
}

