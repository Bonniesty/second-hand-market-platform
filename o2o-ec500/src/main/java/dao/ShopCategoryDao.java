package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.ShopCategory;

public interface ShopCategoryDao {
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);

	ShopCategory queryShopCategoryById(long shopCategoryId);

	List<ShopCategory> queryShopCategoryByIds(List<Long> shopCategoryIdList);

	int insertShopCategory(ShopCategory shopCategory);

	int updateShopCategory(ShopCategory shopCategory);

	int deleteShopCategory(long shopCategoryId);

	int batchDeleteShopCategory(List<Long> shopCategoryIdList);
}
