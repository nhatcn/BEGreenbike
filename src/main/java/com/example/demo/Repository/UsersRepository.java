
package com.example.demo.Repository;

import com.example.demo.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    public Optional<Users> findByEmail(String email);
    public Optional<Users> findByUserName(String userName);

}