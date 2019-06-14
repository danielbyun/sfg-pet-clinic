package guru.springframework.sfgpetclinic.service;

import java.security.acl.Owner;
import java.util.Set;

public interface OwnerService {
    Owner findBYLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
