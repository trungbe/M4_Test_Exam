package com.example.exam.controller;

import com.example.exam.model.City;
import com.example.exam.model.Country;
import com.example.exam.service.city.ICityService;
import com.example.exam.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cities")

public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("listCountry")
    public List<Country> categories() {
        return countryService.findAll();
    }

    @GetMapping("")
    public ModelAndView showAll(@ModelAttribute("mess") String mess) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<City> cities = cityService.findAll();
        modelAndView.addObject("city", cities);
        modelAndView.addObject("mess", mess);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Validated @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:/cities");
        modelAndView.addObject("mess", "Thêm thành phố mới thành công!");

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editCity(@PathVariable Long id, @ModelAttribute City city) {
        city.setId(id);
        cityService.save(city);
        return new ModelAndView("redirect:/cities");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCity(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/cities");
        cityService.deleteById(id);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewDetail(@PathVariable Long id) {
        return new ModelAndView("view", "city", cityService.findById(id));
    }
}
