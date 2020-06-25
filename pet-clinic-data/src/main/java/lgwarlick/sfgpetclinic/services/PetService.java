package lgwarlick.sfgpetclinic.services;

import lgwarlick.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByID(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
