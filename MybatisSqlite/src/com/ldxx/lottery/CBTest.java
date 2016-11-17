package com.ldxx.lottery;

import java.util.Set;
import java.util.TreeSet;

import com.ldxx.lottery.dao.ContinuousBallDAO;
import com.ldxx.lottery.dao.ResultDAO;
import com.ldxx.lottery.dao.impl.ContinuousBallDAOImpl;
import com.ldxx.lottery.dao.impl.ResultDAOImpl;
import com.ldxx.lottery.orm.ContinuousBall;
import com.ldxx.lottery.orm.LotteryResult;
import com.ldxx.utils.DBUtils;
import com.ldxx.utils.PublicUtils;
import com.ldxx.utils.StringUtils;

public class CBTest {
	public static void main(String[] args) {
		String issue;
		LotteryResult result;
		ResultDAO rd = new ResultDAOImpl(DBUtils.getSqlSession());
		ContinuousBallDAO continuousBallDao = new ContinuousBallDAOImpl(DBUtils.getSqlSession());
		ContinuousBall c;
		for (int is = 2016124; is < 2016135; is++) {
			issue = String.valueOf(is);
			result = rd.getResultByIssue(issue);

			if (StringUtils.isEmpty(result.getRed_balls())) {
				return;
			}
			String balls = result.getRed_balls().trim();
			issue = result.getIssue();
			// охи╬ЁЩ
			continuousBallDao.deleteByIssue(issue);

			String[] reds = balls.split(",");
			Set<String> list = new TreeSet<String>();
			int t1 = Integer.parseInt(reds[0]);
			int t2;
			c = new ContinuousBall();
			c.setIssue(issue);
			for (int i = 1, j = reds.length; i < j; i++) {
				t2 = Integer.parseInt(reds[i]);
				if ((t2 - t1) == 1) {
					list.add(reds[i - 1]);
					list.add(reds[i]);
				} else if (list.size() > 1) {
					c.setContinuous_ball(PublicUtils.setToString(list));
					c.setContinuous_num(list.size());
					continuousBallDao.insert(c);
					list = new TreeSet<String>();
				}
				t1 = t2;
			}
			if (list.size() > 0) {
				c.setContinuous_ball(PublicUtils.setToString(list));
				c.setContinuous_num(list.size());
				continuousBallDao.insert(c);
			}
		}

	}

}
