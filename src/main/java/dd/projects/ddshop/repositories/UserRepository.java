package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

}
