package org.gb.demobprj.utlis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.gb.demobprj.model.Person;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Component
public class JsonFileReader implements IFileReader{

    @Override
    public List<Person> readFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<Person> personList = Collections.emptyList();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            if (inputStream != null) {
                personList = objectMapper.readValue(inputStream, new TypeReference<List<Person>>() {});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personList;
    }
}