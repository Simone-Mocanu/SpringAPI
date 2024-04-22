package com.example.api.repositories;

import com.example.api.models.UserModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
  List<UserModel> findByName(String name);
}
