package cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.exceptions.ResourceNotFoundException;
import cat.itacademy.barcelonactiva.solereina.manel.s05.t01.n01.model.services.SucursalService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/signup")
    public String showSignUpForm(SucursalDTO sucursal, Model model) {
        model.addAttribute("sucursal", new SucursalDTO());
        return "add-sucursal";
    }

    @PostMapping("/add")
    public String addSucursal(@Valid SucursalDTO sucursal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sucursal", new SucursalDTO());
            model.addAttribute("errorMessage", "Les dades no són vàlides.");
            return "add-sucursal";
        }

        sucursalService.saveOrUpdate(sucursal);
        return "redirect:/getAll";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) throws ResourceNotFoundException {
        SucursalDTO sucursal = sucursalService.findById(id);
        //.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));

        model.addAttribute("sucursal", sucursal);
        return "update-sucursal";
    }

    @PostMapping("/update/{id}")
    public String updateSucursal(@PathVariable("id") int id, @Valid SucursalDTO sucursal,
                                 BindingResult result, Model model) {
        sucursal.setPk_SucursalID(id);
        if (result.hasErrors()) {
            model.addAttribute("sucursal", sucursal);
            model.addAttribute("errorMessage", "Les dades no són vàlides.");
            return "update-sucursal";
        }
        sucursalService.saveOrUpdate(sucursal);
        return "redirect:/getAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") int id, Model model) {
        //Sucursal sucursal = sucursalService.findById(id);
        //.orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
        sucursalService.deleteById(id);
        return "redirect:/getAll";
    }

    @GetMapping("/getAll")
    public String showSucursalList(Model model) {
        model.addAttribute("sucursalList", sucursalService.findAll());
        model.addAttribute("sucursal", new SucursalDTO());
        return "index";
    }

    @GetMapping("/")
    public String indexRedirect() {
        return "redirect:/getAll";
    }

    @GetMapping("/getOne")
    public String showSucursal(SucursalDTO dto, Model model) throws ResourceNotFoundException {
        SucursalDTO sucursal = sucursalService.findById(dto.getPk_SucursalID());
        model.addAttribute("sucursal", sucursal);
        return "show-sucursal";
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ModelAndView notFoundErrorHandler(HttpServletRequest req, ResourceNotFoundException e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error-not-found");
        return mav;
    }
}