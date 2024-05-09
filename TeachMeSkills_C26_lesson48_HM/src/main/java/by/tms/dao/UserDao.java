package by.tms.dao;

import by.tms.entity.Operation;
import by.tms.entity.NewUser;

import java.util.List;

public interface UserDao {
    void save(NewUser user);
    NewUser findByUsername(String username);
    List<Operation> findAllOperationsByUsername(String username);
}
