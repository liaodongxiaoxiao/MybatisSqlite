package com.ldxx.lottery;

import com.ldxx.lottery.dao.BonusInfoDAO;
import com.ldxx.lottery.dao.ResultDAO;
import com.ldxx.lottery.dao.impl.BonusInfoDAOImpl;
import com.ldxx.lottery.dao.impl.ResultDAOImpl;
import com.ldxx.lottery.orm.BonusInfo;
import com.ldxx.lottery.orm.LotteryResult;
import com.ldxx.utils.DBUtils;

public class BITest {
	public static void main(String[] args) {
		ResultDAO rd = new ResultDAOImpl(DBUtils.getSqlSession());
		BonusInfoDAO bd = new BonusInfoDAOImpl(DBUtils.getSqlSession());
		LotteryResult lr;
		BonusInfo bi;
		String[] infos;
		String issue;
		
		String[] is;
		String bInfo;
		
		for (int i = 2016124; i < 2016134; i++) {
			issue = String.valueOf(i);
			lr = rd.getResultByIssue(issue);
			//System.out.println(lr.getBonus_info());
			bInfo = lr.getBonus_info();
			if (bInfo.endsWith("|")) {
				bInfo = bInfo.substring(0, bInfo.length() - 1);
			}
			
			infos = lr.getBonus_info().split("[|]");
			bd.deleteByIssue(issue);
			
			bi = new BonusInfo();
			bi.setIssue(issue);
			//沒有加奖情况
			if (infos.length == 6) {
				for (String ss : infos) {
				    is = ss.split(":");
					bi.setBonus_type(is[0]);
					bi.setBonus_num(is[1]);
					bi.setBonus(is[2]);
					bd.insertBonus(bi);
				}
			}else{
				for(int k=0,j=infos.length;k<j;k++){
					is = infos[k].split(":");
					if(k==1){
						bi.setBonus_type("11");
					}else if(k==j-1){
						bi.setBonus_type("66");
					}else{
						bi.setBonus_type(is[0]);
					}
					//bi.setBonus_type(is[0]);
					bi.setBonus_num(is[1]);
					bi.setBonus(is[2]);
					bd.insertBonus(bi);
				}
			}
		}
	}
}
