//package com.example.repo;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.model.Users;
//
//public interface UsersRepo extends JpaRepository<Users, Long> {
//}

package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);
}


