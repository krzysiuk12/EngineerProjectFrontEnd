package pl.edu.agh.services;

import org.springframework.stereotype.Service;
import pl.edu.agh.domain.useraccounts.UserAccount;
import pl.edu.agh.services.serializers.common.BaseResponseSerializer;
import pl.edu.agh.services.serializers.users.*;
import pl.edu.agh.web.navigation.ServerPaths;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
@Service
public class UsersManagementService extends BaseService {

    public boolean addNewUserAccount(String login, String password, String email, String firstName, String lastName) throws Exception {
        UserRegistrationRequestSerializer userRegistrationRequestSerializer = new UserRegistrationRequestSerializer(login, password, email, firstName, lastName);
        BaseResponseSerializer rs = executeHttpPostRequest(ServerPaths.getAddNewUserAccountRequestPath(), null, userRegistrationRequestSerializer, BaseResponseSerializer.class);
        return testResponseCorrectness(rs);
    }

    public List<UserAccount> getAllUserAccounts(String token) throws Exception {
        UsersListResponseSerializer rs = executeHttpGetRequest(ServerPaths.getAllUserAccountsRequestPath(), token, UsersListResponseSerializer.class);
        return (List<UserAccount>) parseResponse(rs);
    }

    public UserAccount getUserAccountById(Long id, String token) throws Exception {
        UserResponseSerializer rs = executeHttpGetRequest(ServerPaths.getUserAccountByIdRequestPath(id), token, UserResponseSerializer.class);
        return (UserAccount) parseResponse(rs);
    }

    public UserAccount getUserAccountByIdAllData(Long id, String token) throws Exception {
        UserResponseSerializer rs = executeHttpGetRequest(ServerPaths.getUserAccountByIdAllDataRequestPath(id), token, UserResponseSerializer.class);
        return (UserAccount) parseResponse(rs);
    }

    public UserAccount getMyUserAccountById(String token) throws Exception {
        UserResponseSerializer rs = executeHttpGetRequest(ServerPaths.getMyUserAccountRequestPath(), token, UserResponseSerializer.class);
        return (UserAccount) parseResponse(rs);
    }
    public UserAccount getMyUserAccountByIdAllData(String token) throws Exception {
        UserResponseSerializer rs = executeHttpGetRequest(ServerPaths.getMyUserAccountAllDataRequestPath(), token, UserResponseSerializer.class);
        return (UserAccount) parseResponse(rs);
    }

    public boolean changeUserAccountPassword(String currentPassword, String newPassword, String token) throws Exception {
        ChangePasswordRequestSerializer changePasswordRequestSerializer = new ChangePasswordRequestSerializer(currentPassword, newPassword);
        BaseResponseSerializer rs = executeHttpPostRequest(ServerPaths.getChangePasswordRequestPath(), token, changePasswordRequestSerializer, BaseResponseSerializer.class);
        return testResponseCorrectness(rs);
    }

    public boolean updateUserAccount(String email, String firstName, String lastName, String city, String country, String description, String token) throws Exception {
        UserAccountRequestSerializer userAccountRequestSerializer = new UserAccountRequestSerializer(email, firstName, lastName, description, city, country);
        BaseResponseSerializer rs = executeHttpPostRequest(ServerPaths.getUpdateUserAccountRequestPath(), token, userAccountRequestSerializer, BaseResponseSerializer.class);
        return testResponseCorrectness(rs);
    }
}
