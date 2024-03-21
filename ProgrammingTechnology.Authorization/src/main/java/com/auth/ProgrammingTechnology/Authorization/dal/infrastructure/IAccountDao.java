package com.auth.ProgrammingTechnology.Authorization.dal.infrastructure;

import com.auth.ProgrammingTechnology.Authorization.dal.model.Account;

import java.sql.SQLException;
import java.util.Collection;

public interface IAccountDao {
    public void add(Account account) throws SQLException;
    public void update(Account account);
    public Account get(int id);
    public Collection getAll();
    public void delete(int id);
}
