package com.diquest.ir.rest.extension.common;

import java.util.ArrayList;
import java.util.HashMap;

import com.diquest.ir.common.exception.IRException;
import com.diquest.ir.common.msg.protocol.Protocol;
import com.diquest.ir.common.msg.protocol.query.FilterSet;
import com.diquest.ir.common.msg.protocol.query.GroupBySet;
import com.diquest.ir.common.msg.protocol.query.OrderBySet;
import com.diquest.ir.common.msg.protocol.query.Query;
import com.diquest.ir.common.msg.protocol.query.QuerySet;
import com.diquest.ir.common.msg.protocol.query.SelectSet;
import com.diquest.ir.common.msg.protocol.query.WhereSet;
import com.diquest.ir.common.msg.protocol.result.Result;
import com.diquest.ir.common.msg.protocol.result.ResultSet;
import com.diquest.ir.rest.extension.common.Collections;
import com.diquest.ir.rest.extension.vo.SearchVo;

public class CommonUtil {

	public static SelectSet[] getSelectSet(String collection) {
    	
    	/* 통합검색 노출필드 start */    	
    	SelectSet[] selectSets = new SelectSet[]{
    			new SelectSet("NAME", Protocol.SelectSet.NONE)    			
		};
    	/* 통합검색 노출필드 end */

    	return selectSets;
    	
    }

	/**
	 * 영문만인 경우 true, 영문외 다른 문자가 있는 경우 false
	 * @param searchQuery
	 * @return
	 */	
	public static boolean setKeywordCheck(String searchQuery){
		int ck = 0;
		int e_cnt=0;
		char[] charkeyword=searchQuery.toCharArray();
		for(int i=0; i < charkeyword.length; i++){
			ck = (int)charkeyword[i];

			if((ck >=65 && ck <= 90)||(ck >=97 && ck <= 122)) e_cnt++;
		}
		if(charkeyword.length == e_cnt) return true;
		else return false;
	}

	/**
	 * 자음 +모음을 포함하고 있으면 log false
	 * @param searchQuery
	 * @return
	 */
	public static boolean setHanKeyCheck(String searchQuery){
		boolean keyBoolean = false;

		char[] charkeyword=searchQuery.toCharArray();
		for(int i=0; i < charkeyword.length;i++){
			int ck = (int)charkeyword[i];
			if((ck >= 12593 && ck <=12622) || (ck>=12623 && ck <=12643)){  
				keyBoolean = true;
			}
		}
		return keyBoolean;
	}
	
}
