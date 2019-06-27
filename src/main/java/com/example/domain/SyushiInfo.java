package com.example.domain;


public class SyushiInfo {
	
	private String buyDateTotal;
	private String buyYear;
	private String buyMonth;
	private String buyDay;
	private Integer shop;
	private Integer category;
	private String sCate;
	private Integer usePointCard;
	private Integer price;
	private Integer plusPoint;
	private Integer minusPoint;
	private String user_id;
	
	
	private Integer shopId;
	private String shopName;
	
	
	private Integer cardId;
	private String useCard;
	private Integer havePoint;
	private Integer backMoney;
	private Integer backNumber;
	
	public String searchDate;
	public String searchYear;
	public String searchMonth;
	public String searchDay;
	public String searchShop;
	
	public Integer syushiId;
	public String userId;
	public String inpDate;
	private String buyDate;
	




	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getBuyYear() {
		return buyYear;
	}
	public void setBuyYear(String buyYear) {
		this.buyYear = buyYear;
	}
	public String getBuyMonth() {
		return buyMonth;
	}
	public void setBuyMonth(String buyMonth) {
		this.buyMonth = buyMonth;
	}
	public String getBuyDay() {
		return buyDay;
	}
	public void setBuyDay(String buyDay) {
		this.buyDay = buyDay;
	}
	
	public String getBuyDateTotal() {
		buyDateTotal=buyYear + "/" + buyMonth + "/" + buyDay;
		return buyDateTotal;
	}
	public void setBuyDateTotal(String buyDateTotal) {
		this.buyDateTotal = buyDateTotal;
	}
	public Integer getShop() {
		return shop;
	}
	public void setShop(Integer shop) {
		this.shop = shop;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getUsePointCard() {
		return usePointCard;
	}
	public void setUsePointCard(Integer usePointCard) {
		this.usePointCard = usePointCard;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPlusPoint() {
		return plusPoint;
	}
	public void setPlusPoint(Integer plusPoint) {
		this.plusPoint = plusPoint;
	}
	public Integer getMinusPoint() {
		return minusPoint;
	}
	public void setMinusPoint(Integer minusPoint) {
		this.minusPoint = minusPoint;
	}
	public String getUser_id() {
		user_id = "01YamadaTarou";
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getUseCard() {
		return useCard;
	}
	public void setUseCard(String useCard) {
		this.useCard = useCard;
	}
	public Integer getHavePoint() {
		return havePoint;
	}
	public void setHavePoint(Integer havePoint) {
		this.havePoint = havePoint;
	}
	public Integer getBackMoney() {
		return backMoney;
	}
	public void setBackMoney(Integer backMoney) {
		this.backMoney = backMoney;
	}
	public Integer getBackNumber() {
		return backNumber;
	}
	public void setBackNumber(Integer backNumber) {
		this.backNumber = backNumber;
	}
	public String getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	public String getSearchYear() {
		return searchYear;
	}
	public void setSearchYear(String searchYear) {
		this.searchYear = searchYear;
	}
	public String getSearchMonth() {
		return searchMonth;
	}
	public void setSearchMonth(String searchMonth) {
		this.searchMonth = searchMonth;
	}
	public String getSearchDay() {
		return searchDay;
	}
	public void setSearchDay(String searchDay) {
		this.searchDay = searchDay;
	}
	public String getSearchShop() {
		return searchShop;
	}
	public void setSearchShop(String searchShop) {
		this.searchShop = searchShop;
	}
	public String getsCate() {
		return sCate;
	}
	public void setsCate(String sCate) {
		this.sCate = sCate;
	}
	
	
	
	

	
	
	
	
}
