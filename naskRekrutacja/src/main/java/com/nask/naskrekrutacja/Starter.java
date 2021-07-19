package com.nask.naskrekrutacja;

import com.nask.naskrekrutacja.models.People;
import com.nask.naskrekrutacja.services.DtoDownloaderService;
import com.nask.naskrekrutacja.services.DynamicPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class Starter implements CommandLineRunner
{
    private DtoDownloaderService dtoDownloaderService;
    private DynamicPeopleService dynamicPeopleService;

    @Autowired
    public Starter(DtoDownloaderService dtoDownloaderService, DynamicPeopleService dynamicPeopleService) {
        this.dtoDownloaderService = dtoDownloaderService;
        this.dynamicPeopleService = dynamicPeopleService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        for(int i=1;i<=41;i++)
        {
            Optional<People> op=dtoDownloaderService.loadResources(i);
            if(op.isPresent()) dynamicPeopleService.addPeople(op.get());
        }
    }
}
