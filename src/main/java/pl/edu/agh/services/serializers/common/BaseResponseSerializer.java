package pl.edu.agh.services.serializers.common;

/**
 * Created by Krzysztof Kicinger on 2014-11-17.
 */
public class BaseResponseSerializer extends ResponseSerializer {

    private Object result;

    public BaseResponseSerializer() {
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
