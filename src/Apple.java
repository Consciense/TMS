//Создать класс Apple и добавить в него поле color с модификатором доступа private и инициализировать его.
// В методе main другого класса создать объект Apple, и не используя сеттеры изменить значение поля color.

public class Apple {
    private String color;
    private String currentRipeness;

    // [0] - "not ripe"
    // [1] - "ripe"
    // [2] - "overripe"
    // [3] - "rotten"

    Apple(String color, String currentRipeness) {
        this.color = color;
        this.currentRipeness = currentRipeness;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCurrentRipeness(String currentRipeness) {
        this.currentRipeness = currentRipeness;
    }

    public String getCurrentRipeness() {
        return currentRipeness;
    }

    public void showAppleInfo() {
        System.out.println("Current apple color is: " + getColor());
        System.out.println("It is: " + getCurrentRipeness());
    }

    // Is it counts as NOT USING setters? (contact me pls =) )
    // ripeUp can set color/ripeness by using "this." if we wanna to delete setters completely.
    public void ripeUp() {
        System.out.println("Apple lays on the table for another week...");
        System.out.println("So it changes...");
        switch (currentRipeness) {
            case "not ripe":
                setCurrentRipeness("ripe");
                setColor("yellow");
                break;
            case "ripe":
                setCurrentRipeness("overripe");
                setColor("orange");
                break;
            case "overripe":
                setCurrentRipeness("rotten");
                setColor("brown");
                break;
            case "rotten":
                System.out.println("The apple is rotten already. No way it could change.");
                break;
        }
    }

}
