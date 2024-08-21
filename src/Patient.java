//Так же предусмотреть класс «Пациент» с полем «План лечения» и полем
//«Доктор». Создать объект класса «Пациент» и добавить пациенту план лечения.
public class Patient {
    private final String name;
    private final int treatmentPlan;
    private String treatingDoctor;

    Patient(String name, int treatmentPlan, String treatingDoctor) {
        this.name = name;
        this.treatmentPlan = treatmentPlan;
        this.treatingDoctor = treatingDoctor;
    }

    public int getTreatmentPlan() {
        return treatmentPlan;
    }

    public String getName() {
        return name;
    }

    public String getTreatingDoctor() {
        return treatingDoctor;
    }

    public void setTreatingDoctor(String treatingDoctor) {
        this.treatingDoctor = treatingDoctor;
    }
}
