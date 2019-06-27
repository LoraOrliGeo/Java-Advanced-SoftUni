package Generics.P07_CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = "";

        MyList<String> list = new MyList<>();

        while(!"END".equals(line = sc.nextLine())){
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Add":
                    list.add(tokens[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
//                    list.print();

                    for (String element : list) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                   Sorter.sort(list);
                    break;
            }
        }
    }
}
