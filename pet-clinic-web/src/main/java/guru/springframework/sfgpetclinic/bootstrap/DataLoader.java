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
        Owner owner1 = new Owner();
        owner1.setFirstName("owner");
        owner1.setLastName("one");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("owner");
        owner2.setLastName("two");

        ownerService.save(owner2);

        System.out.println("loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("vet");
        vet1.setLastName("one");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vet");
        vet2.setLastName("two");

        vetService.save(vet2);

        System.out.println("loaded vets...");
    }
}
