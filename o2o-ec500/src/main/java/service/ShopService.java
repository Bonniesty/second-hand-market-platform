package service;

import dto.ImageHolder;
import dto.ShopExecution;
import entity.Shop;
import exceptions.ShopOperationException;
import org.springframework.stereotype.Service;

public interface ShopService {

	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);


	Shop getByShopId(long shopId);

	ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
