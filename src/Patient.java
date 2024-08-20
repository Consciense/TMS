//Так же предусмотреть класс «Пациент» с полем «План лечения» и полем
//«Доктор». Создать объект класса «Пациент» и добавить пациенту план лечения.
public class Patient {
    private String name;
    private int treatmentPlan;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setTreatmentPlan(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }
}
