package com.metacoding.storev1.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // loC (제어의 역전) =>HashSet
public class StoreController {

    @GetMapping("/")
    public String list() {
        return "store/list";
    }

    @GetMapping("/store/save-form")
    public String saveForm() {
        return "store/save-form";
    }

    @GetMapping("/store/{id}")
    public String detail(@PathVariable("id") Integer id) {
        return "store/detail";
    }

    @GetMapping("/store/{id}/update-form")
    public String updateForm(@PathVariable("id") Integer id) {
        return "store/update-form";
    }

    @PostMapping("/store/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        return "redirect:/";
    }

    @PostMapping("/store/save")
    public String save() {
        return "redirect:/";
    }

    @PostMapping("/store/{id}/update")
    public String update(@PathVariable("id") Integer id) {
        return "redirect:/store/" + id;
    }

}
