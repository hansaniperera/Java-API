package com.first.test.persister;

import com.first.test.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserPersister extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM USER WHERE ID = :id", nativeQuery = true)
    Optional<User> findByUserId(@Param("id") Long id);

    @Query(value = "SELECT u FROM User u WHERE id = :id")
    Optional<User> findByUserIdHQL(@Param("id") Long id);
}
