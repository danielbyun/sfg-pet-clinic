package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.SpecialtyService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty savedSurgery = specialtyService.save(surgery);
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("owner");
        owner1.setLastName("one");
        owner1.setAddress("40 April Lane");
        owner1.setCity("Levittown");
        owner1.setTelephone("9173928501");

        ownerService.save(owner1);

        Pet owner1Pet = new Pet();
        owner1Pet.setPetType(savedDogPetType);
        owner1Pet.setOwner(owner1);
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setName("Rudy");
        owner1.getPets().add(owner1Pet);

        Owner owner2 = new Owner();
        owner2.setFirstName("owner");
        owner2.setLastName("two");
        owner2.setAddress("47 Eagle Lane");
        owner2.setCity("Levittown");
        owner2.setTelephone("5163929381");

        ownerService.save(owner2);

        Pet owner2Pet = new Pet();
        owner2Pet.setPetType(savedCatPetType);
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setName("Grumpy");
        owner2.getPets().add(owner2Pet);

        System.out.println("loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("vet");
        vet1.setLastName("one");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("vet");
        vet2.setLastName("two");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("loaded vets...");
    }
}
