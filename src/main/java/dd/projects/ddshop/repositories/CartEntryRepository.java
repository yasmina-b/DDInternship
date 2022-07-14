package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartEntryRepository extends JpaRepository <CartEntry, Integer> { }