package lgwarlick.sfgpetclinic.controllers;

import lgwarlick.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//alternative method that refactors out the root of /owners
//see VetController for contrast
@RequestMapping("/owners")

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model){
       model.addAttribute("owners", ownerService.findAll());
       return "owners/index";
   }

   @RequestMapping("/find")
   public String findOwners() {
        return "notimplemented";
   }

}
