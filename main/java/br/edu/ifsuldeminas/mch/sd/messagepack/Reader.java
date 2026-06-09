package br.edu.ifsuldeminas.mch.sd.messagepack;

import br.edu.ifsuldeminas.mch.sd.pojos.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import java.io.File;

public class Reader {
    public Person read(String filename) {
        try {
            ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
            return mapper.readValue(new File(filename), Person.class);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}