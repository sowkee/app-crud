package com.proyect.appcrud.Repository;

import com.proyect.appcrud.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User getUserById(long id);
}
