package com.dimatica.HackerDetectorApi.repository;

import com.dimatica.HackerDetectorApi.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeguridadLogin extends JpaRepository<Login, Integer> {

}
