package service;

import dto.LocalAuthExecution;
import entity.LocalAuth;
import exceptions.LocalAuthOperationException;

public interface LocalAuthService {

	LocalAuth getLocalAuthByUsernameAndPwd(String userName, String password);

	LocalAuth getLocalAuthByUserId(long userId);

	LocalAuthExecution bindLocalAuth(LocalAuth localAuth) throws LocalAuthOperationException;

	LocalAuthExecution modifyLocalAuth(Long userId, String username, String password, String newPassword)
			throws LocalAuthOperationException;
}
