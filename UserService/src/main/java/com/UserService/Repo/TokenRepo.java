package com.UserService.Repo;

import com.UserService.Model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token,Long> {

    Token save(Token token);
    // we need to select token ghaving this value and isdeleted as false;
   Optional<Token> findByValueAndDeleted(String value , boolean isDeleted);
}

