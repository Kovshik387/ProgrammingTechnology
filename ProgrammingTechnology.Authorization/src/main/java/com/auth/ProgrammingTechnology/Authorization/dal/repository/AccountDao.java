package com.auth.ProgrammingTechnology.Authorization.dal.repository;

import com.auth.ProgrammingTechnology.Authorization.dal.Context;
import com.auth.ProgrammingTechnology.Authorization.dal.infrastructure.IAccountDao;
import com.auth.ProgrammingTechnology.Authorization.dal.model.Account;
import org.hibernate.Session;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class AccountDao implements IAccountDao {

    @Override
    public void add(Account account) throws SQLException {
        var connection = Context.createDataSource().getConnection();

        PreparedStatement state = connection.prepareStatement("insert into accounts(name, email, password_hash, refresh_token, role_type) values (?,?,?,?,?)");
        state.setString(1,account.name);
        state.setString(2,account.email);
        state.setString(3,account.passwordHash);
        state.setString(4,account.refreshToken);
        state.setString(5,account.roleType);

        state.executeUpdate();
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public Account get(int id) {
        return null;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
