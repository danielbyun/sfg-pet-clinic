package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Visit;

import java.util.Set;

public interface VisitService extends CrudService<Visit, Long> {
    Visit findById(Long id);

    Visit save(Visit visit);

    Set<Visit> findAll();
}
