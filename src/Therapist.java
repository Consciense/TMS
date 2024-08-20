public class Therapist extends MedicalStaff {

    @Override
    public void treatPatient(Patient patient) {
        super.treatPatient(patient);
    }

    public void scheduleDoctor(Patient patient) {
        System.out.println("Therapist schedules a doctor for " + patient.getName());
        if (patient.getTreatmentPlan() == 1) {
            patient.setTreatingDoctor("Surgeon");
        }
        if (patient.getTreatmentPlan() == 2) {
            patient.setTreatingDoctor("Dentist");
        } else {
            patient.setTreatingDoctor("Therapist");
            treatPatient(patient);
        }
    }
}
