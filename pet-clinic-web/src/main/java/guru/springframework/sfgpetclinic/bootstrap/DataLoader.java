package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();

        owner.setId(1L);
        owner.setFirstName("owner");
        owner.setLastName("one");

        ownerService.save(owner);

        Owner owner1 = new Owner();

        owner.setId(2L);
        owner.setFirstName("owner");
        owner.setLastName("two");

        ownerService.save(owner1);

        System.out.println("loaded owners...");

        Vet vet = new Vet();

        vet.setId(1L);
        vet.setFirstName("vet");
        vet.setLastName("one");

        vetService.save(vet);

        Vet vet1 = new Vet();

        vet.setId(2L);
        vet.setFirstName("vet");
        vet.setLastName("two");

        vetService.save(vet1);

        System.out.println("loaded vets...");
    }
}
