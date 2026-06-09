package br.edu.ifsuldeminas.mch.sd.avro;

import br.edu.ifsuldeminas.mch.sd.pojos.Address;
import br.edu.ifsuldeminas.mch.sd.pojos.Person;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Rua Dom Hugo", 307, "Centro", "37750-000", "Machado", "MG");
        Person p = new Person("Maria", "123.456.789-00", new Date(), address);
        
        Writer writer = new Writer();
        writer.write(p, "person.avro");
        
        Reader reader = new Reader();
        Person recuperado = reader.read("person.avro");
        
        System.out.println("\nRecuperado:");
        if (recuperado != null) System.out.println(recuperado.toString());
    }
}