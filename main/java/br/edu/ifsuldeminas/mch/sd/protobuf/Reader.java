package br.edu.ifsuldeminas.mch.sd.protobuf;

import br.edu.ifsuldeminas.mch.sd.pojos.Person;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {
    public Person read(String filename) {
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
        Person person = schema.newMessage();
        
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            ProtostuffIOUtil.mergeFrom(bytes, person, schema);
            return person;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}