package signin.user.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import signin.user.adapters.out.jpaEntities.userJpa;

@Component
public interface userJpaRepository extends JpaRepository<userJpa,Long> {
    userJpa findByEmail(String email);
}
