package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.ProductCategory;

public interface ProductCategoryDao {
	List<ProductCategory> queryProductCategoryList(long shopId);

	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	
	int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);

}
