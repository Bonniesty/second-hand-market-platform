$(function() {
	var productId = getQueryString('productId');
	var infoUrl = '/o2o_war_exploded/shopadmin/getproductbyid?productId=' + productId;
	var productPostUrl = '/o2o_war_exploded/shopadmin/modifyproduct';
	
	var isEdit = false;
	if (productId) {
		getInfo(productId);
		isEdit = true;
	} else {
		getCategory();
		productPostUrl = '/o2o_war_exploded/shopadmin/addproduct';
	}

	function getInfo(id) {
		$
				.getJSON(
						infoUrl,
						function(data) {
							if (data.success) {
								
								var product = data.product;
								$('#product-name').val(product.productName);
								$('#product-desc').val(product.productDesc);
								$('#priority').val(product.priority);
								$('#point').val(product.point);
								$('#normal-price').val(product.normalPrice);
								$('#promotion-price').val(
										product.promotionPrice);
								
							}
						});
	}

	function getCategory() {
		$.getJSON(categoryUrl, function(data) {
			if (data.success) {
				var productCategoryList = data.data;
				var optionHtml = '';
				productCategoryList.map(function(item, index) {
					optionHtml += '<option data-value="'
							+ item.productCategoryId + '">'
							+ item.productCategoryName + '</option>';
				});
				$('#category').html(optionHtml);
			}
		});
	}


	$('.detail-img-div').on('change', '.detail-img:last-child', function() {
		if ($('.detail-img').length < 6) {
			$('#detail-img').append('<input type="file" class="detail-img">');
		}
	});

	$('#submit').click(
			function() {
				var product = {};
				product.productName = $('#product-name').val();
				product.productDesc = $('#product-desc').val();
				product.priority = $('#priority').val();
				product.point = $('#point').val();
				product.normalPrice = $('#normal-price').val();
				product.promotionPrice = $('#promotion-price').val();
				
				product.productId = productId;

				var thumbnail = $('#small-img')[0].files[0];
				var formData = new FormData();
				formData.append('thumbnail', thumbnail);
				$('.detail-img').map(
						function(index, item) {
							if ($('.detail-img')[index].files.length > 0) {
								formData.append('productImg' + index,
										$('.detail-img')[index].files[0]);
							}
						});
				formData.append('productStr', JSON.stringify(product));
				
				$.ajax({
					url : productPostUrl,
					type : 'POST',
					data : formData,
					contentType : false,
					processData : false,
					cache : false,
					success : function(data) {
						if (data.success) {
							$.toast('Success！');
							$('#captcha_img').click();
						} else {
							$.toast('Fail！');
							$('#captcha_img').click();
						}
					}
				});
			});

});