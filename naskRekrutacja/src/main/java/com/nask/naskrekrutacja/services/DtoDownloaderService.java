package com.nask.naskrekrutacja.services;

import com.google.gson.Gson;
import com.nask.naskrekrutacja.dto.HomeworldDTO;
import com.nask.naskrekrutacja.dto.PeopleDTO;
import com.nask.naskrekrutacja.dto.StarshipDTO;
import com.nask.naskrekrutacja.models.Homeworld;
import com.nask.naskrekrutacja.models.People;
import com.nask.naskrekrutacja.models.Starship;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DtoDownloaderService
{

    public People makePeople(PeopleDTO peopleDTO,HomeworldDTO homeworldDTO,List<StarshipDTO> starshipDTOList,int id)
    {
        List<Starship> starshipList=new ArrayList<>();
        for(StarshipDTO starshipDTO:starshipDTOList)
        {
            Starship starship1 = new Starship();
            starship1.setName(starshipDTO.getName());
            starship1.setModel(starshipDTO.getModel());
            starship1.setManufacturer(starshipDTO.getManufacturer());
            starship1.setCostInCredits(starshipDTO.getCost_in_credits());
            starship1.setLength(starshipDTO.getLength());
            starship1.setMaxAtmosphericSpeed(starshipDTO.getMax_atmosphering_speed());
            starship1.setCrew(starshipDTO.getCrew());
            starship1.setPassengers(starshipDTO.getPassengers());
            starship1.setCargoCapacity(starshipDTO.getCargo_capacity());
            starship1.setConsumables(starshipDTO.getConsumables());
            starship1.setHyperdriveRating(starshipDTO.getHyperdrive_rating());
            starship1.setMglt(starshipDTO.getmGLT());
            starship1.setStarshipClass(starshipDTO.getStarship_class());
            starshipList.add(starship1);
        }
        Homeworld homeworld=new Homeworld();
        homeworld.setName(homeworldDTO.getName());
        homeworld.setRotationPeriod(homeworldDTO.getRotation_period());
        homeworld.setOrbitalPeriod(homeworldDTO.getOrbital_period());
        homeworld.setDiameter(homeworldDTO.getDiameter());
        homeworld.setClimate(homeworldDTO.getClimate());
        homeworld.setGravity(homeworldDTO.getGravity());
        homeworld.setTerrain(homeworldDTO.getTerrain());
        homeworld.setSurfaceWater(homeworldDTO.getSurface_water());
        homeworld.setPopulation(homeworldDTO.getPopulation());

        People people = new People();
        people.setId(id);
        people.setName(peopleDTO.getName());
        people.setHeight(peopleDTO.getHeight());
        people.setMass(peopleDTO.getMass());
        people.setHairColor(peopleDTO.getHair_color());
        people.setSkinColor(peopleDTO.getSkin_color());
        people.setEyeColor(peopleDTO.getEye_color());
        people.setBirthYear(peopleDTO.getBirth_year());
        people.setGender(peopleDTO.getGender());

        people.setStarships(starshipList);
        people.setHomeworld(homeworld);
        return people;

    }
    public Optional<People> loadResources(int i)
    {
        try {
            URL urlPerson = new URL("https://swapi.dev/api/people/" + i + "/?format=json");
            InputStreamReader jsonObiect1 = new InputStreamReader(urlPerson.openStream());
            PeopleDTO people = new Gson().fromJson(jsonObiect1, PeopleDTO.class);

            URL urlHomeworld = new URL(people.getHomeworld() + "/?format=json");
            InputStreamReader jsonObiect2 = new InputStreamReader(urlHomeworld.openStream());
            HomeworldDTO homeworld = new Gson().fromJson(jsonObiect2, HomeworldDTO.class);

            List<StarshipDTO> starshipList = new ArrayList<>();
            for (int j = 0; j < people.getStarships().size(); j++) {
                URL urlStarship = new URL(people.getStarships().get(j) + "/?format=json");
                InputStreamReader jsonObiect3 = new InputStreamReader(urlStarship.openStream());
                StarshipDTO starship = new Gson().fromJson(jsonObiect3, StarshipDTO.class);
                starshipList.add(starship);
            }
            return Optional.ofNullable(makePeople(people, homeworld, starshipList, i));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

}
