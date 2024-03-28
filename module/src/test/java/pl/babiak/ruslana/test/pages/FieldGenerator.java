package pl.babiak.ruslana.test.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class FieldGenerator {

    public String generatePassword() {
        return UUID.randomUUID().toString();
    }

    public String generateEmail() {
        return RandomNamesClass.getRandomName().toLowerCase()
                + RandomSurnamesClass.getRandomSurname().toLowerCase()
                + "@gmail.com";
    }


    private static class RandomNamesClass {
        private static List<String> names;

        public RandomNamesClass() {
            names = new ArrayList<>();
            names.add("Alex");
            names.add("Ali");
            names.add("Russel");
            names.add("Loren");
            names.add("Jessie");
            names.add("Mae");
            names.add("Jack");
            names.add("Justin");
            names.add("Austin");
            names.add("Ethan");
            names.add("Billie");
            names.add("Larry");
            names.add("Alan");
            names.add("Adrian");
            names.add("Brooklyn");
            names.add("Casey");
            names.add("Carroll");
            names.add("Cory");
            names.add("Drew");
            names.add("Bobby");
        }

        public static String getRandomName() {
            Random random = new Random();
            return names.get(random.nextInt(names.size()));
        }
    }


    private static class RandomSurnamesClass {
        private static List<String> surnames;

        public RandomSurnamesClass() {
            surnames = new ArrayList<>();
            surnames.add("Robinson");
            surnames.add("Martin");
            surnames.add("Sanchez");
            surnames.add("Ramirez");
            surnames.add("Walker");
            surnames.add("Brown");
            surnames.add("Allen");
            surnames.add("Harris");
            surnames.add("Thompson");
            surnames.add("Smith");
            surnames.add("Perez");
            surnames.add("Carter");
            surnames.add("Gomez");
            surnames.add("Rivera");
            surnames.add("Evans");
            surnames.add("Turner");
            surnames.add("Stewart");
            surnames.add("Murphy");
            surnames.add("Collins");
            surnames.add("Rogers");
        }

        public static String getRandomSurname() {
            Random random = new Random(surnames.size());
            return surnames.get(random.nextInt());
        }
    }
}
