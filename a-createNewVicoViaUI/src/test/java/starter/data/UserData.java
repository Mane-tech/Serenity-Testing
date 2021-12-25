package starter.data;

public enum UserData {
    USERNAME("dasag68767@xtrempro.com"),
    PASSWORD("P@ssw0rd");

    public final String userData;

    UserData(String userData) {
        this.userData = userData;
    }

    public String value() {
     return this.userData;
    }
}
