package com.friendsofgroot.app.serviceTests

import com.friendsofgroot.app.models.dto.RegisterDto
import com.friendsofgroot.app.models.dto.UserDto

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

class UsersServiceImplSpec extends Specification {
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
        expectedResult = testObj.createUserCLI(user)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        user                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 || expectedResult
        new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>) || new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "registerUser"() {
        given: "given"

        and: "_mock"
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.registerUser(registerDto)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        registerDto                                                               || expectedResult
        new RegisterDto("username", "lastName", "firstName", "email", "password") || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "loginUser"() {
        given: "given"

        and: "_mock"
        usersRepository.findByUsernameOrEmail(_, _) >> null
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.loginUser(usernameOrEmail, password)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        password   | usernameOrEmail   || expectedResult
        "password" | "usernameOrEmail" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "createUser"() {
        given: "given"

        and: "_mock"
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.createUser(user)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        user || expectedResult
        new UserDto (0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)


    }

    @Unroll
    def "getUser"() {
        given: "given"

        and: "_mock"
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.getUser(id)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        id || expectedResult
        0  || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "getUser2"() {
        given: "given"

        and: "_mock"
        usersRepository.findByEmail(_) >> null
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.getUser(email)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        email   || expectedResult
        "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "getUsers"() {
        given: "given"

        and: "_mock"
        usersRepository.findAll() >> [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)]

        when:
        expectedResultt = testObj.getUsers()

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        expectedResult << [new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)]
    }

    @Unroll
    def "getUserByEmailAndPassword"() {
        given: "given"

        and: "_mock"
        usersRepository.findByEmailAndPassword(_, _) >> null
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.getUserByEmailAndPassword(email, pw)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        pw   | email   || expectedResult
        "pw" | "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "getUserByEmail"() {
        given: "given"

        and: "_mock"
        usersRepository.findByEmail(_) >> null
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.getUserByEmail(email)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        email   || expectedResult
        "email" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "getUsersWithCoins"() {
        given: "given"

        and: "_mock"
        usersRepository.findAll() >> [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)]

        when:
        expectedResultt = testObj.getUsersWithCoins()

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        expectedResult << [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)]
    }

    @Unroll
    def "getUserByPassword"() {
        when:
        expectedResultt = testObj.getUserByPassword(username, password)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        password   | username   || expectedResult
        "password" | "username" || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "updateUser"() {
        given: "given"

        and: "_mock"
        userMapper.toDto(_) >> new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
        userMapper.toEntity(_) >> new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)

        when:
        expectedResultt = testObj.updateUser(change)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        change || expectedResult
        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>)
    }

    @Unroll
    def "deleteUser"() {
        given: "given"

        and: "_mock"
        usersRepository.findByEmail(_) >> null

        when:
        expectedResultt = testObj.deleteUser(email)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        email   || expectedResult
        "email" || true
    }

    @Unroll
    def "deleteUser2"() {
        given: "given"

        and: "_mock"
        usersRepository.findByEmail(_) >> null

        when:
        expectedResultt = testObj.deleteUser(user)

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        user || expectedResult
        new UserDto(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, "idToken", [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [null], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [new Role(0, "name", [null] as Set<User>)] as Set<Role>), 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [null], [new Role(0, "name", [null] as Set<User>)] as Set<Role>)])], [new Role(0, "name", [new User(0, "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, [new Address(0, "description", "email", "address", "chain", "iconUrl", "blockExplorerUrl", null, 0, new NftAddress(0, "address", 0d, 0d, 1.1f, [new Nft(0, "name", 0, new Metadata(0, "name", "description", "image", null, [new Attribute(0, "valu", "trait_type", null)]), null)]))], [new Chain(0, "name", "symbol", "description", "longDescription", "iconUrl", "category", "chainListIcon", "rpcUrl", 0, "blockExplorerUrl", [null])], [null] as Set<Role>)] as Set<User>)] as Set<Role>) || true
    }

    @Unroll
    def "getUserChains"() {
        given: "given"

        and: "_mock"
        userAccountRepository.getUserChains() >> [null]

        when:
        expectedResultt = testObj.getUserChains()

        then: "then"
        with(expectedResult) {

        }
        where: "where"
        expectedResult << [null]
    }
}
