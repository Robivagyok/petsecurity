package hu.petREST.controllers;

import hu.petREST.domain.Owner;
import hu.petREST.domain.Pet;
import hu.petREST.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping("/pets")
    public List<Pet> getPets(){
        return service.getPets();
    }
    @PostMapping("/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet addPet(@Valid @RequestBody Pet pet){
        return service.addPet(pet);
    }
}
