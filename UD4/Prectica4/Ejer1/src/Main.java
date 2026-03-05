import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Coche c1 = new Coche("1234ABC", "Toyota", 2018, 18000);
        Coche c2 = new Coche("5678DEF", "BMW", 2015, 25000);
        Coche c3 = new Coche("9012GHI", "Seat", 2012, 12000);

        Coche c4 = new Coche("3456JKL", "Toyota", 2020, 22000);
        Coche c5 = new Coche("7890MNO", "Audi", 2017, 30000);
        Coche c6 = new Coche("1122PQR", "BMW", 2010, 15000);

        Coche c7 = new Coche("3344STU", "Seat", 2019, 16000);
        Coche c8 = new Coche("5566VWX", "Audi", 2014, 20000);
        Coche c9 = new Coche("7788YZA", "Toyota", 2021, 24000);

        Propietario p1 = new Propietario( "Carlos", List.of(c1, c2, c3) );
        Propietario p2 = new Propietario( "Ana", List.of(c4, c5, c6) );
        Propietario p3 = new Propietario( "Luis", List.of(c7, c8, c9) );

        List<Propietario> propietarios = List.of(p1, p2, p3);


        /*Ejer 1

        //Sin stream

        List<String> matriculas = new ArrayList<>();

        for (Propietario p : propietarios) {
            for (Coche c : p.getCoches()) {
                matriculas.add(c.getMatricula());
            }
        }

        System.out.println(matriculas);

        //Con stream

        List<String>matriculas = propietarios.stream()
                .flatMap(p -> p.getCoches().stream())
                .map(Coche :: getMatricula)
                .collect(Collectors.toList());

        System.out.println(matriculas);

        */

        /*Ejer 2

        //Sin stream
        for (Propietario p : propietarios) {
            int cantidad = p.getCoches().size();
            System.out.println(
                    "El propietario " + p.getNombre() + " tiene " + cantidad + " coches"
            );
        }

        //Con stream
        propietarios.stream()
                .forEach(p ->
                        System.out.println("El propietario " + p.getNombre() +
                                " tiene " + p.getCoches().size() + " coches"
                        )
                );
         */

        /*
        Ejer 3

        Sin steam

        List<Coche> cochesPos2015 = new ArrayList<>();
        for (Propietario p : propietarios) {
            for(Coche c : p.getCoches()) {
                if(c.getAno() > 2015) {
                    cochesPos2015.add(c);
                }
            }
        }
        System.out.println("Coches posteriores a 2015");
        for(Coche c : cochesPos2015) {
            System.out.println(c.getMarca() + " " + c.getMatricula() + " - " + c.getAno());
        }

        Con Steam
        */

        /*Ejer 7
        Sin steam

        List<Coche> cochesPorPrecio = new ArrayList<>();
        for (Propietario p : propietarios) {
            cochesPorPrecio.addAll(p.getCoches());
        }
        Collections.sort(cochesPorPrecio, new Comparator<Coche>() {
            public int compare(Coche c1, Coche c2) {
                return Double.compare(c1.getPrecio(), c2.getPrecio());
            }
        });
        System.out.println("Coches ordenados por precio (ascendente):");
        for (Coche c : cochesPorPrecio) {
            System.out.println(c.getMarca() + " " + c.getMatricula() + " - " + c.getPrecio());
        }

        Con steam


        List<Coche> cochesOrdenados = propietarios.stream()
                .flatMap(p -> p.getCoches().stream())
                .sorted(Comparator.comparingDouble(Coche::getPrecio))
                .toList();

        cochesOrdenados.forEach(c -> System.out.println(c.getMarca() + " - " + c.getPrecio()));

        Ejer 8

        Sin steam


        List<Coche> todosCoches = new ArrayList<>();
        for (Propietario p : propietarios) {
            todosCoches.addAll(p.getCoches());
        }

        Coche cocheAntiguo = todosCoches.get(0);

        for (Coche c : todosCoches) {
            if (c.getAno() < cocheAntiguo.getAno()) {
                cocheAntiguo = c;
            }
        }

        System.out.println("Coche más antiguo: " + cocheAntiguo.getMarca() + " - " + cocheAntiguo.getAno());

        Con steam

        Coche cocheMasAntiguo = propietarios.stream()
        .flatMap(p -> p.getCoches().stream())
        .min(Comparator.comparingInt(Coche::getAno))
        .orElse(null);

        if (cocheMasAntiguo != null) {
            System.out.println("Coche más antiguo: " + cocheMasAntiguo.getMarca() + " - " + cocheMasAntiguo.getAno());
        }

        Ejer 15

        Sin Steam
        List<Coche> todosCoches = new ArrayList<>();
        for (Propietario p : propietarios) {
            todosCoches.addAll(p.getCoches());
        }

        StringBuilder concatenadas = new StringBuilder();
        for (int i = 0; i < todosCoches.size(); i++) {
            concatenadas.append(todosCoches.get(i).getMatricula());
            if (i < todosCoches.size() - 1) {
                concatenadas.append(", ");
            }
        }

        System.out.println(concatenadas.toString());


        Con Steam
        String concatenadas = propietarios.stream()
            .flatMap(p -> p.getCoches().stream())
            .map(Coche::getMatricula)
            .collect(Collectors.joining(", "));

        System.out.println(concatenadas);

       // Ejer 15
        Sin Stream
        List<Coche> todosCoches = new ArrayList<>();
        for (Propietario p : propietarios) {
            todosCoches.addAll(p.getCoches());
        }

        StringBuilder concatenadas = new StringBuilder();
        for (int i = 0; i < todosCoches.size(); i++) {
            concatenadas.append(todosCoches.get(i).getMatricula());
            if (i < todosCoches.size() - 1) {
                concatenadas.append(", ");
            }
        }

        System.out.println(concatenadas.toString());

        Con Stream
        String concatenadas = propietarios.stream()
            .flatMap(p -> p.getCoches().stream())
            .map(Coche::getMatricula)
            .collect(Collectors.joining(", "));

        System.out.println(concatenadas);


// Ejer 16
        Sin Stream
        todosCoches = new ArrayList<>();
        for (Propietario p : propietarios) {
            todosCoches.addAll(p.getCoches());
        }

        int contadorToyota = 0;
        for (Coche c : todosCoches) {
            if (c.getMarca().equals("Toyota")) {
                contadorToyota++;
            }
        }
        System.out.println(contadorToyota);

        Con Stream
        long contadorToyotaStream = propietarios.stream()
            .flatMap(p -> p.getCoches().stream())
            .filter(c -> c.getMarca().equals("Toyota"))
            .count();

        System.out.println(contadorToyotaStream);


// Ejer 17
        Sin Stream
        todosCoches = new ArrayList<>();
        for (Propietario p : propietarios) {
            todosCoches.addAll(p.getCoches());
        }

        Set<String> marcasSet = new TreeSet<>();
        for (Coche c : todosCoches) {
            marcasSet.add(c.getMarca());
        }
        System.out.println(marcasSet);

        Con Stream
        List<String> marcasOrdenadas = propietarios.stream()
            .flatMap(p -> p.getCoches().stream())
            .map(Coche::getMarca)
            .distinct()
            .sorted()
            .toList();

        System.out.println(marcasOrdenadas);


// Ejer 18
        Sin Stream
        todosCoches = new ArrayList<>();
        for (Propietario p : propietarios) {
            todosCoches.addAll(p.getCoches());
        }

        Coche modernoBarato = null;
        for (Coche c : todosCoches) {
            if (c.getAno() > 2015) {
                if (modernoBarato == null || c.getPrecio() < modernoBarato.getPrecio()) {
                    modernoBarato = c;
                }
            }
        }

        if (modernoBarato != null) {
            System.out.println(modernoBarato.getMarca() + " - " + modernoBarato.getPrecio() + " - " + modernoBarato.getAno());
        }

        Con Stream
        Coche modernoBaratoStream = propietarios.stream()
            .flatMap(p -> p.getCoches().stream())
            .filter(c -> c.getAno() > 2015)
            .min(Comparator.comparingDouble(Coche::getPrecio))
            .orElse(null);

        if (modernoBaratoStream != null) {
            System.out.println(modernoBaratoStream.getMarca() + " - " + modernoBaratoStream.getPrecio() + " - " + modernoBaratoStream.getAno());
        }

         */








    }
}