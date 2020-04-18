package unit.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import unit.BaseTest;
import dto.ImageHolder;
import dto.ShopExecution;
import entity.Area;
import entity.PersonInfo;
import entity.Shop;
import enums.ShopStateEnum;
import exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;

	@Test
	@Ignore
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		ShopExecution se = shopService.getShopList(shopCondition, 2, 2);
		System.out.println("size of shop list：" + se.getShopList().size());
		System.out.println("number of shop："+ se.getCount());
	}

	
	@Test
	public void testAddShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		owner.setUserId(1L);
		area.setAreaId(2);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopName("TestShop3");
		shop.setShopDesc("test3");
		shop.setShopAddr("test3");
		shop.setPhone("test3");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("Under Verify");
		File shopImg = new File("/Users/tysun/Desktop/image/test.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
		ShopExecution se = shopService.addShop(shop, imageHolder );
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}

}
