package signin.user.core.interfaces;

import signin.user.core.entity.user;

import java.util.List;

public interface userRepository {
    user findById(Long id);
    user findByEmail(String email);
    List<user> findAllUsers();
    void save(user u);
    void delete(Long id);
}
