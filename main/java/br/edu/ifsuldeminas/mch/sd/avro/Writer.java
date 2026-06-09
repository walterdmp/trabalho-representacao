package br.edu.ifsuldeminas.mch.sd.avro;

import br.edu.ifsuldeminas.mch.sd.pojos.Person;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;
import java.io.File;

public class Writer {
    public void write(Person person, String filename) {
        try {
            Schema schema = ReflectData.get().getSchema(Person.class);
            
            ReflectDatumWriter<Person> datumWriter = new ReflectDatumWriter<>(schema);
            DataFileWriter<Person> dataFileWriter = new DataFileWriter<>(datumWriter);
            
            dataFileWriter.create(schema, new File(filename));
            dataFileWriter.append(person);
            dataFileWriter.close();
            
            System.out.println("Arquivo Avro gerado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}