package com.hillel.mvc.springboot.service.userService;

import com.hillel.mvc.springboot.model.User;
import com.hillel.mvc.springboot.model.requests.UserRequest;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    UserRequest getUserRequestById(int id);
    User getUserById(int id);
    void save(UserRequest userRequest);
    void update(UserRequest userRequest);
    void update(User user);
    void delete(int userId);
}
