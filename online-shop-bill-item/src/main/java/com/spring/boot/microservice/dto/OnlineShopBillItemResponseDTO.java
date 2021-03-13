package com.spring.boot.microservice.dto;

import java.util.List;

public class OnlineShopBillItemResponseDTO {

	private String responseStatus;

	private List<Bill> billList;

	public OnlineShopBillItemResponseDTO() {
		super();
	}

	public OnlineShopBillItemResponseDTO(String responseStatus, List<Bill> billList) {
		super();
		this.responseStatus = responseStatus;
		this.billList = billList;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public List<Bill> getBillList() {
		return billList;
	}

	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}

}
