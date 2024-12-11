package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Set<Book> bookSet = new HashSet<>();

        String filePath = "src/main/resources/books_dataset.csv";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            List<String> allBooksStringLines = bufferedReader.lines().toList();

            bookSet = allBooksStringLines.stream()
                    .skip(1)
                    .map(line -> {
                        String[] fields = line.split(",");
                        try {
                            return new Book(fields[0], fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), Boolean.parseBoolean(fields[5]), Double.parseDouble(fields[6]));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toSet());


        } catch (Exception e) {
            e.printStackTrace();
        }


//        Filtrer les livres disponibles (dont estDisponible est true).

//        bookSet.stream()
//                .filter(Book::isAvailable)
//                .forEach(System.out::println);


//        Trouver les livres publiés avant 1900 et afficher leur titre et auteur.

//        LocalDate before1990 = LocalDate.of(1990, Month.JANUARY, 1);
//        bookSet.stream()
//                .filter(book -> book.getPublicationDate().isBefore(before1990))
//                .forEach(book -> System.out.println("- date: " + book.getPublicationDate() + " " + book.getTitle() + " " + book.getAuthor()));


//        Grouper les livres par genre (par exemple, tous les "Romans" ensemble, tous les "Science-fiction" ensemble, etc.).
//
//        Map<String,List<Book>> allBooksByGenre = bookSet.stream()
//                .collect(Collectors.groupingBy(Book::getGenre));
//
//        for (Map.Entry entry : allBooksByGenre.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }


//                Trouver le livre le plus ancien  (le livre avec la date de publication la plus ancienne).


//        Optional<Book> mostAnciantBook = bookSet.stream()
//                .min(Comparator.comparing(Book::getPublicationDate));
//
//        System.out.println(mostAnciantBook);


//        Vérifier s'il existe des livres dont le titre commence par "Harry".
//
//
//        boolean isHarryIsHere = bookSet.stream()
//                .anyMatch(book -> book.getTitle().startsWith("Harry"));
//
//        System.out.println(isHarryIsHere);


//        Calculer le prix moyen des livres disponibles
//        Double averagePrice = bookSet.stream()
//                .filter(Book::isAvailable)
//                .mapToDouble(b->b.getPrice())
//                .average()
//                .getAsDouble();
//
//        System.out.println(averagePrice);


//        Trier les livres par nombre de pages, puis par prix (en cas d'égalité du nombre de pages).
//        bookSet.stream()
//                .sorted(Comparator.comparing(Book::getPageNumber)
//                        .thenComparing(Book::getPrice))
//                .forEach(System.out::println);


//        Calculer le total des pages pour tous les livres de genre "Fantasy".

//        String trackedGenre = "fantasy";
//        Integer pageNb = bookSet.stream()
//                .filter(book -> book.getGenre().toLowerCase().equals(trackedGenre))
//                .mapToInt(Book::getPageNumber)
//                .sum();
//
//        System.out.println(pageNb);


//                Trouver le livre le plus cher disponible à la vente.

//        Optional<Book> mostEpensiveBook = bookSet.stream()
//                .filter(Book::isAvailable)
//                .max(Comparator.comparingDouble(Book::getPrice))
//                .stream().findFirst();
//
//        System.out.println(mostEpensiveBook);


//                Trouver les auteurs les plus prolifiques (les auteurs ayant écrit plus de 17 livre) et afficher leurs livres.

//        bookSet.stream()
//                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.toSet()))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue().size() > 17)
//                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));


//      Compter le nombre de livres dans chaque genre (afficher par exemple combien de "Romans", combien de "Science-fiction", etc.).
//        bookSet.stream()
//                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));


//        Vérifier si un livre est disponible et si son prix est inférieur à un seuil donné, et afficher les livres correspondants.
//          double limit = 10d;
//
//        bookSet.stream()
//                .filter(Book::isAvailable)
//                .filter(book -> book.getPrice() < limit)
//                .forEach(book -> System.out.println(book));




//        Calculer le nombre total de pages pour les livre de chaque année.

//        Map<Integer,Integer> total = bookSet.stream()
//                .collect(Collectors.toMap(book -> book.getPublicationDate().getYear(),
//                        Book::getPageNumber,
//                        Integer::sum
//                        ));
//
//        System.out.println(total);

    }
}