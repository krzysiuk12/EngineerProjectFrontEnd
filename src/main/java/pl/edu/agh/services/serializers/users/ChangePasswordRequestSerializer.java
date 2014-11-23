package pl.edu.agh.services.serializers.users;

/**
 * Created by Krzysztof Kicinger on 2014-11-23.
 */
public class ChangePasswordRequestSerializer {

    private String currentPassword;
    private String newPassword;

    public ChangePasswordRequestSerializer() {
    }

    public ChangePasswordRequestSerializer(String currentPassword, String newPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
