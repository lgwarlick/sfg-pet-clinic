package lgwarlick.sfgpetclinic.repositories;

import lgwarlick.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
