package com.UserService.Repo;

import com.UserService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long> {

     Optional<User> findByemail(String email);
}
