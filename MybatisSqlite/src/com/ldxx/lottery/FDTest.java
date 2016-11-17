package com.ldxx.lottery;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.ldxx.lottery.dao.FirstDistributionDao;
import com.ldxx.lottery.dao.ResultDAO;
import com.ldxx.lottery.dao.impl.FirstDistributionDaoImpl;
import com.ldxx.lottery.dao.impl.ResultDAOImpl;
import com.ldxx.lottery.orm.FirstDistribution;
import com.ldxx.lottery.orm.LotteryResult;
import com.ldxx.utils.DBUtils;
import com.ldxx.utils.StringUtils;

public class FDTest {
	public static void main(String[] args) {
		String issue;
		LotteryResult result;
		ResultDAO rd = new ResultDAOImpl(DBUtils.getSqlSession());
		FirstDistributionDao fd = new FirstDistributionDaoImpl(DBUtils.getSqlSession());
		String info;
		for (int is = 2016124; is < 2016135; is++) {
			issue = String.valueOf(is);
			result = rd.getResultByIssue(issue);
			
			info = result.getExtra_info();
			// 若为空直接停止
			if (StringUtils.isEmpty(info)) {
				return;
			}
			fd.deleteByIssue(issue);
			String[] infos;
			String str1;
			if (info.contains("本期一等奖中奖地")) {
				if (info.indexOf("本期一等奖中奖地") > 0) {
					info = info.replaceAll("本期一等奖中奖地:", "本期一等奖中奖地：");
					info = info.substring(info.indexOf("本期一等奖中奖地："), info.length());
				}
				infos = info.split("。");
				str1 = infos[0].substring(infos[0].indexOf("：") + 1,
						infos[0].length());
				toMake(fd,str1, issue);
			} else if (info.contains("中出一等奖")) {
				info = info.substring(info.indexOf("由") + 1, info.length());
				info = info.replaceAll("[.]", "。").replaceAll("中得", "")
						.replaceAll("中出", "");
				info = info.split("。")[0];
				toMake(fd,info, issue);
			} else if (info.contains("本期一等奖") && info.contains("由")) {
				String key = (info.contains("中得")) ? "中得" : "中出";
				String str = info.split("由")[1].split(key)[0];
				toMake(fd,str, issue);
			} else if (info.contains("本期一等奖0注") || info.contains("本期没有一等奖产生")
					|| !info.contains("一等奖")) {
				// 没有一等奖，不处理
			} else if (info.contains("一等奖中奖地：")) {
				info = info.split("一等奖中奖地：")[1].split("。")[0];
				toMake(fd,info, issue);
			} else if (info.contains("出自")) {
				info = info.split("出自")[1].split("。")[0];
				toMake(fd,info, issue);
			}else if(info.contains("一等奖中奖情况：")){
			    info = info.split("一等奖中奖情况：")[1].split("。")[0];
			    toMake(fd,info, issue);
			}
			
		}
	}
	
	/**
	 * 制作数据各省中奖情况的数据
	 * 
	 * @param str1
	 * @param issue
	 */
	private static  void toMake(FirstDistributionDao fd,String str1, String issue) {
		String[] str1s;
		FirstDistribution first = new FirstDistribution();
		first.setIssue(issue);
		str1 = str1.replaceAll("、", " ").replaceAll("；", " ")
				.replaceAll("，", " ").replaceAll("各", "").replaceAll(", ", " ")
				.replaceAll(",", " ").replaceAll("[(]", "")
				.replaceAll("[)]", "");

		str1s = str1.split(" ");
		String[] ss;
		for (String s : str1s) {

			if (s.contains("本期") || s.equals("无")||(s.contains("共")&&s.contains("注"))) {
				continue;
			}
			first.setPid(UUID.randomUUID().toString());
			ss = s.split("[0-9]");
			if (ss.length == 0 || StringUtils.isEmpty(ss[0])
					|| s.contains("红球")) {
				continue;
			}

			first.setProvince_name(ss[0]);
			first.setProvince_py(priv.get(ss[0]));
			if (ss.length > 1) {

				first.setNum(Integer.parseInt(s.replaceAll(ss[0], "")
						.replaceAll("注", "").replaceAll("注、", "")
						.replaceAll("[.]", "").replaceAll("。", "")));

			} else {
				first.setNum(1);
			}
			fd.insertFirstDistribution(first);

		}
	}

	// 所有省，直辖市，自治区
	private static Map<String, String> priv = new HashMap<String, String>();

	static {

		priv.put("北京", "beijing");
		priv.put("广东", "guangdong");
		priv.put("山东", "shandong");
		priv.put("江苏", "jiangsu");
		priv.put("河南", "henan");
		priv.put("上海", "shanghai");
		priv.put("河北", "hebei");
		priv.put("浙江", "zhejiang");
		priv.put("香港", "xianggang");
		priv.put("陕西", "shan3xi");
		priv.put("湖南", "hunan");
		priv.put("重庆", "chongqing");
		priv.put("福建", "fujian");
		priv.put("天津", "tianjin");
		priv.put("云南", "yunnan");
		priv.put("四川", "sichuan");
		priv.put("广西", "guangxi");
		priv.put("安徽", "anhui");
		priv.put("海南", "hainan");
		priv.put("江西", "jiangxi");
		priv.put("湖北", "hubei");
		priv.put("山西", "shan1xi");
		priv.put("辽宁", "liaoning");
		priv.put("台湾", "taiwan");
		priv.put("黑龙江", "heilongjiang");
		priv.put("内蒙古", "neimenggu");
		priv.put("澳门", "aomen");
		priv.put("贵州", "guizhou");
		priv.put("甘肃", "gansu");
		priv.put("青海", "qinghai");
		priv.put("新疆", "xinjiang");
		priv.put("西藏", "xizang");
		priv.put("吉林", "jilin");
		priv.put("宁夏", "nixia");
		priv.put("深圳", "shenzhen");

	}
}
