package signin.user.adapters.out.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import signin.user.adapters.out.jpaEntities.userJpa;
import signin.user.application.mappers.userMapper;
import signin.user.core.entity.user;
import signin.user.core.exceptions.UserNotFoundException;
import signin.user.core.interfaces.userRepository;

import java.util.List;

@Component
public class userRepositoryImpl implements userRepository {

    @Autowired
    private userJpaRepository userJpaRepository;
    @Autowired
    private userMapper userMapper;

    @Override
    public user findById(Long id) {
        return userMapper.JpaToEntity(userJpaRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }
    @Override
    public user findByEmail(String email) {
        userJpa user = userJpaRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        return userMapper.JpaToEntity(user);
    }

    @Override
    public List<user> findAllUsers() {
        return userJpaRepository.findAll().stream().map(userMapper::JpaToEntity).toList();
    }

    @Override
    public void save(user u) {
        userJpaRepository.save(userMapper.toJpaEntity(u));
    }



    @Override
    public void delete(Long id) {
        userJpaRepository.deleteById(id);
    }
}
