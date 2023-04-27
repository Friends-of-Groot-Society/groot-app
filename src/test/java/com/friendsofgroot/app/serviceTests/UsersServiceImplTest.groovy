package com.friendsofgroot.app.serviceTests

import com.friendsofgroot.app.dto.RegisterDto
import com.friendsofgroot.app.dto.UserDto

import com.friendsofgroot.app.models.Address
import com.friendsofgroot.app.models.Attribute
import com.friendsofgroot.app.models.Chain
import com.friendsofgroot.app.models.Metadata
import com.friendsofgroot.app.models.Nft
import com.friendsofgroot.app.models.NftAddress
import com.friendsofgroot.app.models.Role
import com.friendsofgroot.app.models.User
import com.friendsofgroot.app.repositories.UserAccountRepository
import com.friendsofgroot.app.repositories.UsersRepository
import com.friendsofgroot.app.service.UsersServiceImpl
import spock.lang.*

class UsersServiceImplTest extends Specification {
    def testObj = new UsersServiceImpl()
    def usersRepository = Mock(UsersRepository)
    def userMapper = Mock(UserMapper)
    def userAccountRepository = Mock(UserAccountRepository)
    def expectedResult
    def setup() {

        testObj.usersRepository = usersRepository
        testObj.userMapper = userMapper
        testObj.userAccountRepository = userAccountRepository
    }

    @Unroll
    def "createUserCLI"() {
        when:
        expectedResultt = testObj.createUserCLI(user)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        user                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 || expectedResult
        new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>) || new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "registerUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.registerUser(registerDto)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        registerDto                                                               || expectedResult
        new RegisterDto("username", "lastName", "firstName", "email", "password") || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "loginUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersRepository.findByUsernameOrEmail(_, _) >> null
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.loginUser(usernameOrEmail, password)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        password   | usernameOrEmail   || expectedResult
        "password" | "usernameOrEmail" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "createUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.createUser(user)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        user || expectedResult
        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "getUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.getUser(id)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        id || expectedResult
        0  || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "getUser2"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersRepository.findByEmail(_) >> null
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.getUser(email)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        email   || expectedResult
        "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "getUsers"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersRepository.findAll() >> [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)]

        when:
        expectedResultt = testObj.getUsers()

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        expectedResult << [new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)]
    }

    @Unroll
    def "getUserByEmailAndPassword"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersRepository.findByEmailAndPassword(_, _) >> null
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.getUserByEmailAndPassword(email, pw)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        pw   | email   || expectedResult
        "pw" | "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "getUserByEmail"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersRepository.findByEmail(_) >> null
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.getUserByEmail(email)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        email   || expectedResult
        "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "getUsersWithCoins"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersRepository.findAll() >> [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)]

        when:
        expectedResultt = testObj.getUsersWithCoins()

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        expectedResult << [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)]
    }

    @Unroll
    def "getUserByPassword"() {
        when:
        expectedResultt = testObj.getUserByPassword(username, password)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        password   | username   || expectedResult
        "password" | "username" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "updateUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.updateUser(change)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        change || expectedResult
        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "deleteUser"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersRepository.findByEmail(_) >> null

        when:
        expectedResultt = testObj.deleteUser(email)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        email   || expectedResult
        "email" || true
    }

    @Unroll
    def "deleteUser2"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        usersRepository.findByEmail(_) >> null

        when:
        expectedResultt = testObj.deleteUser(user)

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        user || expectedResult
        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || true
    }

    @Unroll
    def "getUserChains"() {
        given: "设定相关方法入参"

        and: "Mock相关接口返回"
        userAccountRepository.getUserChains() >> [null]

        when:
        expectedResultt = testObj.getUserChains()

        then: "验证返回结果里属性值是否符合预期"
        with(expectedResult) {

        }
        where: "表格方式验证多种分支调用场景"
        expectedResult << [null]
    }
}

