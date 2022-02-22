package hu.petREST.services;

import hu.petREST.domain.Owner;
import hu.petREST.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    public Owner addOwner(Owner owner){
        return repository.save(owner);
    }

    public List<Owner> getOwners() {
        return repository.findAll();
    }

    public List<Owner> getOwnersInCity(String city) {
        return repository.getOwnersInCity(city);
    }

    public Owner updateOwner(int id, Owner o) {
        Optional<Owner> owner = repository.findById(id);
        if(owner.isPresent()){
            Owner updatedOwner = owner.get();
            updatedOwner.setAddress(o.getAddress());
            return repository.save(updatedOwner);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Owner getOwner(int id) {
        Optional<Owner> owner = repository.findById(id);
        if(owner.isPresent()){
            return owner.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
