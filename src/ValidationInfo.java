public class ValidationInfo {
    private String message;
    private boolean isCorrect;

    public ValidationInfo() {
        this.message = "";
        this.isCorrect = true;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        this.isCorrect = correct;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
