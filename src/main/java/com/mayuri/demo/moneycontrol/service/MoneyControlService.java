package com.mayuri.demo.moneycontrol.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayuri.demo.moneycontrol.dao.MoneyControlDao;
import com.mayuri.demo.moneycontrol.dao.NegativeWordsDao;
import com.mayuri.demo.moneycontrol.dao.PositiveWordsDao;
import com.mayuri.demo.moneycontrol.model.MoneyControlLiveModel;
import com.mayuri.demo.moneycontrol.model.MoneyControlModel;
import com.mayuri.moneycontrol.constant.MessageConstant;

@Service
public class MoneyControlService {

	@Autowired 
	MoneyControlDao moneyControlDao;

	@Autowired
	PositiveWordsDao positiveWordsDao;

	@Autowired
	NegativeWordsDao negativeWordsDao;

	public List<MoneyControlModel> getMessages(String nickname) {
		List<MoneyControlModel> moneyControlList= moneyControlDao.findByNickname(nickname);
		return moneyControlList;
	}

	public void deleteMessage(Long id) {
		moneyControlDao.deleteById(id);

	}

	public MoneyControlModel saveMessages() throws IOException {

		MoneyControlModel moneyConModel = null;
		String doc = null, s1="";

		for(int i=0; i<=10; i++) {  // to get page number

			for(String userName: MessageConstant.USER_NAME) {
				System.out.println("User name: " + userName);
				doc = Jsoup.connect(MessageConstant.FORUM_URL.replace("#userName", userName) + i).ignoreContentType(true).execute().body();

				ObjectMapper objectMapper = new ObjectMapper();

				MoneyControlLiveModel[] moneyLiveControl = new MoneyControlLiveModel[0];   //  to read value of response (json)
				try {
					moneyLiveControl = objectMapper.readValue(doc, MoneyControlLiveModel[].class);
					for (MoneyControlLiveModel moneyControlMod : moneyLiveControl) {
						for(String postiveWords : MessageConstant.POSITIVE_WORDS) {
							//System.out.println("@@@ " +  (moneyControlMod.getFull_message()).contains(postiveWords));
							if((moneyControlMod.getFull_message()).contains(postiveWords)) {
								MoneyControlModel moneyControlObj = new MoneyControlModel();
								moneyControlObj.setFullMessage(moneyControlMod.getFull_message());
								moneyControlObj.setNickname(moneyControlMod.getNick_name());
								moneyControlObj.setTOTAL_MSG_COUNT(moneyControlMod.getTOTAL_MSG_CNT());
								moneyControlObj.setStatus("Positive");
								moneyConModel = moneyControlDao.save(moneyControlObj);
							}
						}

						for(String negativeWords: MessageConstant.NEGATIVE_WORDS) {
							if((moneyControlMod.getFull_message()).contains(negativeWords)) {
								MoneyControlModel moneyControlObj = new MoneyControlModel();
								moneyControlObj.setFullMessage(moneyControlMod.getFull_message());
								moneyControlObj.setNickname(moneyControlMod.getNick_name());
								moneyControlObj.setTOTAL_MSG_COUNT(moneyControlMod.getTOTAL_MSG_CNT());
								moneyControlObj.setStatus("Negative"); 
								moneyConModel = moneyControlDao.save(moneyControlObj); 
							}
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return moneyConModel;
	}

}
