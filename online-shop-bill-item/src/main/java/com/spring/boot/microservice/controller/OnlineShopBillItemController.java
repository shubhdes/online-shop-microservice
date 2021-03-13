package com.spring.boot.microservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.microservice.dto.Bill;
import com.spring.boot.microservice.dto.Item;
import com.spring.boot.microservice.dto.OnlineShopBillItemResponseDTO;
import com.spring.boot.microservice.dto.OnlineShopBrowseItemResponseDTO;
import com.spring.boot.microservice.proxy.OnlineShopBrowseItemControllerProxy;

@RestController
public class OnlineShopBillItemController {

	@Autowired
	private OnlineShopBrowseItemControllerProxy onlineShopBrowseItemControllerProxy;

	private static final String SUCCESS_RESPONSE = "SUCCESS";

	@GetMapping(path = "/billItem/itemId/{itemId}/itemQty/{itemQty}", produces = "application/json")
	public OnlineShopBillItemResponseDTO billItem(@PathVariable(name = "itemId", required = true) String itemId,
			@PathVariable(name = "itemQty", required = true) int itemQty) {

		OnlineShopBrowseItemResponseDTO onlineShopBrowseItemCommonDTO = onlineShopBrowseItemControllerProxy
				.getItemById(itemId);

		List<Item> itemList = onlineShopBrowseItemCommonDTO.getItemList();

		if (!itemList.isEmpty()) {

			Item item = itemList.get(0);
			double totalCost = itemQty * item.getItemCost();

			return new OnlineShopBillItemResponseDTO(SUCCESS_RESPONSE, Arrays
					.asList(new Bill(item.getItemId(), item.getItemName(), item.getItemCost(), itemQty, totalCost)));
		}

		return new OnlineShopBillItemResponseDTO(SUCCESS_RESPONSE, Arrays.asList());
	}
}
