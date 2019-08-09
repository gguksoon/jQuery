<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
	<%
		List<BuyerVO> buyerList = (List<BuyerVO>)request.getAttribute("buyerList");
		for(int i = 0; i < buyerList.size(); i++) {
			BuyerVO buyer = buyerList.get(i);
			if(i > 0) out.print(", ");
	%>
			{
				"buyer_id" : "<%= buyer.getBuyer_id() %>",
				"buyer_name" : "<%= buyer.getBuyer_name() %>",
				"buyer_lgu" : "<%= buyer.getBuyer_lgu() %>",
				"buyer_bank" : "<%= buyer.getBuyer_bank() %>",
				"buyer_bankno" : "<%= buyer.getBuyer_bankno() %>",
				"buyer_bankname" : "<%= buyer.getBuyer_bankname() %>",
				"buyer_zip" : "<%= buyer.getBuyer_zip() %>",
				"buyer_addr" : "<%= buyer.getBuyer_add1() + " " + buyer.getBuyer_add2() %>",
				"buyer_comtel" : "<%= buyer.getBuyer_comtel() %>",
				"buyer_fax" : "<%= buyer.getBuyer_fax() %>",
				"buyer_mail" : "<%= buyer.getBuyer_mail() %>",
				"buyer_charger" : "<%= buyer.getBuyer_charger() %>",
				"buyer_telext" : "<%= buyer.getBuyer_telext() %>"
			}
	<%	
		} 
	%>
]