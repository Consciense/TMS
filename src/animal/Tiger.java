package animal;

public class Tiger extends Animal{


    Tiger(String name, String animalType) {
        super("Tiger");
    }

    @Override
    public void voice(boolean isHappy) {
        super.voice(isHappy);
        System.out.println(isHappy ? "Tiger looks at you and starts purring" : "Tiger is not paying attention to your food." );
    }

    @Override
    public void eat(String food) {
        super.eat(food);
        System.out.println("Your food looks back...");
        if (food.equals("Meat")) {
            System.out.println("Tiger starts to eat.");
            voice(true);
        } else {
            voice(false);
        }
    }

}
