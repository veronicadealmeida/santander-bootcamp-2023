package edu.vda.Santander.dev.controller;

import edu.vda.Santander.dev.domain.model.User;
import edu.vda.Santander.dev.repository.UserAllRepository;
import edu.vda.Santander.dev.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserAllRepository userAllRepository;


    public UserController(UserService userService, UserAllRepository userAllRepository) {
        this.userService = userService;
        this.userAllRepository = userAllRepository;
    }


    @GetMapping
    public @ResponseBody List<User> list() {
        return userAllRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
}