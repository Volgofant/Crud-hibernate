import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.sql.SQLException;

public class Crud {
    public static void main(String[] args) throws SQLException {
        Person person = new Person();
        person.setName("Дмитрий");
        person.setAddress("Трехгорка");
        person.setAge(28);


        SessionFactory sessionFactory = buildSessionFactory(Person.class);
        Session session = sessionFactory.openSession();

        session.save(person);

        Person savedPerson = session.get(Person.class, 1);
        
        System.out.println("_____________________");
        System.out.println("Name: " + savedPerson.getName());
        System.out.println("Address: " + savedPerson.getAddress());
        System.out.println("Age :" + savedPerson.getAge());
        System.out.println("_____________________");

        session.close();
        sessionFactory.close();


    }

    private static SessionFactory buildSessionFactory(Class clazz) {
        return new Configuration()
                .configure()
                .addAnnotatedClass(clazz)
                .buildSessionFactory();
    }
}
