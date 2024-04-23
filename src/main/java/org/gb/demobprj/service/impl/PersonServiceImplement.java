package org.gb.demobprj.service.impl;

import org.gb.demobprj.dao.PersonDAO;
import org.gb.demobprj.model.Person;
import org.gb.demobprj.response.PageRes;
import org.gb.demobprj.response.PageResImplement;
import org.gb.demobprj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImplement implements PersonService {


    @Autowired
    PersonDAO personDAO;




    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    public void printListPeople(List<Person> persons) {

    }

    @Override
    public PageRes<Person> getAll(int page, int size) {
        return new PageResImplement<>(personDAO.getAll(), page, size);
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return personDAO.sortPeopleByFullName();
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return personDAO.sortPeopleByFullNameReversed();
    }

    @Override
    public List<String> getSortedJobs() {
        return personDAO.getSortedJobs();
    }

    @Override
    public List<String> getSortedCities() {
        return personDAO.getSortedCities();
    }

    @Override
    public List<String> femaleNames() {
        return personDAO.femaleNames();
    }

    @Override
    public Person highestEarner() {
        return personDAO.highestEarner();
    }

    @Override
    public List<Person> bornAfter1990() {
        return personDAO.bornAfter1990();
    }

    @Override
    public double averageSalary() {
        return personDAO.averageSalary();
    }

    @Override
    public double averageAge() {
        return personDAO.averageAge();
    }

    @Override
    public List<Person> nameContains(String keyword) {
        return personDAO.nameContains(keyword);
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        return personDAO.sortedByAgeForMale();
    }

    @Override
    public Person longestName() {
        return personDAO.longestName();
    }

    @Override
    public List<Person> aboveAverageSalary() {
        return personDAO.aboveAverageSalary();
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return personDAO.groupPeopleByCity();
    }

    @Override
    public Map<String, Integer> groupJobByCount() {
        return personDAO.groupJobByCount();
    }
}
