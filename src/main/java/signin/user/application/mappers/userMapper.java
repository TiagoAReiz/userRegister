package signin.user.application.mappers;

import org.springframework.stereotype.Component;
import signin.user.adapters.out.jpaEntities.userJpa;
import signin.user.application.dtos.userRequest;
import signin.user.core.entity.user;

@Component
public class userMapper {
    public user toEntity(userRequest u) {
        user user = new user();
        user.setName(u.name());
        user.setEmail(u.email());
        user.setPassword(u.password());
        return user;
    }
    public userJpa toJpaEntity(user u) {
        userJpa userJpa = new userJpa();
        if(u.getId()!=null){
            userJpa.setId(u.getId());
        }
        userJpa.setName(u.getName());
        userJpa.setEmail(u.getEmail());
        userJpa.setPassword(u.getPassword());
        return userJpa;
    }
    public user JpaToEntity (userJpa jp) {
        user user = new user();
        user.setId(jp.getId());
        user.setName(jp.getName());
        user.setEmail(jp.getEmail());
        user.setPassword(jp.getPassword());
        return user;
    }
}
