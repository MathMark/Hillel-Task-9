package com.hillel.mvc.springboot.service.userService;

import com.hillel.mvc.springboot.dao.userRepository.UserRepository;
import com.hillel.mvc.springboot.model.User;
import com.hillel.mvc.springboot.model.mappers.userMapper.UserMapper;
import com.hillel.mvc.springboot.model.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public UserRequest getUserRequestById(int id) {
        User user = userRepository.getUserById(id);
        return userMapper.getUserRequest(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void save(UserRequest userRequest) {
        User user = userMapper.getUser(userRequest);
        System.out.println(user);
        userRepository.save(user);
    }

    @Override
    public void update(UserRequest userRequest) {
        User user = userMapper.getUser(userRequest);
        userRepository.update(userRequest.getId(), user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int userId) {
        userRepository.delete(userId);
    }
}
