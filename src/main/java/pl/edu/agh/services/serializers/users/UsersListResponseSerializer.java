package pl.edu.agh.services.serializers.users;

import pl.edu.agh.domain.useraccounts.UserAccount;
import pl.edu.agh.services.serializers.common.ResponseSerializer;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
public class UsersListResponseSerializer extends ResponseSerializer {

    private List<UserAccount> result;

    public UsersListResponseSerializer() {
    }

    public List<UserAccount> getResult() {
        return result;
    }

    public void setResult(List<UserAccount> result) {
        this.result = result;
    }
}
