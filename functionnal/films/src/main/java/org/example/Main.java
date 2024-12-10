package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {


        List<Film> filmList = new ArrayList<>();
        String filePath = "src/main/resources/data/films_data.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = br.lines().toList();

            filmList = lines.stream()
                    .skip(1)
                    .map(line -> {
                        String[] fields = line.split(",");

                        try {
                            return new Film(fields[0], fields[1], fields[2], fields[3], Integer.parseInt(fields[4]));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }


                    }).toList();

        } catch (IOException e) {
            e.printStackTrace();
        }

///////////////////////////////////////////////////I////////////////////////////////////////////////////////////////////
        //show first 10 movies
//        filmList.stream()
//                .limit(10)
//                .forEach(f-> System.out.println(f.toString()));

        //show all titles
//        filmList.stream()
//                .forEach(f-> System.out.println(f.getTitle()));

///////////////////////////////////////////////////II////////////////////////////////////////////////////////////////////

        // get all romances movies
//        String genre = "romance";
//        List<Film> romance = filmList.stream()
//                .filter(m-> Objects.equals(m.getGenre().toLowerCase(), genre))
//                .toList();
//
//        romance.forEach(film-> System.out.println(film.getTitle() + " " + film.getDate()));

        //movies made after 2000, show their titles
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        Date dateCheck = simpleDateFormat.parse("2000-01-01");
//        List<Film> onlyAfter2000 = filmList.stream()
//                .filter(film -> film.getDate().after(dateCheck))
//                .toList();
//
//        onlyAfter2000.forEach(film -> System.out.println(film.getTitle() + " " + film.getDate()));


        //by Michael Webster
//        String realisator = "Michael Webster";
//        List<Film> byMW = filmList.stream()
//                .filter(film -> film.getRealisator().equals(realisator))
//                .toList();
//
//        byMW.forEach(film -> System.out.println(film.toString()));

///////////////////////////////////////////////////III////////////////////////////////////////////////////////////////////

        //first 5 movie with ordered entries
//        List<Film> _5rderedMovies = filmList.stream()
//                .sorted(Comparator.comparingInt(Film::getEntryNb))
//                .limit(5)
//                .toList();
//
//        _5rderedMovies.forEach(film -> System.out.println(film.toString()));

        //movies ordered by date, print their title
//        List<Film> orderedMoviesByDate = filmList.stream()
//                .sorted((x, y) -> x.getDate().compareTo(y.getDate()))
//                .toList();
//
//        orderedMoviesByDate.forEach(film -> System.out.println(film.getTitle()));

///////////////////////////////////////////////////IV////////////////////////////////////////////////////////////////////

        //group by genre, print movies number
//        Map<String,Long> moviesByGenre = filmList.stream()
//                .collect(Collectors.groupingBy(Film::getGenre, Collectors.counting()));

//        for(Map.Entry entry: moviesByGenre.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

//        //group by realisator, print each movie
//        Map<String, List<String>> realisatorMovies = filmList.stream()
//                .collect(Collectors.groupingBy(Film::getRealisator,Collectors.mapping(Film::getTitle,Collectors.toList())));
//
//        for(Map.Entry entry: realisatorMovies.entrySet()){
//           System.out.println(entry.getKey() + " " + entry.getValue());
//       }

        //calculate total cinema entries
//        Long totalEntries = filmList.stream()
//                .mapToLong(Film::getEntryNb)
//                .count();
//
//        System.out.println(totalEntries);

        //the most popular genre
//        String genre = filmList.stream()
//                .collect(Collectors.groupingBy(Film::getGenre, Collectors.summingInt(Film::getEntryNb)))
//                .entrySet().stream()
//                .max(Comparator.comparingInt(Map.Entry::getValue))
//                .map(Map.Entry::getKey)
//                .orElse("nope");
//
//
//        System.out.println(genre);

        //entries summaries by realisator
//        String chosenReal = "Michael Webster";
//        Map<String,IntSummaryStatistics> entriesSummaries = filmList
//                .stream()
//                .collect(Collectors.groupingBy(Film::getRealisator, Collectors.summarizingInt(Film::getEntryNb)));
//
//        System.out.println(entriesSummaries.get(chosenReal));

///////////////////////////////////////////////////VI////////////////////////////////////////////////////////////////////

        //Transformez les données pour afficher une liste des films sous la forme : "Titre (Genre) - Réalisé par Réalisateur en Année"
//        StringBuilder stringBuilder = new StringBuilder();
//        filmList.stream()
//                .limit(10)
//                .map(film -> stringBuilder.append("titre " + film.getTitle() + " genre : " + film.getGenre() + " - réalisé par " + film.getRealisator() + " en " + film.getDate() + "\n"))
//                .toList();
//
//        System.out.println(stringBuilder);

        //unique genre
//        List<String> uniqueGenre = filmList.stream()
//                .map(Film::getGenre)
//                .distinct()
//                .toList();
//
//
//        System.out.println(uniqueGenre);

///////////////////////////////////////////////////VII////////////////////////////////////////////////////////////////////

        //find first each genre movie
//        Map<String,Film> firstFilmList = filmList.stream()
//                .collect(Collectors.groupingBy(
//                        Film::getGenre,
//                        Collectors.collectingAndThen(
//                                Collectors.minBy(Comparator.comparing(Film::getDate)),
//                                Optional::get
//                        )
//                ));
//
//        for (Map.Entry entry : firstFilmList.entrySet()){
//            System.out.println(entry.getKey() + " " +entry.getValue());
//        }

        //realisators that made more than 50 movies
//        Map<String,Long> myMap = filmList.stream()
//                .collect(Collectors.groupingBy(Film::getRealisator, Collectors.counting()
//                ))
//                .entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() > 50)
//                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
//
//        for (Map.Entry entry : myMap.entrySet()){
//            System.out.println(entry.getKey() + " " +entry.getValue());
//        }


        //total entries for movies between dates
//        String date1Str = "1999-01-01";
//        String date2Str = "2005-01-01";
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//        Date date1 = simpleDateFormat.parse(date1Str);
//        Date date2 = simpleDateFormat.parse(date2Str);
//
//        Map<Film, Integer> betweenDate = filmList.stream()
//                .filter(film -> {
//                    return film.getDate().before(date2) && film.getDate().after(date1);
//                })
//                .collect(Collectors.toMap(
//                        film -> film,
//                        Film::getEntryNb
//                ));
//
//        for (Map.Entry entry : betweenDate.entrySet()){
//            System.out.println(entry.getKey() + " " +entry.getValue());
//        }
//
    }


}


