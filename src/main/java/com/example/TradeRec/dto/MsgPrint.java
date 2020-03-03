package com.example.TradeRec.dto;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MsgPrint {

	public void getMsg(Exchange exchange) {
		ProducerTemplate template = exchange.getContext().createProducerTemplate();
		template.sendBody("azure-queue://127.0.0.1:10001/devstoreaccount1/productdetails", "Sent Message");
		log.info("Into Msg bean");
	}
}
