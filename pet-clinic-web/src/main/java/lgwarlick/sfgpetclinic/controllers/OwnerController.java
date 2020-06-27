package lgwarlick.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//alternative method that refactors out the root of /owners
//see VetController for contrast
@RequestMapping("/owners")

@Controller
public class OwnerController {

   @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(){
       return "owners/index";
   }

}
