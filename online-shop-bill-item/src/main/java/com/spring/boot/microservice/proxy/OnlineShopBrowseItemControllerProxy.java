package com.spring.boot.microservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.boot.microservice.dto.OnlineShopBrowseItemResponseDTO;

@FeignClient(name = "online-shop-api-gateway")
public interface OnlineShopBrowseItemControllerProxy {

	@GetMapping(path = "/online-shop-browse-item/getItemById/itemId/{itemId}", produces = "application/json")
	public abstract OnlineShopBrowseItemResponseDTO getItemById(
			@PathVariable(name = "itemId", required = true) String itemId);
}
