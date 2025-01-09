package org.example;

import org.example.model.ICharacter;
import org.example.model.model_impl.HeroImpl;
import org.example.model.model_impl.MonsterImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CharacterDataHandler {

    private static final String CHARACTERS_BINARY_FILE_PATH = "src/main/resources/characters.dat";
    private static final String CHARACTERS_TEXT_PATH = "src/main/resources/monster.txt";
    private static final String EVENTS_TEXT_PATH = "src/main/resources/events.txt";
    private static final String JOURNAL_TEXT_PATH = "src/main/resources/events.txt";

    public static void characterUpload(ICharacter character) {

        if (character instanceof HeroImpl) {

            byte[] characterBinary = characterObjectToBinary(character);
            writeToBinaryFile(characterBinary);


        } else if (character instanceof MonsterImpl) {

            writeToTextFile(character.toString());

        }

    }

    public static ICharacter pickRandomHero() {

        List<ICharacter> heroList = new ArrayList<>();
        Optional<ICharacter> heroOpt = Optional.empty();

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(CHARACTERS_BINARY_FILE_PATH));
             ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream)) {

            while (true) {
                try {
                    ICharacter character = (ICharacter) objectInputStream.readObject();
                    heroList.add(character);
                } catch (EOFException e) {
                    break;
                }
            }

            System.out.println("already existing heroes: " + heroList);

            if (!heroList.isEmpty()){
                Collections.shuffle(heroList);
                heroOpt = Optional.ofNullable(heroList.getFirst());
                System.out.println("the chosen chracter is : " + heroOpt.get());
            }

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }


        return heroOpt.orElse(null);

    }

    public static void startEvents(ICharacter hero) {

    }


    private static byte[] characterObjectToBinary(ICharacter character) {

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArray)) {

            objectOutputStream.writeObject(character);


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return byteArray.toByteArray();
    }

    private static void writeToBinaryFile(byte[] bytes) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CHARACTERS_BINARY_FILE_PATH)) {

            fileOutputStream.write(bytes);
            System.out.println("we have a new character now and it was uploaded ");


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("actual character.dat content :");

    }

    private static void writeToTextFile(String characterString) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(CHARACTERS_TEXT_PATH))) {

            bufferedWriter.write(characterString);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
