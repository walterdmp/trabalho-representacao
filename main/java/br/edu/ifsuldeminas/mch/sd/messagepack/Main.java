package br.edu.ifsuldeminas.mch.sd.messagepack;

import br.edu.ifsuldeminas.mch.sd.pojos.Address;
import br.edu.ifsuldeminas.mch.sd.pojos.Person;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Rua Domn Hugo", 307, "Centro", "37750-000", "Machado", "MG");
        Person p = new Person("João", "897.654.321-00", new Date(), address);
        
        Writer writer = new Writer();
        writer.write(p, "person.msgpack");
        
        Reader reader = new Reader();
        Person recuperado = reader.read("person.msgpack");
        
        System.out.println("\nRecuperado:");
        if (recuperado != null) System.out.println(recuperado.toString());
    }
}