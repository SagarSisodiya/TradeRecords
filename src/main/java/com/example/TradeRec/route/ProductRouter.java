package com.example.TradeRec.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

import com.example.TradeRec.dto.MsgPrint;

@Service
public class ProductRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {	
		//from("direct:start")
		//.to("azure-queue:/devstoreaccount1/productdetails");
	}

}
