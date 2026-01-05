package signin.user.application.services;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import signin.user.application.dtos.userRequest;
import signin.user.application.mappers.userMapper;
import signin.user.core.entity.user;
import signin.user.core.exceptions.UserAlreadyExistsException;
import signin.user.core.exceptions.UserNotFoundException;
import signin.user.core.interfaces.userRepository;
import signin.user.core.interfaces.userUseCase;

import java.util.List;

@Service
public class userService implements userUseCase {
    private final userRepository userRepository;
    private final userMapper userMapper;

    public userService(userRepository userRepository, userMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public user getUser(Long id) {
        user user = userRepository.findById(id);

        return user;
    }

    @Override
    public List<user> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public void create(userRequest u) {
        user userDb = userRepository.findByEmail(u.email());
        if (userDb != null) {
            throw new UserAlreadyExistsException();
        }
        userRepository.save(userMapper.toEntity(u));
    }

    @Override
    public void update(userRequest u, Long id) {
        user user = getUser(id);
        user.setName(u.name());
        user.setEmail(u.email());
        user.setPassword(u.password());
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        getUser(id);
        userRepository.delete(id);
    }
}
