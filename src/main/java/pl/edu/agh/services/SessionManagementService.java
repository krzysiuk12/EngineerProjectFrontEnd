package pl.edu.agh.services;

import org.springframework.stereotype.Service;
import pl.edu.agh.exceptions.response.*;
import pl.edu.agh.services.serializers.common.BaseResponseSerializer;
import pl.edu.agh.services.serializers.session.LoginRequestSerializer;
import pl.edu.agh.services.serializers.session.LoginResponseSerializer;
import pl.edu.agh.web.navigation.ServerPaths;

/**
 * Created by Krzysztof Kicinger on 2014-11-17.
 */
@Service
public class SessionManagementService extends BaseService {

    public String loginUser(String login, String password, String token) throws ZeroResultsException, AccessDeniedException, RequestDeniedException, UnknownErrorException, FormValidationError {
        LoginRequestSerializer loginRequestSerializer = new LoginRequestSerializer(login, password, null);
        LoginResponseSerializer rs = executeHttpPostRequest(ServerPaths.getLoginUserRequestPath(), token, loginRequestSerializer, LoginResponseSerializer.class);
        return ((LoginRequestSerializer) parseResponse(rs)).getToken();
    }

    public boolean logoutUser(String token) throws ZeroResultsException, AccessDeniedException, RequestDeniedException, UnknownErrorException, FormValidationError {
        BaseResponseSerializer rs = executeHttpGetRequest(ServerPaths.getLogoutUserRequestPath(), token, BaseResponseSerializer.class);
        return testResponseCorrectness(rs);
    }

}
