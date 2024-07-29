package com.cmddotenter.WebLabProject.Rest;

import com.cmddotenter.WebLabProject.Entity.User;
import com.cmddotenter.WebLabProject.Service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;


    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        user.setId(0); // Ensure the ID is set to 0 to create a new user
        User savedUser = userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User tempUser = userService.getById(id);
        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + id);
        }
        userService.delete(id);
    }
    @GetMapping("/unauthorized")
    public ResponseEntity<String> unauthorized() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"Access to the API\"");
        return new ResponseEntity<>("Unauthorized", headers, HttpStatus.UNAUTHORIZED);
    }

}
