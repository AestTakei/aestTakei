package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.persistence.SyushiRegMapper;
import com.example.domain.SyushiInfo;

@Service
public class SyushiRegService {
	
@Autowired	//SyushiRegMapperインタフェースを使用出来るようにする(DB登録の仲介)
private SyushiRegMapper mapper;

@Transactional
public void SyushiReg_insert(SyushiInfo syushiinfo) {
	mapper.insert(syushiinfo);
}

public void upd_point(SyushiInfo syushiinfo) {
	mapper.updPoint(syushiinfo);
}

public List<SyushiInfo> SyushiReg_getShop(SyushiInfo syushiinfo) {
	List<SyushiInfo> list = mapper.getshop(syushiinfo);
	return list;
}

public List<SyushiInfo> SyushiReg_getCard(SyushiInfo syushiinfo) {
	List<SyushiInfo> list2 = mapper.getcard(syushiinfo);
	return list2;
}

public List<SyushiInfo> SyushiReg_getBack(SyushiInfo syushiinfo) {
	List<SyushiInfo> list3 = mapper.getback(syushiinfo);
	return list3;
}

public List<SyushiInfo> SyushiSearch(SyushiInfo syushiinfo) {
	List<SyushiInfo> list4 = mapper.syushisearch(syushiinfo);
	return list4;
}

public List<SyushiInfo> SyushiGetDate(SyushiInfo syushiinfo) {
	List<SyushiInfo> list5 = mapper.syushigetdate(syushiinfo);
	return list5;
}


public List<SyushiInfo> SyushiShow_getCard(SyushiInfo syushiinfo) {
	List<SyushiInfo> list6 = mapper.syushigetcard(syushiinfo);
	return list6;
}


}
