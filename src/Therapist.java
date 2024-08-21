public class Therapist extends MedicalStaff {

    public void scheduleDoctor(Patient patient) {
        System.out.println("Therapist schedules a doctor for " + patient.getName());
        if (patient.getTreatmentPlan() == 1) {
            System.out.println(patient.getName() + " is going to the surgeon.");
            patient.setTreatingDoctor("Surgeon");

        } else if (patient.getTreatmentPlan() == 2) {
            System.out.println(patient.getName() + " is going to the dentist.");
            patient.setTreatingDoctor("Dentist");
        } else {
            System.out.println(patient.getName() + " is going to the therapist.");
            patient.setTreatingDoctor("Therapist");
            treatPatient(patient);
        }
    }
}
