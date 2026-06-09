package br.edu.ifsuldeminas.mch.sd.protobuf;

import br.edu.ifsuldeminas.mch.sd.pojos.Person;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import java.io.FileOutputStream;

public class Writer {
    public void write(Person person, String filename) {
        Schema<Person> schema = RuntimeSchema.getSchema(Person.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(512);
        
        try (FileOutputStream out = new FileOutputStream(filename)) {
            byte[] bytes = ProtostuffIOUtil.toByteArray(person, schema, buffer);
            out.write(bytes);
            System.out.println("Arquivo Protobuf gerado!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            buffer.clear();
        }
    }
}