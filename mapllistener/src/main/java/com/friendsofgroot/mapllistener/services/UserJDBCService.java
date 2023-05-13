package com.friendsofgroot.mapllistener.services;

import com.friendsofgroot.mapllistener.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserJDBCService {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper;

    public UserJDBCService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        userRowMapper = (rs, rowNum) -> new User(rs.getLong("userId"), rs.getString("username"), rs.getString("password"), rs.getString("lastName"), rs.getString("firstName"), rs.getInt("userType"), rs.getString("phone"), rs.getString("email"), rs.getString("cusUrl"), rs.getString("photoPath"), rs.getInt("1"));
    }

//    public User byemail(String email) {
//        return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", userRowMapper, email);
////        return null;
//    }
//
//    public User byid(Long userid) {
//        return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE userid = ?", userRowMapper, userid);
////        return null;
//    }
//
//    public Collection<User> all() {
////		return this.jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("email"), rs.getString("password"), rs.getS
////        return this.jdbcTemplate.query("SELECT * FROM users", userRowMapper);
//return new ArrayList();
//    }
}
