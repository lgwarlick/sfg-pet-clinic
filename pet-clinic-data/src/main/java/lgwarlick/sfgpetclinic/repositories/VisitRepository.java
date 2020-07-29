package lgwarlick.sfgpetclinic.repositories;

import lgwarlick.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
