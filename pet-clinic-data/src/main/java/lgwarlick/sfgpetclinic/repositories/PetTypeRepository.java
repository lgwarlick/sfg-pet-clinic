package lgwarlick.sfgpetclinic.repositories;

import lgwarlick.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
