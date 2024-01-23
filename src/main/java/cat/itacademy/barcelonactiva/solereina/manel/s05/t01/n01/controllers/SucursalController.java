package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.services.SucursalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SucursalController {

    @Autowired
    SucursalService sucursalService;
    @GetMapping("/signup")
    public String showSignUpForm(Sucursal sucursal) {
        return "add-sucursal";
    }

    @PostMapping("/addsucursal")
    public String addSucursal(@Valid Sucursal sucursal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-sucursal";
        }

        sucursalService.saveOrUpdate(sucursal);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Sucursal sucursal = sucursalService.findById(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));

        model.addAttribute("sucursal", sucursal);
        return "update-sucursal";
    }

    @PostMapping("/update/{id}")
    public String updateSucursal(@PathVariable("id") int id, @Valid Sucursal sucursal,
                             BindingResult result, Model model) {
        sucursal.setPk_SucursalID(id);
        if (result.hasErrors()) {
            return "update-sucursal";
        }
        sucursalService.saveOrUpdate(sucursal);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") int id, Model model) {
        //Sucursal sucursal = sucursalService.findById(id);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
        sucursalService.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showSucursalList(Model model) {
        model.addAttribute("sucursalList", sucursalService.findAll());
        return "index";
    }

    @GetMapping("/")
    public String indexRedirect() {
        return "redirect:/index";
    }
}