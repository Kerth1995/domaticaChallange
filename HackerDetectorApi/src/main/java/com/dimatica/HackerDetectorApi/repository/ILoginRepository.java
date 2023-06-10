package com.dimatica.HackerDetectorApi.repository;

import com.dimatica.HackerDetectorApi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILoginRepository extends JpaRepository<User, Integer> {

    public List<User> findByUsernameAndPassword(String username, String password);
}
