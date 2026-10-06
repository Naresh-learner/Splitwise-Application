package com.naresh.splitwiseapp.repositories;

import com.naresh.splitwiseapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
     Optional<User> findById(Long aLong);
     Optional<User> findByPhone(String phone);
     User save(User user);

}
