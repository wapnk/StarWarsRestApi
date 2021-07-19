package com.nask.naskrekrutacja.controllers;

import com.nask.naskrekrutacja.models.DynamicPage;
import com.nask.naskrekrutacja.models.People;
import com.nask.naskrekrutacja.services.DynamicPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class Controller {

    private DynamicPeopleService dynamicPeopleService;

    @Autowired
    public Controller(DynamicPeopleService dynamicPeopleService) {
        this.dynamicPeopleService = dynamicPeopleService;
    }

    @GetMapping(value = "characters", params = "page")
    public ResponseEntity<DynamicPage> getPage(@RequestParam("page") int page) throws Exception {
        Optional<DynamicPage> p = dynamicPeopleService.getDynamicPage(page);
        if (p.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(p.get());
    }

    @GetMapping("characters/{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable("id") int id) {
        Optional<People> people = dynamicPeopleService.getPeopleById(id);
        if (people.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(people.get());

    }
}
