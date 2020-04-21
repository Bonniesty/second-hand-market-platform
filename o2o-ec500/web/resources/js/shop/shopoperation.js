
$(function() {
	var shopId = getQueryString('shopId');

	var isEdit = shopId ? true : false;
	var initUrl = '/o2o_war_exploded/shopadmin/getshopinitinfo';
	var registerShopUrl = '/o2o_war_exploded/shopadmin/registershop';
	var shopInfoUrl = "/o2o_war_exploded/shopadmin/getshopbyid?shopId=" + shopId;
	var editShopUrl = '/o2o_war_exploded/shopadmin/modifyshop';
	if (!isEdit) {
		getShopInitInfo();
	} else {
		getShopInfo(shopId);
	}
	function getShopInfo(shopId) {
		$.getJSON(shopInfoUrl, function(data) {
			if (data.success) {
				var shop = data.shop;
				$('#shop-name').val(shop.shopName);
				$('#shop-addr').val(shop.shopAddr);
				$('#shop-phone').val(shop.phone);
				$('#shop-desc').val(shop.shopDesc);
				
			}
		});
	}
	function getShopInitInfo() {
		$.getJSON(initUrl, function(data) {
			if (data.success) {
				var tempHtml = '';
				var tempAreaHtml = '';
				
			}
		});
	}
	$('#submit').click(function() {
		var shop = {};
		if (isEdit) {
			shop.shopId = shopId;
		}
		shop.shopName = $('#shop-name').val();
		shop.shopAddr = $('#shop-addr').val();
		shop.phone = $('#shop-phone').val();
		shop.shopDesc = $('#shop-desc').val();
		
		var shopImg = $('#shop-img')[0].files[0];
		var formData = new FormData();
		formData.append('shopImg', shopImg);
		formData.append('shopStr', JSON.stringify(shop));
		
		$.ajax({
			url : (isEdit ? editShopUrl : registerShopUrl),
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('Success！');
					if (!isEdit) {
						window.location.href = "/o2o_war_exploded/shopadmin/shoplist";
					}
				} else {
					$.toast('Fail！' + data.errMsg);
				}
			
			}
		});
	});

})