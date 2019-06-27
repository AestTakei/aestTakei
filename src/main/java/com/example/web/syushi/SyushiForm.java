package com.example.web.syushi;

import java.util.*;

import com.example.domain.SyushiInfo;

public class SyushiForm {
	
	//①Inputパラメーター
	private String buyYear;
	private String buyMonth;
	private String buyDay;
	private Integer shop;
	private Integer category;
	private Integer usePointCard;
	private Integer price;
	private Integer plusPoint;
	private Integer minusPoint;

	//②取得した店舗情報を格納
	public List<SyushiInfo> TenpoList;
	public Map<Integer,String> TenpoMap;
	
	//③カテゴリー　getterで作成したMapの格納用変数
	public Map<Integer,String>CategoryMap;
	
	//④確認画面　MapからValueを取得するGetter
	public String shopConf;
	public String categoryConf;
	public String cardConf;
	
	//⑤カード情報関係
	public Map<Integer,String> CardMap;
	public Integer backMoney;
	public Integer backNumber;
	private Integer pointSet;
	
	//一覧表示検索条件
	public String searchDate;
	public String searchShop;
	public List<SyushiInfo> searchTenpoList;
	public List<SyushiInfo> searchResultList;
	public List<SyushiInfo> searchDateList;
	

	//一覧表示紐づけ用
	public Map<Integer,String> SearchCardMap;
	public String SearchCardGetter;
	public Map<Integer,String> SearchShopMap;
	public String SearchShopGetter;
	public Map<Integer,String> SearchCategoryMap;
	public String SearchCategoryGetter;




	//①
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
	
	
	
	//②
	public List<SyushiInfo> getTenpoList() {
		return TenpoList;
	}
	
	public void setTenpoList(List<SyushiInfo> tenpoList) {
		TenpoList = tenpoList;
	}
	
	public Map<Integer, String> getTenpoMap() {
		return TenpoMap;
	}

	public void setTenpoMap(Map<Integer, String> tenpoMap) {
		TenpoMap = tenpoMap;
	}
	
	//③
	public Map<Integer,String> getCategoryMap() {

		Map<Integer,String> categoryMap = new HashMap<Integer,String>();
		categoryMap.put(1, "食料品");
		categoryMap.put(2, "日用品");
		categoryMap.put(3, "嗜好品");
		categoryMap.put(4, "薬、医療費");
		categoryMap.put(5, "衣類");
		categoryMap.put(6, "電化製品");
		categoryMap.put(7, "娯楽・外食");
		categoryMap.put(8, "ガス・ガソリン");
		categoryMap.put(9, "交通費");
		categoryMap.put(10, "理美容費");
		categoryMap.put(11, "その他");

		this.CategoryMap=categoryMap;
		return categoryMap;
	}
	
	//セレクトボックス用ゲッター
	public List<Integer> getBYearList() {
		List<Integer> bYearList = new ArrayList<Integer>();
	Calendar cal = Calendar.getInstance();
	int year1=cal.get(Calendar.YEAR);
	int year2=year1 - 10 ;
	
	for(int p = year2 ;p <= year1 ;p++) {
		bYearList.add(p);
	}
		return bYearList;
	}
	
	//セレクトボックス用ゲッター
	public List<Integer> getBMonthList() {
		List<Integer> bMonthList = new ArrayList<Integer>();

		for(int p=1; p<=12;p++) {
			bMonthList.add(p);
		}
		return bMonthList;
	}
	
	//セレクトボックス用ゲッター
	public List<Integer> getBDayList() {
		List<Integer> bDayList = new ArrayList<Integer>();

		for(int p=1; p<=31;p++) {
			bDayList.add(p);
		}
		return bDayList;
	}
	
	//セレクトボックス用ゲッター
	public List<String> getCardList() {
		List<String> cardList = new ArrayList<String>();

		for(int p=1; p<=5;p++) {
			cardList.add("利用カードTEST" + String.valueOf(p));
		}
		return cardList;
	}

	//④
	public String getShopConf() {
		if(shop!=null) {
			shopConf=TenpoMap.get(shop);
		}
		return shopConf;
	}
	
	public String getCategoryConf() {
		if(category!=null) {
			categoryConf = CategoryMap.get(category);
		}
		return categoryConf;
	}
	
	public String getCardConf() {
		if(usePointCard!=null) {
			cardConf = CardMap.get(usePointCard);
		}
		return cardConf;
	}
	
	//⑤
	public Map<Integer, String> getCardMap() {
		return CardMap;
	}
	public void setCardMap(Map<Integer, String> cardMap) {
		CardMap = cardMap;
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
	public Integer getPointSet() {
		return pointSet;
	}
	public void setPointSet(Integer pointSet) {
		this.pointSet = pointSet;
	}
	
	//検索条件

	public String getSearchShop() {
		return searchShop;
	}
	public String getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	public void setSearchShop(String searchShop) {
		this.searchShop = searchShop;
	}
	
	public List<SyushiInfo> getSearchTenpoList() {
		return searchTenpoList;
	}
	public void setSearchTenpoList(List<SyushiInfo> searchTenpoList) {
		this.searchTenpoList = searchTenpoList;
	}
	public List<SyushiInfo> getSearchResultList() {
		return searchResultList;
	}
	public void setSearchResultList(List<SyushiInfo> searchResultList) {
		this.searchResultList = searchResultList;
	}
	public List<SyushiInfo> getSearchDateList() {
		return searchDateList;
	}
	public void setSearchDateList(List<SyushiInfo> searchDateList) {
		this.searchDateList = searchDateList;
	}
	
	//一覧表示紐づけ用
	public Map<Integer, String> getSearchCardMap() {
		return SearchCardMap;
	}
	public void setSearchCardMap(Map<Integer, String> searchCardMap) {
		SearchCardMap = searchCardMap;
	}

	
	public Map<Integer, String> getSearchShopMap() {
		return SearchShopMap;
	}
	public void setSearchShopMap(Map<Integer, String> searchShopMap) {
		SearchShopMap = searchShopMap;
	}

	
	public Map<Integer, String> getSearchCategoryMap() {

		return SearchCategoryMap;
	}
	
	public void setSearchCategoryMap(Map<Integer, String> searchCategoryMap) {
		SearchCategoryMap = searchCategoryMap;
	}
	public String getSearchCardGetter() {

		return SearchCardGetter;
	}
	public void setSearchCardGetter(String searchCardGetter) {
		SearchCardGetter = searchCardGetter;
	}
	public String getSearchShopGetter() {

		return SearchShopGetter;
	}
	public void setSearchShopGetter(String searchShopGetter) {
		SearchShopGetter = searchShopGetter;
	}
	public String getSearchCategoryGetter() {

		return SearchCategoryGetter;
	}
	public void setSearchCategoryGetter(String searchCategoryGetter) {
		SearchCategoryGetter = searchCategoryGetter;
	}


	
	


	
	
	
}
