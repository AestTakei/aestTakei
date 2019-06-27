package com.example.web.syushi;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

//import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.SyushiInfo;
import com.example.service.SyushiRegService;
import com.example.web.syushi.SyushiForm;


@Controller
@SessionAttributes("SyushiForm")

public class mogiPjtController {
	
    @Autowired		//SyushiRegServiceを使用できるようにする。
    private SyushiRegService service;
	
	   @ModelAttribute(value = "SyushiForm")
	    public SyushiForm setForm() {
	        return new SyushiForm();
	    }

	   //リクエスト時
	    @RequestMapping(value = "/start-menu")
	    public String startMenu() {
	        return "mogiPJT/start_Menu";
	    }
	    
	    //スタートメニューから収支情報登録・照会ボタン押下時
	    @RequestMapping(value = "/syushi-menu",params ="goSyushiMenu_btn")
	    public String syushiMenu() {
	        return "mogiPJT/syushi_Menu";
	    }
	    
	    //スタートメニューから店舗情報登録・照会ボタン押下時
	    @RequestMapping(value = "/syushi-menu",params ="goShopMenu_btn")
	    public String shopMenu() {
	        return "mogiPJT/start_Menu";
	    }
	    
	    //スタートメニューからポイントカード情報登録・照会ボタン押下時
	    @RequestMapping(value = "/syushi-menu",params ="goCardMenu_btn")
	    public String cardMenu() {
	        return "mogiPJT/start_Menu";
	    }
	    
	    //収支情報メニューから収支情報を登録するボタン押下時
	    @RequestMapping(value = {"/syushi-menuNext", "/syushi-endNext"},params = "goSyushiReg_btn")
	    public String syushiRegInput(@ModelAttribute("SyushiForm") SyushiForm form) {
	    	SyushiInfo syushiinfo = new SyushiInfo();
	    	BeanUtils.copyProperties(form, syushiinfo);
	    	
	    	List<SyushiInfo> list = service.SyushiReg_getShop(syushiinfo);
	    	if(list.size() !=0) {
	    		Map<Integer, String> map = new HashMap<Integer, String>();
	    		for(SyushiInfo item : list) {
	    			map.put(item.getShopId(), item.getShopName());
	    		}
	    		form.setTenpoMap(map);
	    		form.setTenpoList(list);
	    	}
	    	
	    	List<SyushiInfo> list2 = service.SyushiReg_getCard(syushiinfo);
	    	if(list2.size() !=0) {
	    		Map<Integer, String> map2 = new HashMap<Integer, String>();
	    		for(SyushiInfo item : list2) {
	    			map2.put(item.getCardId(), item.getUseCard());
	    		}
	    		form.setCardMap(map2);
	    	}
	    	
	    	
	    	
	        return "mogiPJT/syushi_Reg_Input";
	    }
	    
	    //収支情報メニューから戻るボタン押下時
	    @RequestMapping(value = "/syushi-menuNext",params ="backStartMenu_btn")
	    public String backStartMenu() {
	        return "mogiPJT/start_Menu";
	    }
	    
	    //収支情報登録画面から確認ボタン押下時
	    @RequestMapping(value = "/syushi-conf",params ="goSyushiConf_btn")
	    public String syushiRegConf(@ModelAttribute("SyushiForm") SyushiForm form) {
	        return "mogiPJT/syushi_Reg_Conf";
	    }
	    
	    //収支情報登録画面から獲得ポイント算出ボタン押下時
	    @RequestMapping(value = "/syushi-conf",params ="getPoint_btn")
	    public String syushiRegPoint(@ModelAttribute("SyushiForm") SyushiForm form) {
	    	SyushiInfo syushiinfo = new SyushiInfo();
	    	BeanUtils.copyProperties(form, syushiinfo);
	    	
	    	List<SyushiInfo> list3 = service.SyushiReg_getBack(syushiinfo);
	    	if(list3.size() !=0) {
	    		for(SyushiInfo item : list3) {
	    			form.setPointSet(form.getPrice()/item.getBackMoney()*item.getBackNumber());
	    		}
	    	}
	    	
	        return "mogiPJT/syushi_Reg_Input";
	    }
	    
	    //収支情報登録画面から戻るボタン押下時	    
	    @RequestMapping(value = "/syushi-conf",params ="backSyushiMenu_btn")
	    public String backSyushiMenu() {
	        return "mogiPJT/syushi_Menu";
	    }
	    
	    
	    //登録情報確認画面から登録ボタン押下時
	    @RequestMapping(value = "/syushi-end",params ="goSyushiEnd_btn")
	    public String syushiRegEnd(@ModelAttribute("SyushiForm") SyushiForm form) {
	    	SyushiInfo syushiinfo = new SyushiInfo();
	    	BeanUtils.copyProperties(form, syushiinfo);
	    	service.SyushiReg_insert(syushiinfo);
	    	service.upd_point(syushiinfo);
	    	
	        return "redirect:/syushi-end?finish";
	    }
	    
	    //登録ボタン押下時の処理からリダイレクト
	    @RequestMapping(value = "/syushi-end",params ="finish")
	    public String syushiRegEndFinish(SessionStatus sessionStatus) {
	        // @SessionAttributesで指定したオブジェクトをセッションから破棄
	        sessionStatus.setComplete();
	        return "mogiPJT/syushi_Reg_end";
	    }
	    
	    //収支情報確認画面から戻るボタン押下時	    
	    @RequestMapping(value = "/syushi-end",params ="backSyushiInput_btn")
	    public String backSyushiInput(@ModelAttribute("SyushiForm") SyushiForm form) {
	        return "mogiPJT/syushi_Reg_Input";
	    }
	    
	    
	    //収支情報メニューから収支情報を確認するボタン押下時
	    @RequestMapping(value = {"/syushi-menuNext","/search_result_back"},params = "goSyushiShow_btn")
	    public String syushiShow(@ModelAttribute("SyushiForm") SyushiForm form) {
	    	SyushiInfo syushiinfo = new SyushiInfo();
	    	BeanUtils.copyProperties(form, syushiinfo);
	    	List<SyushiInfo> list4 = service.SyushiReg_getShop(syushiinfo);
	    	
	    	if(list4.size() !=0) {
	    		Map<Integer, String> map3 = new HashMap<Integer, String>();
	    		for(SyushiInfo item : list4) {
	    			map3.put(item.getShopId(), item.getShopName());
	    		}
	    		form.setSearchShopMap(map3);
	    		form.setSearchTenpoList(list4);
	    	}

	    	List<SyushiInfo> list6 = service.SyushiGetDate(syushiinfo);
	    	if(list6.size() !=0) {
	    		form.setSearchDateList(list6);
	    	}
	    	
	    	List<SyushiInfo> list7 = service.SyushiShow_getCard(syushiinfo);
	    	if(list7.size() !=0) {
	    		Map<Integer, String> map4 = new HashMap<Integer, String>();
	    		for(SyushiInfo item : list7) {
	    			map4.put(item.getCardId(), item.getUseCard());
	    		}
	    		form.setSearchCardMap(map4);
	    	}
	    	
			Map<Integer,String> sCategoryMap = new HashMap<Integer,String>();
			sCategoryMap.put(1, "食料品");
			sCategoryMap.put(2, "日用品");
			sCategoryMap.put(3, "嗜好品");
			sCategoryMap.put(4, "薬、医療費");
			sCategoryMap.put(5, "衣類");
			sCategoryMap.put(6, "電化製品");
			sCategoryMap.put(7, "娯楽・外食");
			sCategoryMap.put(8, "ガス・ガソリン");
			sCategoryMap.put(9, "交通費");
			sCategoryMap.put(10, "理美容費");
			sCategoryMap.put(11, "その他");
			form.setSearchCategoryMap(sCategoryMap);

	    	return "mogiPJT/syushi_search_Input";
	    }
	    
	    //収支情報照会画面から一覧表示ボタン押下時
	    @RequestMapping(value = {"/search-result"},params = "serch_goResult_btn")
	    public String syushiShowResult(@ModelAttribute("SyushiForm") SyushiForm form ) {
	    	SyushiInfo syushiinfo = new SyushiInfo();
	    	BeanUtils.copyProperties(form, syushiinfo);
	    	List<SyushiInfo> list5 = service.SyushiSearch(syushiinfo);

	    	if(list5.size() !=0) {
	    	
	    	for (SyushiInfo sy : list5) {
	    		String shopName = form.getSearchShopMap().get(sy.getShopId());
	    		sy.setShopName(shopName);
	    	}
	    	
	    	for (SyushiInfo sy : list5) {
	    		String useCard = form.getSearchCardMap().get(sy.getCardId());
	    		sy.setUseCard(useCard);
	    	}
	    	
	    	for (SyushiInfo sy : list5) {
	    		String sCate = form.getSearchCategoryMap().get(sy.getCategory());
	    		sy.setsCate(sCate);
	    	}

	    			form.setSearchResultList(list5);
	    		}
	    	
	    	return "redirect:/search-result?finish";
	    }
	    //リダイレクト
	    @RequestMapping(value = {"/search-result"},params = "finish")
	    public String syushiResult(SessionStatus sessionStatus) {
	        sessionStatus.setComplete();
	    	
	    	return "mogiPJT/syushi_search_Result";
	    }
	    
	    //収支情報照会画面から戻る押下時
	    @RequestMapping(value = {"/search-result"},params = "search_backMenu_btn")
	    public String syushiShowBack() {
	    	
	    	return "mogiPJT/syushi_Menu";
	    }
	    

	    

	    
	    
}
