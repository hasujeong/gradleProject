package com.diquest.ir.rest.extension;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.diquest.ir.common.database.entity.feedback.FeedbackLog;
import com.diquest.ir.common.exception.IRException;
import com.diquest.ir.common.msg.protocol.Protocol;
import com.diquest.ir.common.msg.protocol.query.FilterSet;
import com.diquest.ir.common.msg.protocol.query.GroupBySet;
import com.diquest.ir.common.msg.protocol.query.OrderBySet;
import com.diquest.ir.common.msg.protocol.query.Query;
import com.diquest.ir.common.msg.protocol.query.QueryParser;
import com.diquest.ir.common.msg.protocol.query.QuerySet;
import com.diquest.ir.common.msg.protocol.query.SelectSet;
import com.diquest.ir.common.msg.protocol.query.WhereSet;
import com.diquest.ir.common.msg.protocol.repository.CFRecommendReq;
import com.diquest.ir.rest.common.object.RestHttpRequest;
import com.diquest.ir.rest.extension.common.Collections;
import com.diquest.ir.rest.extension.common.CommonUtil;
import com.diquest.ir.rest.extension.vo.SearchVo;

public class shopSearch implements QuerySetExtension {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("QueryExtension init");
		
	}

	@Override
	public QuerySet makeQuerySet(RestHttpRequest request) {

		SearchVo searchVo	= new SearchVo(request.getParams());
		
		if (request.getParams().size() == 1) {
			String test	= request.getRequestBody();
			try {
				test = URLDecoder.decode(test, "utf-8");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Map<String, String> paramMap = request.getParams();
			
			String[] params = test.split("&");
	        for (String param : params) {
	        	if (param.split("=").length == 2) {
	        		String name = param.split("=")[0];
		            String value = param.split("=")[1];
		            paramMap.put(name, value);
	        	}
	        }
			
			searchVo = new SearchVo(paramMap);
		}
		
		QuerySet querySet = new QuerySet(1);
		
		QueryParser parser = new QueryParser();
		
		char[] startTag = "<b>".toCharArray(); // Highlight tag �꽕�젙 startTag
		char[] endTag = "</b>".toCharArray(); // Highlight tag �꽕�젙 endTag
		
		Query query = new Query(startTag, endTag);
		
		SelectSet[] selectSets 		= CommonUtil.getSelectSet(Collections.PRODUCT);
//		WhereSet[] whereSets 		= CommonUtil.getWhereSet(searchVo, Collections.PRODUCT);		// 寃��깋議곌굔     
//    	OrderBySet[] orderBySets 	= CommonUtil.getOrderBySet(searchVo, Collections.PRODUCT);	// �젙�젹議곌굔      
//    	GroupBySet[] groupBySets	= CommonUtil.getGroupbySet(searchVo, Collections.PRODUCT);	// 洹몃９�꽕�젙
//    	FilterSet[] filterSets		= CommonUtil.getFilterSet(searchVo);						// �븘�꽣議곌굔 ( >> 媛�寃� 踰붿쐞 寃��깋 ) 
    			
		query.setSelect(selectSets);
//		if(whereSets != null) {
//			query.setWhere(whereSets);
//		}
//		query.setOrderby(orderBySets);
//		query.setGroupBy(groupBySets);	
//		if(filterSets != null) {
//			query.setFilter(filterSets); 
//		}
		
		/*FeedbackLog feedbackLog = new FeedbackLog(Collections.PRODUCT, searchVo.getSearchTerm(), "332006004420");
		try {
			CommandFeedbackLog.request("127.0.0.1", 5555, feedbackLog);
		} catch (IRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    	query.setFrom(Collections.PRODUCT);
    	query.setResult(searchVo.getStart(), searchVo.getEnd());
    	
    	/* 寃��깋濡쒓렇 愿��젴 start */
    	// 寃��깋 濡쒓렇�쓽 寃쎌슦 �쁽�옱 �긽�뭹�뿉 ���븳 濡쒓렇留� �닔吏묓븯�뿬 �옄�룞�셿�꽦寃��깋�뿉�꽌 �궗�슜 
    	// (�븘�옒�쓽 �꽕�젙�뿉�꽌 �뙎�씤 �뜲�씠�꽣濡� �옄�룞�셿�꽦 寃��깋 �궗�슜) 
    	if(searchVo.getLogKeyword() != null && !searchVo.getLogKeyword().equals("")) {
	    	query.setLoggable(true);	// 寃��깋 濡쒓렇 異붽� �뿬遺� 
	    	query.setLogKeyword(searchVo.getLogKeyword().toCharArray());	// 寃��깋 濡쒓렇�뿉 ���옣�맆 �궎�썙�뱶 
    	}
    	/* 寃��깋濡쒓렇 愿��젴 end */
    	
		query.setDebug(true);
		query.setFaultless(true);
		query.setPrintQuery(true);			// �떎�젣 諛섏쁺�떆 �젣嫄�
//    	
//		query.setSearchOption((byte)(Protocol.SearchOption.CACHE | Protocol.SearchOption.BANNED | Protocol.SearchOption.STOPWORD));	// 寃��깋 罹먯떆, 湲덉��뼱, 遺덉슜�뼱 �궗�쟾 �궗�슜 �꽕�젙 
// 		query.setThesaurusOption((byte)(Protocol.ThesaurusOption.QUASI_SYNONYM | Protocol.ThesaurusOption.EQUIV_SYNONYM));			// �룞�쓽�뼱, �쑀�쓽�뼱 �궗�쟾 �궗�슜 �꽕�젙 
// 		query.setRankingOption((byte) (Protocol.RankingOption.CATEGORY_RANKING | Protocol.RankingOption.DOCUMENT_RANKING));			// 移댄뀒怨좊━ �옲�궧, 臾몄꽌�옲�궧 �궗�슜 �꽕�젙
// 		query.setCategoryRankingOption((byte)(Protocol.CategoryRankingOption.MULTI_TERM_KOREAN | Protocol.CategoryRankingOption.QUASI_SYNONYM | Protocol.CategoryRankingOption.EQUIV_SYNONYM));
// 		// 移댄뀒怨좊━ �옲�궧 �떆 �궎�썙�뱶 �븳援��뼱 �삎�깭�냼濡� 遺꾩꽍�븯�뿬 �궗�슜�븯寃좊떎�뒗 異붽� �꽕�젙 (korean)
 		
//		String queryStr = parser.queryToString(query);
		
		querySet.addQuery(query);
		
		return querySet;
	}

}
