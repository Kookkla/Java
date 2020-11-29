package com.example.demosping.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account getInfo(int id) {
        String sql = "select * from account where account_id=?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), new Object[]{id});
    }

}

class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setAccountName(rs.getString("account_name"));
        account.setAge(rs.getInt("age"));
        return account;
    }
}