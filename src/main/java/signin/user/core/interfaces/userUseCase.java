package signin.user.core.interfaces;

import signin.user.application.dtos.userRequest;
import signin.user.core.entity.user;

import java.util.List;

public interface userUseCase {
    user getUser(Long id);
    List<user> getAllUsers();
    void create(userRequest u);
    void update(userRequest u, Long id);
    void delete(Long id);
}
