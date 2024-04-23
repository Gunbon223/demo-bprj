package org.gb.demobprj.utlis;

import org.gb.demobprj.model.Person;

import java.util.List;

public interface IFileReader {
        List<Person> readFile(String path);
}
