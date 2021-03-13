package com.spring.boot.microservice.dto;

import java.util.List;

public class OnlineShopBrowseItemResponseDTO {

	private String responseStatus;

	private List<Item> itemList;

	public OnlineShopBrowseItemResponseDTO() {
		super();
	}

	public OnlineShopBrowseItemResponseDTO(String responseStatus, List<Item> itemList) {
		super();
		this.responseStatus = responseStatus;
		this.itemList = itemList;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
