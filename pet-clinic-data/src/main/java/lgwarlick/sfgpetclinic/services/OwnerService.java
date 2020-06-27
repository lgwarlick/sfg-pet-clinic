package lgwarlick.sfgpetclinic.services;

import lgwarlick.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
