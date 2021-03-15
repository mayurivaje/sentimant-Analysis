package com.mayuri.demo.moneycontrol.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayuri.demo.moneycontrol.model.MoneyControlModel;
import com.mayuri.demo.moneycontrol.model.ResponseModel;
import com.mayuri.demo.moneycontrol.service.MoneyControlService;
import com.mayuri.moneycontrol.constant.MessageConstant;

@RestController
public class MoneyController {

	@Autowired
	MoneyControlService moneyControlService;

	@RequestMapping(value = "get/messages", method = RequestMethod.GET)
	public ResponseEntity<ResponseModel> getMessages(@RequestParam String nickname) {

		ResponseModel responseModel = new ResponseModel();
		List<MoneyControlModel> list = moneyControlService.getMessages(nickname);
		Map<String, Object> map = new HashMap<>();
		if(list.size() > 0) {
			responseModel.setResponseStatus(MessageConstant.SUCCESS_STATUS);
			map.put("moneyControlList", list);
			responseModel.setData(map);
		}else {
			responseModel.setResponseStatus(MessageConstant.FAILED_STATUS);
			responseModel.setData(new HashMap<>());
		}
		return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.OK); // sending ok to the response
	}

	@RequestMapping(value = "delete/messages", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseModel> deleteMessages(@RequestParam Long id) {

		ResponseModel responseModel = new ResponseModel();
		moneyControlService.deleteMessage(id);
		responseModel.setResponseStatus(MessageConstant.SUCCESS_STATUS);
		return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.OK);
	}

	@RequestMapping(value = "insert/messages", method = RequestMethod.POST)
	public ResponseEntity<ResponseModel> insertMessages() throws IOException {

		ResponseModel responseModel = new ResponseModel();						// to send the response to the client
		MoneyControlModel moneyControl = moneyControlService.saveMessages();
		if(moneyControl != null) {
			responseModel.setResponseStatus(MessageConstant.SUCCESS_STATUS);
		}else {
			responseModel.setResponseStatus(MessageConstant.FAILED_STATUS);
		}

		return new ResponseEntity<ResponseModel>(responseModel,HttpStatus.OK);
	}
}
