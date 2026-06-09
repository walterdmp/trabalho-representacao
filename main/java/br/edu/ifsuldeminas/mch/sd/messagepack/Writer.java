package br.edu.ifsuldeminas.mch.sd.messagepack;

import br.edu.ifsuldeminas.mch.sd.pojos.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import java.io.File;

public class Writer {
    public void write(Person person, String filename) {
        try {
            ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
            mapper.writeValue(new File(filename), person);
            System.out.println("Arquivo MessagePack gerado!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}