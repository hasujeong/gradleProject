package com.diquest.ir.rest.extension.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import com.diquest.ir.rest.extension.common.CommonUtil;
import com.diquest.ir.rest.extension.common.Pages;

public class SearchVo {
	
	private String searchTerm; 		// 검색어
	private String sort;			// 정렬
	private String currentPage	= Pages.CURRENT_PAGE;	// 현재페이지 ( 기본 1 ) 
	private String rowsperPage	= Pages.ROWS;			// 페이지당 출력 건수 ( 기본 10 )
	private String minPrice;
	private String maxPrice;
	private String sortOption;
	
	private String cateLGrp;
	private String cateMGrp;
	private String cateSGrp;
	private String LcateIdx;
	
	private String kindCd;
	private String prodCd;
	private String sale;
	private String dlvMtd;
	private String consulType;
	private String clickId;
	private String flag;
	private String prodGroup;
	
	private String brand;
	private String color;
	private String prodType;
	private String partner;
	private String statusCd;
	private String flagOpen;
	private String flagMobileOpen;
	private String flagAppOpen;
	private String flagIsMobile;
	private String memberNo;
	private String language;
		
	// 페이지 관련 
	private int start;
	private int end;
	
	// 로그 남길 키워드 
	private String logKeyword;
	
	public String[] getSearchTerms() {
		return searchTerm.split(Pages.DEL);
	}
	public String getSort() {
		return sort;
	}
	
	public String getSortOption() {
		return sortOption;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public String getRowsperPage() {
		return rowsperPage;
	}
		
	public String getSearchTerm() {
		return searchTerm;
	}
	
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	public void setLogKeyword(String logKeyword) {
		this.logKeyword = logKeyword;
	}
	
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public String getLogKeyword() {
		return logKeyword;
	}
	
	public String getKindcd() {
		return kindCd;
	}
		
	public String getProdcd() {
		return prodCd;
	}
	public String getSale() {
		return sale;
	}
	public String getDlvMtd() {
		return dlvMtd;
	}
	public String getConsulType() {
		return consulType;
	}
	public String getClickId() {
		return clickId;
	}
	public String getFlag() {
		return flag;
	}
	
	public String getKindCd() {
		return kindCd;
	}
	public String getBrand() {
		return brand;
	}
	public String getColor() {
		return color;
	}
	public String getProdType() {
		return prodType;
	}
	public String getPartner() {
		return partner;
	}
	
	public String getProdGroup() {
		return prodGroup;
	}
	public String getStatusCd() {
		return statusCd;
	}
	public String getFlagOpen() {
		return flagOpen;
	}
	public String getFlagMobileOpen() {
		return flagMobileOpen;
	}
	public String getFlagAppOpen() {
		return flagAppOpen;
	}
	public String getFlagIsMobile() {
		return flagIsMobile;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public String getLanguage() {
		return language;
	}
	public String getCateLGrp() {
		return cateLGrp;
	}
	public String getCateMGrp() {
		return cateMGrp;
	}
	
	public String getCateSGrp() {
		return cateSGrp;
	}
	public String getLcateIdx() {
		return LcateIdx;
	}
	public SearchVo() {
	}
	public SearchVo(Map<String,String> params) {
		this.searchTerm = (params.get("searchTerm") == null ? "" : params.get("searchTerm"));		// 검색어 
		this.sort = (params.get("sort") == null ? "" : params.get("sort"));					// 정렬
		this.minPrice = (params.get("minPrice") == null ? "" : params.get("minPrice"));
		this.maxPrice = (params.get("maxPrice") == null ? "" : params.get("maxPrice"));
		this.sortOption = (params.get("sortOption") == null ? "" : params.get("sortOption"));
		
		this.kindCd = (params.get("kindCd") == null ? "" : params.get("kindCd"));					// 상품종류
		this.prodCd = (params.get("prodCd") == null ? "" : params.get("prodCd"));
		this.sale = (params.get("sale") == null ? "" : params.get("sale"));
		this.dlvMtd = (params.get("dlvMtd") == null ? "" : params.get("dlvMtd"));
		this.consulType = (params.get("consulType") == null ? "" : params.get("consulType"));
		this.clickId = (params.get("clickId") == null ? "" : params.get("clickId"));
		this.flag = (params.get("flag") == null ? "" : params.get("flag"));
		this.brand = (params.get("brand") == null ? "" : params.get("brand"));
		this.color = (params.get("color") == null ? "" : params.get("color"));
		this.prodType = (params.get("prodType") == null ? "" : params.get("prodType"));
		this.partner = (params.get("partner") == null ? "" : params.get("partner"));
		this.statusCd = (params.get("statusCd") == null ? "" : params.get("statusCd"));
		this.flagOpen = (params.get("flagOpen") == null ? "" : params.get("flagOpen"));
		this.flagMobileOpen = (params.get("flagMobileOpen") == null ? "" : params.get("flagMobileOpen"));
		this.flagAppOpen = (params.get("flagAppOpen") == null ? "" : params.get("flagAppOpen"));
		this.flagIsMobile = (params.get("flagIsMobile") == null ? "" : params.get("flagIsMobile"));
		this.prodGroup = (params.get("prodGroup") == null ? "" : params.get("prodGroup"));
		this.memberNo = (params.get("memberNo") == null ? "" : params.get("memberNo"));
		this.language = (params.get("language") == null ? "" : params.get("language"));
		
		this.cateLGrp = (params.get("cateLGrp") == null ? "" : params.get("cateLGrp"));
		this.cateMGrp = (params.get("cateMGrp") == null ? "" : params.get("cateMGrp"));
		this.cateSGrp = (params.get("cateSGrp") == null ? "" : params.get("cateSGrp"));
		this.LcateIdx = (params.get("LcateIdx") == null ? "" : params.get("LcateIdx"));
		
		if(params.get("currentPage") != null && !params.get("currentPage").equals("") && !params.get("currentPage").equals("0")) {
			this.currentPage = params.get("currentPage");
		}
		if(params.get("rowsperPage") != null && !params.get("rowsperPage").equals("") && !params.get("rowsperPage").equals("0")) {
			this.rowsperPage = params.get("rowsperPage");
		}
		this.start 	= 0;
		this.end	= 9;
		
		if(!searchTerm.equals("")) {
			this.logKeyword = getSearchTerms()[0];
		}
	}
}
