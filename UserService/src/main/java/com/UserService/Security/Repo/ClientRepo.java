package com.UserService.Security.Repo;

import java.util.Optional;


import com.UserService.Security.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
}
