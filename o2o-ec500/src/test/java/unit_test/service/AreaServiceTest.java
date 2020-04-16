package unit_test.service;



import static org.junit.Assert.assertEquals;

import java.util.List;

import service.AreaService;
import service.impl.AreaServiceImpl;
import unit_test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import entity.Area;



public class AreaServiceTest extends BaseTest {

	@Autowired
	private AreaService areaService;

	@Test
	public void testGetAreaList(){
		List<Area> areaList = areaService.getAreaList();
		assertEquals("boston", areaList.get(0).getAreaName());
	}
}