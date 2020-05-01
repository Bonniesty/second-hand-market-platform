package dao;

import java.util.List;

import entity.ProductImg;

public interface ProductImgDao {
	List<ProductImg> queryProductImgList(long productId);

	int batchInsertProductImg(List<ProductImg> productImgList);

	int deleteProductImgByProductId(long productId);
}
