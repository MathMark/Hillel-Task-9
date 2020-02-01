package com.hillel.mvc.springboot.controllers.api;

import com.hillel.mvc.springboot.dao.userRepository.UserRepository;
import com.hillel.mvc.springboot.model.User;
import com.hillel.mvc.springboot.model.requests.UserRequest;
import com.hillel.mvc.springboot.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userService.getAllUsers();

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
        User user = userService.getUserById(Integer.parseInt(userId));
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserRequest userRequest) {
        userService.save(userRequest);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable("userId") String userId, @RequestBody UserRequest userRequest) {
        userService.update(userRequest);

        //return new ResponseEntity((successfully) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") String userId) {
        userService.delete(Integer.parseInt(userId));

        return new ResponseEntity(HttpStatus.OK);
        //return new ResponseEntity((successfully) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
