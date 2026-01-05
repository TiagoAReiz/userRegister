package signin.user.adapters.in.controllers;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import signin.user.application.dtos.httpResponse;
import signin.user.application.dtos.userRequest;
import signin.user.application.services.userService;
import signin.user.core.entity.user;
import signin.user.core.interfaces.userUseCase;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userUseCase userUseCase ;

    @GetMapping
    public ResponseEntity<List<user>> getUsers() {
        return ResponseEntity.ok().body(userUseCase.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<user> getUserById(@PathVariable Long id) {

        return ResponseEntity.ok().body(userUseCase.getUser(id));
    }
    @PostMapping
    public ResponseEntity<Void> addUser(@Valid @RequestBody userRequest user) {
        userUseCase.create(user);
        return ResponseEntity.ok().build();

    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody userRequest user, @PathVariable Long id) {
        userUseCase.update(user, id);
        return ResponseEntity.ok().build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userUseCase.delete(id);
        return ResponseEntity.ok().build();
    }
}
