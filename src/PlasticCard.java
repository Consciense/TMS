import java.util.HashMap;

public class PlasticCard {

    public static void task1() {
        HashMap<String, Double> card = new HashMap<>();
        card.put("5570 7503 3001 4269", 1231.27);
        System.out.println(card);
        card.put("4601 2204 1282 3043", 123123.2);
        card.put("4496 5501 6326 8093", 123123.0);
        System.out.println("Added 2 mor cards to HashMap");
        System.out.println(card);
        System.out.println("Deleting 2 elements: ");
        card.remove("5570 7503 3001 4269");
        card.remove("4601 2204 1282 3043");
        System.out.println(card);
        System.out.println("All available keys:");
        System.out.println(card.keySet());
        System.out.println("All available values:");
        System.out.println(card.values());
        System.out.println("Is there any elements in collection? : " + !card.isEmpty());
    }
}
