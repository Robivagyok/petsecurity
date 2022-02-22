package hu.petREST.repositories;

import hu.petREST.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>{

    @Query(value="SELECT * FROM owner WHERE address LIKE ?1%",nativeQuery = true)
    List<Owner> getOwnersInCity(String city);
}

