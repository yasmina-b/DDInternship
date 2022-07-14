package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.VariantAssignedValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantAssignedValueRepository extends JpaRepository <VariantAssignedValue, Integer> { }
