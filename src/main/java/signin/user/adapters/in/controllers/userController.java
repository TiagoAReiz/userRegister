package signin.user.adapters.in.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import signin.user.application.dtos.httpResponse;
import signin.user.application.dtos.userRequest;
import signin.user.application.services.userService;
import signin.user.core.interfaces.userUseCase;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userUseCase userUseCase ;

    @GetMapping
    public ResponseEntity<httpResponse> getUsers() {
        userUseCase.getAllUsers();
        return ResponseEntity.ok().body("success");
    }
    @GetMapping
    public ResponseEntity<httpResponse> getUserById(@RequestParam Long id) {
        userUseCase.getUser(id);
        return ResponseEntity.ok().body("success");
    }
    @PostMapping
    public ResponseEntity<httpResponse> addUser(@Valid @RequestBody userRequest user) {
        userUseCase.create(user);
        return ResponseEntity.ok().body("success");
    }
    @PutMapping
    public ResponseEntity<httpResponse> updateUser(@RequestBody userRequest user, @RequestParam Long id) {
        userUseCase.update(user,id);
        return ResponseEntity.ok().body("success");
    }
    @DeleteMapping
    public ResponseEntity<httpResponse> deleteUser(@RequestParam Long id) {
        return ResponseEntity.ok().body("success");
    }
}
