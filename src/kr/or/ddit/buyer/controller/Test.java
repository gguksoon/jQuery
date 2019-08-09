package kr.or.ddit.buyer.controller;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;

public class Test {

	public static void main(String[] args) {
		IBuyerService ss = BuyerServiceImpl.getInstance();
		System.out.println(ss.selectAll().size());
	}

}
