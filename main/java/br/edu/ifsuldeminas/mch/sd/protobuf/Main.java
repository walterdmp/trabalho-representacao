package br.edu.ifsuldeminas.mch.sd.protobuf;

import br.edu.ifsuldeminas.mch.sd.pojos.Address;
import br.edu.ifsuldeminas.mch.sd.pojos.Person;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Rua Vital Brasil", 251, "Vila do Céu", "37750-000", "Machado", "MG");
        Person p = new Person("Carlos", "456.789.321-00", new Date(), address);
        
        Writer writer = new Writer();
        writer.write(p, "person.bin");
        
        Reader reader = new Reader();
        Person recuperado = reader.read("person.bin");
        
        System.out.println("\nRecuperado:");
        if (recuperado != null) System.out.println(recuperado.toString());
    }
}