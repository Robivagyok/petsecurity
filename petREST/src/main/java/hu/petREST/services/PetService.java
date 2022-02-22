package hu.petREST.services;

import hu.petREST.domain.Pet;
import hu.petREST.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;


    public List<Pet> getPets() {
        return repository.findAll();
    }
    public Pet addPet(Pet pet){
        return repository.save(pet);
    }
}
