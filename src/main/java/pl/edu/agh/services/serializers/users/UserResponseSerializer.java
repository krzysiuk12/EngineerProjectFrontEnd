package pl.edu.agh.services.serializers.users;

import pl.edu.agh.domain.useraccounts.UserAccount;
import pl.edu.agh.services.serializers.common.ResponseSerializer;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
public class UserResponseSerializer extends ResponseSerializer {

    private UserAccount result;

    public UserResponseSerializer() {
    }

    public UserAccount getResult() {
        return result;
    }

    public void setResult(UserAccount result) {
        this.result = result;
    }
}
