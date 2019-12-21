package com.example.demo.controller;

import com.example.demo.dlx.dlxSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.direct.DirectSender;
import com.example.demo.direct.DirectSender2;
import com.example.demo.fanout.FanoutSender;
import com.example.demo.handler.Sender;
import com.example.demo.topic.TopicSender;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {

	@Autowired
	private Sender sender;
	
	@Autowired
	private DirectSender dsender;
	@Autowired
	private DirectSender2 dsender2;
	@Autowired
	private TopicSender tsender;
	@Autowired
	private  FanoutSender fsender;

	@Autowired
	private dlxSend dlxSend;
	@ResponseBody
	@GetMapping(path="/send")
	public int senderMsg() {
		dsender.sendDirect();
		dsender2.sendDirect();
		return 0;
	}
	@GetMapping(path="/sendTopic")
	@ResponseBody
	public int sendTopic() {

		tsender.send();
		return 0;
	}
	@ResponseBody
	@GetMapping(path="/sendfanout")
	public int sendfanout() {
		fsender.send();
		return 0 ;
	}

	@ResponseBody
	@GetMapping(path = "/senddlx")
	public int senddlx(){
		dlxSend.sendDlx();
		return 0;
	}

}
