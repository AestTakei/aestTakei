package com.example.persistence;

import java.util.List;

import com.example.domain.SyushiInfo;

public interface SyushiRegMapper {
	
	public void insert(SyushiInfo syushiinfo) ;
	
	public List<SyushiInfo> getshop(SyushiInfo syushiinfo) ;

	public List<SyushiInfo> getcard(SyushiInfo syushiinfo) ;
	
	public List<SyushiInfo> getback(SyushiInfo syushiinfo) ;
	
	public void updPoint(SyushiInfo syushiinfo) ;
	
	public List<SyushiInfo> syushisearch(SyushiInfo syushiinfo) ;

	public List<SyushiInfo> syushigetdate(SyushiInfo syushiinfo) ;
	
	public List<SyushiInfo> syushigetcard(SyushiInfo syushiinfo) ;
	

}
