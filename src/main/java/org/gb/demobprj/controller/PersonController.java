package org.gb.demobprj.controller;

import org.gb.demobprj.database.PersonDB;
import org.gb.demobprj.model.Person;
import org.gb.demobprj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping()
    public String getAllPersons(Model model,
                                @RequestParam(required = false ,defaultValue = "1") int page,
                                @RequestParam(required = false ,defaultValue = "10") int size) {
        model.addAttribute("pageData", personService.getAll(page,size));
        return "/index";
    }






    @GetMapping("/sortedname")
    @ResponseBody
    public List<Person> sortedNameList() {
        return personService.sortPeopleByFullName();
    }

    @GetMapping("/sortednamere")
    @ResponseBody
    public List<Person> sortedNameReList() {
        return personService.sortPeopleByFullNameReversed();
    }
    @GetMapping("/sortjob")
    @ResponseBody
    public List<String> getSortedJobs() {
        return personService.getSortedJobs();
    }

    @GetMapping("/sortcity")
    @ResponseBody
    public List<String> getSortedCity() {
        return personService.getSortedCities();
    }

    @GetMapping("/femalename")
    @ResponseBody
    public List<String> femaleNames() {
        return personService.femaleNames();
    }

    @GetMapping("/maxsal")
    @ResponseBody

    public Person highestEarner() {
        return personService.highestEarner();
    }

    @GetMapping("/bornafter1990")
    @ResponseBody
    public List<Person> bornAfter1990() {
        return personService.bornAfter1990();
    }
    @GetMapping("/avgsalary")
    @ResponseBody
    public double averageSalary() {
        return personService.averageSalary();
    }

    @GetMapping("/avgage")
    @ResponseBody
    public double averageAge() {
        return personService.averageAge();
    }

    @GetMapping("/namecontains")
    @ResponseBody
    public List<Person> nameContains(@RequestParam String keyword) {
        return personService.nameContains(keyword);
    }

    @GetMapping("/sortagemale")
    @ResponseBody
    public List<Person> sortedByAgeForMale() {
        return personService.sortedByAgeForMale();
    }

    @GetMapping("/longestname")
    @ResponseBody
    public Person longestName() {
        return personService.longestName();
    }

    @GetMapping("/aboveavgsal")
    @ResponseBody
    public List<Person> aboveAverageSalary() {
        return personService.aboveAverageSalary();
    }

    @GetMapping("/groupbycity")
    @ResponseBody
    public Map<String,List<Person>> groupPeopleByCity() {
        return personService.groupPeopleByCity();
    }

    @GetMapping("/groupjobbycount")
    @ResponseBody
    public Map<String,Integer> groupJobByCount() {
        return personService.groupJobByCount();
    }


}
