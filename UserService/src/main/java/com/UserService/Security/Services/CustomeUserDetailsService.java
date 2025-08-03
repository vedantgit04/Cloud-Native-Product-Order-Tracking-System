package com.UserService.Security.Services;

import com.UserService.Model.CustomUserDetails;
import com.UserService.Model.User;
import com.UserService.Repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
// why we are doing this - check config/securityconfig UserDetailService function
import java.util.Optional;

// what is the main difference between extends , implements and inheritance

// here we are buliding this custome userdetail service because we wants to check the user with the username exits in the db or not and then implements it with UserdetailService


@Service
public class CustomeUserDetailsService implements UserDetailsService {

    UserRepo userRepo;
    public  CustomeUserDetailsService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // username means email for us - unique name - by default it is username
        Optional<User>optionalUser = userRepo.findByemail(username);
        if(optionalUser.isEmpty()){
            throw  new UsernameNotFoundException("user with given" +username + "username/email not found");
        }
        User user = optionalUser.get();
        // we are doing this because this default userdetail is interface and we want object now
        // so we create an CustomUserDetails which implements UserDetails as class and then creating objects
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return customUserDetails;
    }
}
