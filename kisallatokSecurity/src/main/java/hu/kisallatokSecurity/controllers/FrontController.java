package hu.kisallatokSecurity.controllers;

import hu.kisallatokSecurity.services.OwnerService;
import hu.kisallatokSecurity.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontController {

    @Autowired
    private OwnerService ownerService;
    @Autowired
    private PetService petService;

    @GetMapping("/")
    public String front(){
        return "index";
    }
    @GetMapping("/pictures")
    public String pics(){
        return "pictures";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/new-owner")
    public String newowner(Model model){
        model.addAttribute("owners",ownerService.getOwners());
        return "newowner";
    }

    @PostMapping("/new-owner")
    public String newOwner(@RequestParam("ownername") String name,
                           @RequestParam("owneraddress") String address,
                           Model model){

        int status = ownerService.newOwner(name, address);
        model.addAttribute("status",status);
        model.addAttribute("owners",ownerService.getOwners());
        return "newowner";
    }

    @GetMapping("/front-pets")
    public String getPets(Model model){
        model.addAttribute("pets",petService.getPets());
        model.addAttribute("owners",ownerService.getOwners());
        return "pets";
    }
    @PostMapping("/front-pets")
    public String addPet(@RequestParam("race") String race,
                         @RequestParam("name") String name,
                         @RequestParam("age") int age,
                         @RequestParam("ownerId") int ownerId,
            Model model){
        model.addAttribute("status", petService.addPets(race,name,age,ownerId));
        model.addAttribute("owners",ownerService.getOwners());
        model.addAttribute("pets", petService.getPets());
        return "pets";
    }
    @PostMapping("/updateowner")
    public String updateform(Model model, @RequestParam("ownerid")int ownerid){
        model.addAttribute("ownerid",ownerService.getOwner(ownerid));
        return "updateowner";
    }
    @PostMapping("/update-owner")
    public String updateOwner(Model model,
                              @RequestParam("ownerid")int id,
                              @RequestParam("owneraddress") String address){
        model.addAttribute("status",ownerService.updateOwner(id, address));
        model.addAttribute("owners",ownerService.getOwners());
        return "newowner";
    }

}
