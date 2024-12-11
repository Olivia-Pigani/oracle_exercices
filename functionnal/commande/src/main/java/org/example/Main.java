package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Commande> commandes = Arrays.asList(
                new Commande(1, "Alice", Arrays.asList("Ordinateur", "Souris"), 1200.50, true),
                new Commande(2, "Bob", Arrays.asList("Clavier", "Écran"), 300.75, false),
                new Commande(3, "Charlie", Arrays.asList("Imprimante", "post it"), 150.00, true),
                new Commande(4, "Alice", Arrays.asList("USB", "Casque", "pokemon"), 75.50, false),
                new Commande(5, "Bob", Arrays.asList("Tablette"), 200.00, true)
        );


        //Afficher toutes les commandes.
//        commandes.stream()
//                .forEach(commande -> System.out.println(commande));

        //Récupérer et afficher le nom des clients de chaque commande.
//        commandes.stream()
//                .forEach(commande -> System.out.println(commande.getClient()));

        //Calculer et afficher le montant total de toutes les commandes.
//        double total = commandes.stream()
//                .mapToDouble(Commande::getMontantTotal)
//                .sum();
//
//
//        System.out.println(total);

        //Afficher les articles et le prix total pour chaque commande.
//        Map<Double, List<String>> result = commandes.stream()
//                .collect(Collectors.toMap(Commande::getMontantTotal,
//                        commande -> commande.getArticles()))
//                ;
//
//        System.out.println(result);

        //Lister les commandes livrées : Utiliser Stream.filter pour filtrer les commandes livrées.
//        List<Commande> delivered = commandes.stream()
//                .filter(commande -> commande.isEstLivree() == true)
//                .toList();
//
//        System.out.println(delivered);


//Calculer le montant total par client : Grouper les commandes par client avec Collectors.groupingBy et calculer la somme des montants

//
//        Map<String, Double> totalPerClient = commandes.stream()
//                .collect(Collectors.groupingBy(Commande::getClient,
//                        Collectors.summingDouble(Commande::getMontantTotal)));
//
//        for(Map.Entry entry : totalPerClient.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        //Obtenir les articles uniques commandés
//        List<String> uniqueArticleList = commandes.stream()
//                .flatMap(commande -> commande.getArticles().stream())
//                .distinct()
//                .toList();
//
//        System.out.println(uniqueArticleList);

        //Vérifier si tous les clients ont une commande livrée : Grouper par client et utiliser Stream.allMatch pour vérifier la condition.
//        boolean isEverybodyDelivered = commandes.stream()
//                .collect(Collectors.groupingBy(Commande::getClient))
//                .values()
//                .stream()
//                .allMatch(commande -> commande.stream().allMatch(Commande::isEstLivree));
//
//        System.out.println(isEverybodyDelivered);



    }

}