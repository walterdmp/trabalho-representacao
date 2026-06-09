package br.edu.ifsuldeminas.mch.sd.avro;

import br.edu.ifsuldeminas.mch.sd.pojos.Person;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.reflect.ReflectDatumReader;
import java.io.File;

public class Reader {
    public Person read(String filename) {
        try {
            ReflectDatumReader<Person> datumReader = new ReflectDatumReader<>(Person.class);
            DataFileReader<Person> dataFileReader = new DataFileReader<>(new File(filename), datumReader);
            
            Person person = null;
            if (dataFileReader.hasNext()) {
                person = dataFileReader.next();
            }
            dataFileReader.close();
            return person;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}