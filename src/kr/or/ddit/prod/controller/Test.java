package kr.or.ddit.prod.controller;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;

public class Test {

	public static void main(String[] args) {
		IProdService ss = ProdServiceImpl.getInstance();
		System.out.println(ss.selectProd("P201000003").getProd_id());
	}

}
