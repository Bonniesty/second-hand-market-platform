package service;

import java.util.List;

import dto.ImageHolder;
import dto.ProductExecution;
import entity.Product;
import exceptions.ProductOperationException;

public interface ProductService {

	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

	Product getProductById(long productId);

	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;
			
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException;
}
