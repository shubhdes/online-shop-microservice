package com.spring.boot.microservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.microservice.dto.Item;
import com.spring.boot.microservice.dto.OnlineShopBrowseItemResponseDTO;

@RestController
public class OnlineShopBrowseItemController {

	private static final List<Item> itemList = Arrays.asList(new Item("I001", "Lenovo Laptop", 40000.43d),
			new Item("I002", "HP Printer", 6000.42d), new Item("I003", "Lenovo Mouse", 1500.13d),
			new Item("I004", "Dell Keyboard", 12000.11d), new Item("I005", "Dell Laptop", 60000.21d));

	private static final String SUCCESS_RESPONSE = "SUCCESS";

	@GetMapping(path = "/getAllItems", produces = "application/json")
	public OnlineShopBrowseItemResponseDTO getAllItems() {
		return new OnlineShopBrowseItemResponseDTO(SUCCESS_RESPONSE, itemList);
	}

	@GetMapping(path = "/getItemById/itemId/{itemId}", produces = "application/json")
	public OnlineShopBrowseItemResponseDTO getItemById(@PathVariable(name = "itemId", required = true) String itemId) {

		Optional<Item> optionalItem = itemList.stream().filter(item -> itemId.equals(item.getItemId())).findFirst();

		if (optionalItem.isPresent()) {
			return new OnlineShopBrowseItemResponseDTO(SUCCESS_RESPONSE, Arrays.asList(optionalItem.get()));
		}

		return new OnlineShopBrowseItemResponseDTO(SUCCESS_RESPONSE, Arrays.asList());
	}
}
