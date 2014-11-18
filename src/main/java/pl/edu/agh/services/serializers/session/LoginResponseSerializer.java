package pl.edu.agh.services.serializers.session;

import pl.edu.agh.services.serializers.common.ResponseSerializer;

/**
 * Created by Krzysztof Kicinger on 2014-11-17.
 */
public class LoginResponseSerializer extends ResponseSerializer {

    private LoginRequestSerializer result;

    public LoginResponseSerializer() {
    }

    public LoginRequestSerializer getResult() {
        return result;
    }

    public void setResult(LoginRequestSerializer result) {
        this.result = result;
    }
}
