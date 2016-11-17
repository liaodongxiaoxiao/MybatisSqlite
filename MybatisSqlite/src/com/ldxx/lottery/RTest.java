package com.ldxx.lottery;

import java.util.List;

import com.ldxx.lottery.dao.RecommendDao;
import com.ldxx.lottery.dao.ResultDAO;
import com.ldxx.lottery.dao.impl.RecommendDaoImpl;
import com.ldxx.lottery.dao.impl.ResultDAOImpl;
import com.ldxx.lottery.orm.LotteryResult;
import com.ldxx.lottery.orm.RecDer;
import com.ldxx.lottery.orm.Recommender;
import com.ldxx.utils.DBUtils;
import com.ldxx.utils.StringUtils;


public class RTest {
	
	public static void main(String[] args) {
		String issue;
		LotteryResult result;
		ResultDAO rd = new ResultDAOImpl(DBUtils.getSqlSession());
		RecommendDao reDao = new RecommendDaoImpl(DBUtils.getSqlSession());
		
		for (int is = 2016124; is < 2016135; is++) {
			issue = String.valueOf(is);
			result = rd.getResultByIssue(issue);
			update(reDao,result);
		}
	}

	public static void update(RecommendDao recommendDao,LotteryResult result) {
        // 1. ��һ�±������˼�����
        Recommender re = recommendDao.getRecommender(result.getIssue());
        if (re != null && !StringUtils.isEmpty(re.getRed_balls()) && !StringUtils.isEmpty(re.getBlue_balls())) {
            re.setRedwin_num(getRedWinNum(re.getRed_balls(), result.getRed_balls()));
            // ���������еĸ���
            re.setBluewin_num(getBLueWinNum(re.getBlue_balls(), result.getBlue_ball()));
            //���к������˻������У������һ�£��Ƽ��������û�в����� bug
            if (re.getRedwin_num() > 0 || re.getBluewin_num() > 0) {
                recommendDao.updateRemmendData(re);
            }
        }
        // 2. ����ÿ�˵÷� ��һ������2�֣���һ������5��
        List<Recommender> data = recommendDao.getRecommendData(result.getIssue());
        for (Recommender rc : data) {
            rc.setBluewin_num(getBLueWinNum(rc.getBlue_balls(), result.getBlue_ball()));
            rc.setRedwin_num(getRedWinNum(rc.getRed_balls(), result.getRed_balls()));
            // ��һ��û�У��Ͳ�����
            if (rc.getBluewin_num() != 0 || rc.getRedwin_num() != 0) {
                recommendDao.updateRemmend(rc);
            }

            RecDer rec = recommendDao.getRecDer(rc.getP_name());
            if (rec == null) {
                rec = new RecDer();
                rec.setPname(rc.getP_name());
                rec.setR_num(1);
                rec.setR_score(rc.getBluewin_num() * 5 + rc.getRedwin_num() * 2);
                recommendDao.insertRecDer(rec);
            }
            else {
                rec.setR_score(rc.getBluewin_num() * 5 + rc.getRedwin_num() * 2);
                recommendDao.updateRecDer(rec);
            }
        }
    }
	
	/**
     * ��������еĸ���
     * 
     * @param reBall
     * @param result
     * @return
     */
    private static int getRedWinNum(String reBall, String result) {
        int i = 0;
        if (StringUtils.isEmpty(result) || StringUtils.isEmpty(reBall)) {
            return i;
        }
        //
        String[] balls = result.split(",");
        String[] reds = reBall.split(",");
        for (String ball : balls) {
            for (String red : reds) {
                if (ball.equals(red)) {
                    i++;
                }
            }
        }
        return i;
    }

    /**
     * �����е��������
     * 
     * @param blueBall
     * @param result
     * @return
     */
    private static int getBLueWinNum(String blueBall, String result) {
        if (StringUtils.isEmpty(result) || StringUtils.isEmpty(blueBall)) {
            return 0;
        }
        String[] balls = blueBall.split(",");
        for (String ball : balls) {
            if (ball.equals(result)) {
                return 1;
            }
        }
        return 0;
    }
}
