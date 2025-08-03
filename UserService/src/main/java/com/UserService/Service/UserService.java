package com.UserService.Service;

import com.UserService.Exceptions.InvalidPasswordException;
import com.UserService.Exceptions.InvalidTokenException;
import com.UserService.Model.Role;
import com.UserService.Model.Token;
import com.UserService.Model.User;
import com.UserService.Repo.RoleRepo;
import com.UserService.Repo.TokenRepo;
import com.UserService.Repo.UserRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder; // ADD THIS LINE

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
        @Autowired // auto wired is one of the type of dependency injection instead of calling parameteris contructor you can just simply write autwired
        private   UserRepo userRepo;
        @Autowired
        private PasswordEncoder bCryptPasswordEncoder;

        @Autowired
        private TokenRepo tokenRepo;

        @Autowired
        private RoleRepo roleRepo;
      // we are working with dtos in the service layer because ervice layer is not visible to user  that why we can direclty work with data
       public User SignUp(String name, String email, String password){
           Optional<User>optionalS = userRepo.findByemail(email);
           if(optionalS.isPresent()){
                return  null;
                // user is already present no need to signup
           }

           User user = new User();
           user.setEmail(email);
           user.setName(name);
           user.setHashedPassword(bCryptPasswordEncoder.encode(password));
           user.setIsEmailVerified("no");
           return userRepo.save(user);
       }

       public Token LogIn(String email,String password) throws InvalidPasswordException{
          // check if the user exist or not , if not through them to a sign up page;
           //if yes , compare the incomming password with password in the database
           // if password matches return the new token

           Optional<User> optionalUser = userRepo.findByemail(email);
           if(!optionalUser.isPresent()){
               // user is not present
               return null;
           }
           User user = optionalUser.get();
           if(!bCryptPasswordEncoder.matches(password, user.getHashedPassword())){
               // return and exception
               throw  new InvalidPasswordException("please enter the correct password");

           }

           // login successfull generate a new token
           Token token = generatenewtoken(user);
           Token savedtoken = tokenRepo.save(token);
           return savedtoken;
       }
      // it is not the self validating token , becuase we are generating completey random value;
       private Token generatenewtoken(User user){
           // you dont need to rememebr this code it is an template
           LocalDate currentTime = LocalDate.now(); // current time.
           LocalDate thirtyDaysFromCurrentTime = currentTime.plusDays(30);

           Date expiryDate = Date.from(thirtyDaysFromCurrentTime.atStartOfDay(ZoneId.systemDefault()).toInstant());

           Token token = new Token();
           token.setExpiredAt(expiryDate);

           //Token value is a randomly generated String of 128 characters.
           token.setValue(RandomStringUtils.randomAlphanumeric(128));
           token.setUser(user);

           return token;
       }

       public void LogOut(String tokenvalue) throws InvalidTokenException {
           // first check the give token is presnt in the db and is_delete == false
           Optional<Token> optionalToken = tokenRepo.findByValueAndDeleted(tokenvalue,false);

           if(optionalToken.isEmpty()){
               // token is not present
               throw new InvalidTokenException("token is not valid");
           }
           Token token =  optionalToken.get();
           token.setIsdeleted(true);
           tokenRepo.save(token);
          return;
       }

      public User ValidateToken(String token) throws InvalidTokenException {
           Optional<Token>optionalToken = tokenRepo.findByValueAndDeleted(token,false);
           if(optionalToken.isEmpty()){
               throw new InvalidTokenException("token is not valid");
           }

           return optionalToken.get().getUser();
      }

    public User assignRoleToUser(Long userId, Long roleId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        Optional<Role> optionalRole = roleRepo.findById(roleId);

        if (optionalUser.isEmpty() || optionalRole.isEmpty()) {
            // Or throw a more specific exception
            return null;
        }

        User user = optionalUser.get();
        Role role = optionalRole.get();

        // Get the list of roles and add the new one
        List<Role> userRoles = user.getRoles();
        userRoles.add(role);

        // Save the user, and JPA will update the user_roles table
        return userRepo.save(user);
    }

}
