package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository <Subcategory, Integer> { }

