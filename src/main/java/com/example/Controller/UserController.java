//package com.example.Controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.model.Users;
//import com.example.repo.UsersRepo;
//
//@RestController
//@RequestMapping("/users")
//public class UsersController {
//
//    @Autowired
//    UsersRepo userRepo;
//
//    @GetMapping("/show")
//    public List<Users> showAllUsers() {
//        return userRepo.findAll();
//    }
//
//    @GetMapping("/show/{id}")
//    public Optional<Users> showUserById(@PathVariable Long id) {
//        return userRepo.findById(id);
//    }
//
//    @PostMapping("/add")
//    public void addUser(@RequestBody Users newUser) {
//        userRepo.save(newUser);
//    }
//
//    @PutMapping("/update/{id}")
//    public void updateUser(@RequestBody Users newUser, @PathVariable Long id) {
//        Optional<Users> userOld = userRepo.findById(id);
//        if (userOld.isPresent()) {
//            Users user = userOld.get();
//            user.setName(newUser.getName());
//            user.setEmail(newUser.getEmail());
//            user.setPassword(newUser.getPassword());
//            userRepo.save(user);
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        userRepo.deleteById(id);
//    }
//}

package com.example.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Booking;
import com.example.model.User;
import com.example.repo.UserRepo;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {
    @Autowired
    UserRepo ur;

    @GetMapping("/show")
    public List<User> show() {
        return ur.findAll();
    }

    @GetMapping("/readone/{id}")
    public Optional<User> showone(@PathVariable long id) {
        return ur.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        ur.save(user);
    }
   

    @PutMapping("/update/{id}")
    public void update(@RequestBody User u, @PathVariable long id) {
        Optional<User> userOld = ur.findById(id);
        userOld.ifPresent(user -> {
            user.setNumber(u.getNumber());
            user.setUser_name(u.getUser_name());
            user.setPassword(u.getPassword());
            user.setEmail(u.getEmail());
            user.setDob(u.getDob());
            user.setGender(u.getGender());
            ur.save(user);
        });
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        ur.deleteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginRequest) {
        User user = ur.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long id) {
        User user = ur.findById(id).orElse(null);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/booking")
    public ResponseEntity<Set<Booking>> getUserBookings(@PathVariable Long id) {
        User user = ur.findById(id).orElse(null);
        if (user != null) {
            return ResponseEntity.ok(user.getBookings());
        }
        return ResponseEntity.notFound().build();
    }
}








