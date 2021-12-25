package starter.data;

public enum UserData {
    USERNAME("tu77741@gmail.com"),
    PASSWORD("Test_123");

    public final String userData;

    UserData(String userData) {
        this.userData = userData;
    }

    public String value() {
     return this.userData;
    }
}
