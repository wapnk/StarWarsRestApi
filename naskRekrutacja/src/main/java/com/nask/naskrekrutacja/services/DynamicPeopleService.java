package com.nask.naskrekrutacja.services;

import com.nask.naskrekrutacja.models.DynamicPage;
import com.nask.naskrekrutacja.models.People;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DynamicPeopleService {
    private List<People> people;
    public static final int elementsAmount = 10;

    public DynamicPeopleService() {
        this.people = new ArrayList<>();
    }

    public Optional<DynamicPage> getDynamicPage(int page) throws Exception {
        DynamicPage dynamicPage = new DynamicPage();
        int begin = elementsAmount * (page - 1);
        int end = elementsAmount * page;
        if (people.size() < begin) {
            return Optional.empty();
        } else if (people.size() < end) {
            end = people.size() - 1;

        }
        dynamicPage.setElements(people.subList(begin, end));
        int pages = people.size() / elementsAmount;
        if (people.size() % elementsAmount != 0) pages++;
        dynamicPage.setPages(pages);
        dynamicPage.setCount(people.size());
        return Optional.of(dynamicPage);
    }

    public Optional<People> getPeopleById(Integer id) {
        return people.stream().filter(people -> people.getId().equals(id)).findFirst();
    }

    public void addPeople(People people) {
        this.people.add(people);
    }
}
