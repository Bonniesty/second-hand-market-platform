package unit_test.service;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import unit_test.BaseTest;
import dto.LocalAuthExecution;
import entity.LocalAuth;
import entity.PersonInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthServiceTest extends BaseTest {
	@Autowired
	private LocalAuthService localAuthService;

	@Test
	public void testABindLocalAuth() {

		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		String username = "testusername";
		String password = "testpassword";
		personInfo.setUserId(1L);
		localAuth.setPersonInfo(personInfo);
		localAuth.setUsername(username);
		localAuth.setPassword(password);
		LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
		localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
		System.out.println("username：" + localAuth.getPersonInfo().getName());
		System.out.println("password：" + localAuth.getPassword());
	}

	@Test
	@Ignore
	public void testBModifyLocalAuth() {
		long userId = 1;
		String username = "testusername";
		String password = "testpassword";
		String newPassword = "testnewpassword";
		LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId, username, password, newPassword);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd(username, newPassword);
		System.out.println(localAuth.getPersonInfo().getName());
	}
}
