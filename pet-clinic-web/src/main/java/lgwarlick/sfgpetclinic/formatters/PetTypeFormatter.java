package lgwarlick.sfgpetclinic.formatters;


import lgwarlick.sfgpetclinic.model.PetType;
import lgwarlick.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
       return petType.getName();
    }

    //pulls all PetTypes and then matches based on name
    //fixes issue where Pet Type was incorrectly attempting to be generated from Long id value
    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("Type not found: " + text, 0);
    }
}
