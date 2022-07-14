package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeRepository extends JpaRepository <ProductAttribute, Integer> { }