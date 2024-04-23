package org.gb.demobprj.database;

import org.gb.demobprj.utlis.IFileReader;
import org.gb.demobprj.utlis.JsonFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB implements CommandLineRunner {
    @Autowired
    private IFileReader iFileReader;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("InitDB.run");
        PersonDB.personList = iFileReader.readFile("Person.json");



    }
}
