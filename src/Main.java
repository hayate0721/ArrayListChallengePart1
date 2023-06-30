import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean stop = false;
        ArrayList<String> list = new ArrayList<>();
        while(!stop){
            printAction();
            switch (Integer.parseInt(scanner.nextLine())){
                case 1 -> addItems(list);
                case 2 -> removeItems(list);
                default -> stop = true;
            }
            list.sort(Comparator.naturalOrder());
            System.out.println(list);
        }

    }

    private static void addItems(ArrayList<String> list){

        System.out.println("Add item(s) [separate items by comma]:");
        String[] item = scanner.nextLine().split(",");

        for(String i : item){
            String trimmed = i.trim();
            if(!list.contains(trimmed)){
                list.add(trimmed);
            }
        }

    }

    private static void removeItems(ArrayList<String> list){

        System.out.println("Remove item(s) [separate items by comma]:");
        String[] item = scanner.nextLine().split(",");

        for(String i : item){
            String trimmed = i.trim();
            list.remove(trimmed);
        }

    }

    private static void printAction(){

        String textBlock = """
                Available actions:
                
                0 - to shut down
                1 - to add item(s) to list (comma delimited list)
                2 - to remove any items (comma delimited list)
                
                Enter a number for which action you want to do:
                
                """;
        System.out.print(textBlock + " ");
    }
}
