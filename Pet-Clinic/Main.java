package java_advanced.iterators_and_comparators.petClinic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int commandsCount = Integer.parseInt(sc.nextLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    if (tokens[1].equals("Pet")) {
                        // create pet
                        String petName = tokens[2];
                        Pet pet = new Pet(petName, Integer.parseInt(tokens[3]), tokens[4]);
                        pets.putIfAbsent(petName, pet);
                    } else {
                        // create clinic
                        try {
                            String clinicName = tokens[2];
                            Clinic clinic = new Clinic(clinicName, Integer.parseInt(tokens[3]));
                            clinics.putIfAbsent(clinicName, clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = tokens[1];
                    String clinicName = tokens[2];
                    Pet pet = pets.get(petName);
                    Clinic clinic = clinics.get(clinicName);
                    System.out.println(clinic.addPet(pet));
                    break;
                case "Release":
                    Clinic c = clinics.get(tokens[1]);
                    System.out.println(c.release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(tokens[1]).hasEmptyRooms());
                    break;
                case "Print":
                    String klinikName = tokens[1];
                    Clinic klinik = clinics.get(klinikName);
                    if (tokens.length == 2) {
                        // print each room in the specified clinic
                        for (Pet p : klinik.getPets()) {
                            if(p == null){
                                System.out.println("Room empty");
                            } else {
                                System.out.println(p.toString());
                            }
                        }
                    } else {
                        int room = Integer.parseInt(tokens[2]);
                        klinik.printClinicRoomInfo(room);
                    }
                    break;
            }
        }
    }
}
