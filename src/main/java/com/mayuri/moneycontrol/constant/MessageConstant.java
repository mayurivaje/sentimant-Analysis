package com.mayuri.moneycontrol.constant;

import java.util.ArrayList;
import java.util.List;

public class MessageConstant {
	
	
public static final String FORUM_URL = "https://mmb.moneycontrol.com/index.php?q=boarder/ajax_call&section=get_messages&is_boarder_page=1&offset=&lmid=&isp=0&gmt=my_post&uid=#userName&pgno=";

public static final List<String> USER_NAME = new ArrayList(){ {
	add("valine");
	add("neha0103");
	add("arvind151");
	add("aswathiguna11");
	add("announcer_2012");
	add("ANAND24243");
	add("anibillion");
	add("flashstock05");
		/*
		 * add("uuuthh"); add("bablulab"); add("amateurinvestor"); add("rdd99");
		 * add("rajendra421"); add("blogist"); add("srisat19");
		 */
}};

public static final List<String> POSITIVE_WORDS = new ArrayList() {{
	add("buy");
	add("higher");
	add("strong");
	add("high");
	add("above");
	add("bullish");
	add("good");
	add("up");
	
}};

public static final List<String> NEGATIVE_WORDS = new ArrayList() {{
	add("sell");
	add("lower");
	add("weak");
	add("low");
	add("below");
	add("bearish");
	add("bad");
	add("down");
	
}};


public static final String SUCCESS_STATUS = "SUCCESS";

public static final String FAILED_STATUS = "FAILED";



 }
