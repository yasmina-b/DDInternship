package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueRepository extends JpaRepository <AttributeValue, Integer> { }