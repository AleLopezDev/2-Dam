package net.codejava.hibernate;

import com.mysql.jdbc.MysqlDataTruncation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class Manager {

    protected SessionFactory sessionFactory;
    Scanner sc = new Scanner(System.in);

    protected void setup() {
        final StandardServiceRegistry registry = new
                StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new
                    MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected void exit() {
        sessionFactory.close();
    }

    protected void darAltaPasaje() {

        int codPasajero = -1;
        Session session = sessionFactory.openSession();

        Pasaje pasaje = new Pasaje();

        // Insertamos el código del pasajero y comprobamos que exista
        while (codPasajero == -1) {
            System.out.println("Introduzca el código del pasajero");
            codPasajero = sc.nextInt();
            Pasajero pasajero = session.get(Pasajero.class, codPasajero);
            if (pasajero == null) {
                System.out.println("El pasajero no existe");
                codPasajero = -1;
            } else {
                pasaje.setPasajeroCod(codPasajero);
            }
        }

        // Insertamos el identificador
        System.out.println("Introduzca el identificador de Vuelo");
        String identificador = sc.next();
        pasaje.setIdentificador(identificador);

        // Insertamos el número de asiento
        System.out.println("Introduzca el número de asiento");
        int numAsiento = sc.nextInt();
        pasaje.setNumAsiento(numAsiento);

        // Insertamos la clase
        System.out.println("Introduzca la clase");
        String clase = sc.next();
        pasaje.setClase(clase);

        // Insertamos el PVP
        System.out.println("Introduzca el PVP");
        int pvp = sc.nextInt();
        pasaje.setPvp(pvp);

        session.beginTransaction();
        session.save(pasaje);
        session.getTransaction().commit();
        session.close();
    }

    protected void consultaVuelo() {

        System.out.println("Introduce el identificador del vuelo");
        String identificador = sc.next();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "FROM Pasaje p WHERE p.identificador = :identificador";
        Query<Pasaje> query = session.createQuery(hql, Pasaje.class);
        query.setParameter("identificador", identificador);
        List<Pasaje> listaPasajes = query.list();

        if (listaPasajes.size() > 0) {
            for (Pasaje pasaje : listaPasajes) {
                int codPasajero = pasaje.getPasajeroCod();
                Pasajero pasajero = session.get(Pasajero.class, codPasajero);

                String hqlVuelo = "FROM Vuelo v WHERE v.identificador = :identificador";
                Query<Vuelo> queryVuelo = session.createQuery(hqlVuelo, Vuelo.class);
                queryVuelo.setParameter("identificador", identificador);
                List<Vuelo> listaVuelos = queryVuelo.list();

                if (listaVuelos.size() > 0) {
                    Vuelo vuelo = listaVuelos.get(0);
                    System.out.println("VUELO: " + vuelo.getIdentificador());
                    System.out.println("ORIGEN: " + vuelo.getAeropuerto_origen() + " DESTINO: " + vuelo.getAeropuerto_destino() + " FECHA: " + vuelo.getFecha());
                }

                System.out.println("CLASE: " + pasaje.getClase());
                System.out.println("Nombre pasajero: " + pasajero.getNombre() + " Código Pasaje: " + pasaje.getCod() + " Número de asiento: " + pasaje.getNumAsiento());
            }
        } else {
            System.out.println("No se han encontrado pasajes para ese vuelo");
        }

        session.getTransaction().commit();
        session.close();
    }

    protected void actualizarPasajero() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String nombre = "", telefono = "", direccion = "", pais = "";

        System.out.println("Introduce el código del pasajero");
        int codPasajero = sc.nextInt();

        Pasajero pasajero = session.get(Pasajero.class, codPasajero);

        sc.nextLine();

        if (pasajero == null) {
            System.out.println("El pasajero no existe");
        } else {
            while (nombre.equals("")) {
                System.out.println("Introduce el nuevo nombre");
                nombre = sc.nextLine();
            }
            pasajero.setNombre(nombre);


            while (telefono.equals("")) {
                System.out.println("Introduce el nuevo teléfono");
                telefono = sc.next();
            }
            pasajero.setTelefono(telefono);

            sc.nextLine();

            while (direccion.equals("")) {
                System.out.println("Introduce la nueva dirección");
                direccion = sc.nextLine();
            }
            pasajero.setDireccion(direccion);

            try {
                while (pais.equals("")) {
                    System.out.println("Introduce el nuevo país");
                    pais = sc.nextLine();
                }
                pasajero.setPais(pais);
                session.update(pasajero);
                session.getTransaction().commit();
            } catch (Exception ex){
                System.out.println("El país no puede tener más de 15 caracteres");
            }

        }
    }


    public static void main(String[] args) {
        Manager manager = new Manager();

        // do the CRUD operations
        manager.setup();

        manager.actualizarPasajero();

        manager.exit();
    }


}
