package com.hillel.mvc.springboot.model.mappers.userMapper;

import com.hillel.mvc.springboot.model.Gender;
import com.hillel.mvc.springboot.model.User;
import com.hillel.mvc.springboot.model.requests.UserRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class UserMapperImpl implements UserMapper {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public User getUser(UserRequest userRequest) {
        LocalDate birthDate = LocalDate.parse(userRequest.getBirthDate(), dateTimeFormatter);
        Gender gender = Gender.fromString(userRequest.getGender());

        return new User(0, userRequest.getLastName(),
                userRequest.getFirstName(),
                birthDate,
                gender);
    }
}
