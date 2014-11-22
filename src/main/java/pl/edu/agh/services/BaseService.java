package pl.edu.agh.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.exceptions.response.*;
import pl.edu.agh.services.serializers.common.ResponseSerializer;
import pl.edu.agh.services.serializers.common.ResponseStatus;

/**
 * Created by Krzysztof Kicinger on 2014-11-17.
 */
public class BaseService {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    public HttpEntity getHttpEntityWithoutBodyRequest(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION_HEADER, token);
        return new HttpEntity(headers);
    }

    public <T> HttpEntity<T> getHttpEntityWithBodyRequest(String token, T body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION_HEADER, token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<T>(body, headers);
    }

    public <T> T executeHttpGetRequest(String path, String token, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, HttpMethod.GET, getHttpEntityWithoutBodyRequest(token), clazz).getBody();
    }

    public <T, E> E executeHttpPostRequest(String path, String token, T body, Class<E> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, HttpMethod.POST, getHttpEntityWithBodyRequest(token, body), clazz).getBody();
    }

    public <T, E> E executeHttpPutRequest(String path, String token, T body, Class<E> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, HttpMethod.PUT, getHttpEntityWithBodyRequest(token, body), clazz).getBody();
    }

    public <T> T executeHttpDeleteRequest(String path, String token, Class<T> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(path, HttpMethod.DELETE, getHttpEntityWithoutBodyRequest(token), clazz).getBody();
    }

    public Object parseResponse(ResponseSerializer responseSerializer) throws ZeroResultsException, AccessDeniedException, RequestDeniedException, UnknownErrorException, FormValidationError {
        testStatus(responseSerializer);
        return responseSerializer.getResult();
    }

    public boolean testResponseCorrectness(ResponseSerializer responseSerializer) throws ZeroResultsException, AccessDeniedException, RequestDeniedException, UnknownErrorException, FormValidationError {
        testStatus(responseSerializer);
        return responseSerializer.getStatus() == ResponseStatus.OK;
    }

    private void testStatus(ResponseSerializer responseSerializer) throws ZeroResultsException, AccessDeniedException, RequestDeniedException, UnknownErrorException, FormValidationError {
        switch(responseSerializer.getStatus()) {
            case ZERO_RESULTS: break;//throw new ZeroResultsException();
            case ACCESS_DENIED: throw new AccessDeniedException();
            case REQUEST_DENIED: throw new RequestDeniedException();
            case VALIDATION_ERROR: throw new FormValidationError(responseSerializer.getErrorMessage());
            case UNKNOWN_ERROR: throw new UnknownErrorException();
        }
    }
}
