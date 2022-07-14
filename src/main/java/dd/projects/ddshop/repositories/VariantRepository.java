package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository <Variant, Integer> { }