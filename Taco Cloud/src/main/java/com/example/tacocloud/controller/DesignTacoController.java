package com.example.tacocloud.controller;


import com.example.tacocloud.model.Indgridient;
import com.example.tacocloud.model.Indgridient.Type;
import com.example.tacocloud.model.Taco;
import com.example.tacocloud.model.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    @ModelAttribute
    public String addIngredientsModel(Model model) {
        List<Indgridient> ingredients = Arrays.asList(
                new Indgridient("FLTO", "Flour Tortilla", Indgridient.Type.WRAP),
                new Indgridient("COTO", "Corn Tortilla", Indgridient.Type.WRAP),
                new Indgridient("GRBF", "Ground Beef", Indgridient.Type.PROTEIN),
                new Indgridient("CARN", "Carnitas", Indgridient.Type.PROTEIN),
                new Indgridient("TMTO", "Diced Tomatoes", Indgridient.Type.VEGGIES),
                new Indgridient("LETC", "Lettuce", Indgridient.Type.VEGGIES),
                new Indgridient("CHED", "Chedder", Indgridient.Type.CHEESE),
                new Indgridient("JACK", "Moterrey Jack", Indgridient.Type.CHEESE),
                new Indgridient("SLSA", "Salsa", Indgridient.Type.SAUCE),
                new Indgridient("SRCR", "Sour Cream", Indgridient.Type.SAUCE)
        );
        Indgridient.Type[] types = Indgridient.Type.values();
        for (Indgridient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }
        @ModelAttribute(name = "tacoOrder")
        public TacoOrder order () {
            return new TacoOrder();
        }
        @ModelAttribute(name = "taco")
        public Taco taco () {
            return new Taco();
        }
        @GetMapping
        public String showDesignForm() {
            return "design";
        }

    private Iterable <Indgridient> filterByType(List<Indgridient> ingredients, Type type) {
        return  ingredients.stream().filter(x->x.getType().equals(type)).collect(Collectors.toList());
    }
}
