package org.gb.demobprj.dao.impl;

import org.gb.demobprj.dao.PersonDAO;
import org.gb.demobprj.database.PersonDB;
import org.gb.demobprj.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonDAOImplement implements PersonDAO {
    @Override
    public List<Person> getAllPersons() {
        return PersonDB.personList;
    }

    @Override
    public void printListPeople(List<Person> persons) {
        System.out.println(PersonDB.personList);
    }

    @Override
    public List<Person> getAll() {
        return PersonDB.personList;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        List<Person> personList = PersonDB.personList.stream()
                .sorted(Comparator.comparing(Person::getFullname))
                .toList();
        return personList;
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        List<Person> personList = PersonDB.personList.stream()
                .sorted(Comparator.comparing(Person::getFullname).reversed())
                .toList();
        return personList;
    }

    @Override
    public List<String> getSortedJobs() {
        List<String> personList = PersonDB.personList.stream()
                .map(Person::getJob)
                .collect(Collectors.toList());
        return personList;
    }

    @Override
    public List<String> getSortedCities() {
        List<String> personList = PersonDB.personList.stream()
                .map(Person::getCity)
                .distinct()
                .collect(Collectors.toList());
        return personList;
    }

    @Override
    public List<String> femaleNames() {
        List<String> personList = PersonDB.personList.stream()
                .filter(a -> a.getGender().equalsIgnoreCase("female"))
                .map(Person::getFullname)
                .collect(Collectors.toList());
        return personList;
    }

    @Override
    public Person highestEarner() {
       return PersonDB.personList.stream()
                .max(Comparator.comparingDouble(Person::getSalary))
                .orElse(null);
    }

    @Override
    public List<Person> bornAfter1990() {
        return List.of();
    }
        List<Person> persons = PersonDB.personList.stream()
                .filter(a -> a.getBirthday().getYear() > 1990)
                .collect(Collectors.toList());
    @Override
    public double averageSalary() {
        return PersonDB.personList.stream()
                .mapToDouble(Person::getSalary)
                .average()
                .orElse(0);
    }

    @Override
    public double averageAge() {
        return PersonDB.personList.stream()
                .mapToDouble(a ->2024 - a.getBirthday().getYear())
                .average()
                .orElse(0);

    }

    @Override
    public List<Person> nameContains(String keyword) {
        List<Person> personList = PersonDB.personList.stream()
                .filter(a -> a.getFullname().contains(keyword))
                .collect(Collectors.toList());
        return personList;
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        List<Person> personList = PersonDB.personList.stream()
                .filter(a -> a.getGender().equalsIgnoreCase("Male"))
                .sorted(Comparator.comparingInt(a -> 2024 - a.getBirthday().getYear()))
                .collect(Collectors.toList());
        return personList;
    }

    @Override
    public Person longestName() {
        return PersonDB.personList.stream()
                .max(Comparator.comparingInt(a -> a.getFullname().length()))
                .orElse(null);
    }

    @Override
    public List<Person> aboveAverageSalary() {
        double averageSalary = averageSalary();
        List<Person> personList = PersonDB.personList.stream()
                .filter(a -> a.getSalary() > averageSalary)
                .collect(Collectors.toList());
        return personList;
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        Map<String, List<Person>> personList = PersonDB.personList.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        return personList;
    }

    @Override
    public Map<String, Integer> groupJobByCount() {
        Map<String, Integer> personList = PersonDB.personList.stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.summingInt(a -> 1)));
        return personList;
    }


}
