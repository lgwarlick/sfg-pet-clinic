package lgwarlick.sfgpetclinic.controllers;

import lgwarlick.sfgpetclinic.model.Owner;
import lgwarlick.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//alternative method that refactors out the root of /owners
//see VetController for contrast
@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    //prevents id field from being manipulated
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

   @RequestMapping("/find")
   public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
   }

   @GetMapping
   public String processFindForm(Owner owner, BindingResult result, Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName(""); //search for everything
        }

        //% is wildcard, but results are still case sensitive
       List<Owner> ownersFound = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if (ownersFound.isEmpty()) {
            //empty, no results
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (ownersFound.size() == 1) {
            //single found
            owner = ownersFound.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            //multiple found
            model.addAttribute("selections", ownersFound);
            return "owners/ownersList";
        }
   }

   @GetMapping("/{ownerId}")
    public ModelAndView showOwner (@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
   }

}
