package unit_test.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import unit_test.BaseTest;
import entity.LocalAuth;
import entity.PersonInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthDaoTest extends BaseTest {
	@Autowired
	private LocalAuthDao localAuthDao;
	private static final String username = "testusername";
	private static final String password = "testpassword";

	@Test
	public void testAInsertLocalAuth() throws Exception {

		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		localAuth.setPersonInfo(personInfo);
		localAuth.setUsername(username);
		localAuth.setPassword(password);
		localAuth.setCreateTime(new Date());
		int effectedNum = localAuthDao.insertLocalAuth(localAuth);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryLocalByUserNameAndPwd() throws Exception {
		LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(username, password);
		assertEquals("test", localAuth.getPersonInfo().getName());
	}

	@Test
	public void testCQueryLocalByUserId() throws Exception {
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
		assertEquals("test", localAuth.getPersonInfo().getName());
	}

	@Test
	public void testDUpdateLocalAuth() throws Exception {
		Date now = new Date();
		int effectedNum = localAuthDao.updateLocalAuth(1L, username, password, password + "new", now);
		assertEquals(1, effectedNum);
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
		System.out.println(localAuth.getPassword());
	}

}
