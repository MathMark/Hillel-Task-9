package com.hillel.mvc.springboot.dao.userRepository;

import com.hillel.mvc.springboot.dao.accountRepository.AccountRepository;
import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.User;
import com.hillel.mvc.springboot.model.mappers.userMapper.UserMapper;
import com.hillel.mvc.springboot.model.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Map<Integer, User> userMap = new ConcurrentHashMap<>();
    private int userId = 0;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUserById(int id) {
        return userMap.getOrDefault(id, null);
    }

    @Override
    public boolean update(int id, UserRequest updatedUser) {
        return update(id, userMapper.getUser(updatedUser));
    }

    @Override
    public boolean update(int id, User updatedUser) {
        User previous = userMap.get(id);
        if(previous == null){
            return false;
        }

        Account account = accountRepository.getMap().get(previous);
        if(account != null){
            account.setUser(updatedUser);
            accountRepository.update(account.getId(), account);
        }
        userMap.put(id, updatedUser);
        return true;
    }

    @Override
    public boolean delete(int id) {
        User userInMap = userMap.get(id);
        if(userInMap == null){
            return false;
        }

        Account account = accountRepository.getMap().get(userInMap);
        if(account != null){
            accountRepository.delete(account.getId());
        }
        userMap.remove(id);
        return true;
    }

    @Override
    public void save(UserRequest user) {
        save(userMapper.getUser(user));
    }

    @Override
    public void save(User user) {
        user.setId(userId);
        userMap.put(userId, user);
        userId++;
    }

    @Override
    public Map<Integer, User> getUserMap() {
        return userMap;
    }
}
