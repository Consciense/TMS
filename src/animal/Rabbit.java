package animal;

public class Rabbit extends Animal{


    Rabbit(String name, String animalType) {
        super("Rabbit");
    }

    @Override
    public void voice(boolean isHappy) {
        super.voice(isHappy);
        System.out.println("Rabbit decides to be silent at the moment.");
    }

    @Override
    public void eat(String food) {
        super.eat(food);
        if (food.equals("Meat")) {
            System.out.println("Rabbit is not happy about that... \n Slowly walks away...");
            voice(false);
        } else {
            System.out.println("Rabbit starts chewing your grass...");
            voice(true);
        }
    }

}
