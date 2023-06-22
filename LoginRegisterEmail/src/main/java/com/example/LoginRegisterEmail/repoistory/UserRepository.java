package com.example.LoginRegisterEmail.repoistory;

import com.example.LoginRegisterEmail.entities.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Configuration
@Repository
@EnableJpaRepositories(basePackages="repository.package", entityManagerFactoryRef="emf")
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);


}
