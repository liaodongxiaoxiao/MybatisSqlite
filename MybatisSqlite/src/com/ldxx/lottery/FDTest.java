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
			// ��Ϊ��ֱ��ֹͣ
			if (StringUtils.isEmpty(info)) {
				return;
			}
			fd.deleteByIssue(issue);
			String[] infos;
			String str1;
			if (info.contains("����һ�Ƚ��н���")) {
				if (info.indexOf("����һ�Ƚ��н���") > 0) {
					info = info.replaceAll("����һ�Ƚ��н���:", "����һ�Ƚ��н��أ�");
					info = info.substring(info.indexOf("����һ�Ƚ��н��أ�"), info.length());
				}
				infos = info.split("��");
				str1 = infos[0].substring(infos[0].indexOf("��") + 1,
						infos[0].length());
				toMake(fd,str1, issue);
			} else if (info.contains("�г�һ�Ƚ�")) {
				info = info.substring(info.indexOf("��") + 1, info.length());
				info = info.replaceAll("[.]", "��").replaceAll("�е�", "")
						.replaceAll("�г�", "");
				info = info.split("��")[0];
				toMake(fd,info, issue);
			} else if (info.contains("����һ�Ƚ�") && info.contains("��")) {
				String key = (info.contains("�е�")) ? "�е�" : "�г�";
				String str = info.split("��")[1].split(key)[0];
				toMake(fd,str, issue);
			} else if (info.contains("����һ�Ƚ�0ע") || info.contains("����û��һ�Ƚ�����")
					|| !info.contains("һ�Ƚ�")) {
				// û��һ�Ƚ���������
			} else if (info.contains("һ�Ƚ��н��أ�")) {
				info = info.split("һ�Ƚ��н��أ�")[1].split("��")[0];
				toMake(fd,info, issue);
			} else if (info.contains("����")) {
				info = info.split("����")[1].split("��")[0];
				toMake(fd,info, issue);
			}else if(info.contains("һ�Ƚ��н������")){
			    info = info.split("һ�Ƚ��н������")[1].split("��")[0];
			    toMake(fd,info, issue);
			}
			
		}
	}
	
	/**
	 * �������ݸ�ʡ�н����������
	 * 
	 * @param str1
	 * @param issue
	 */
	private static  void toMake(FirstDistributionDao fd,String str1, String issue) {
		String[] str1s;
		FirstDistribution first = new FirstDistribution();
		first.setIssue(issue);
		str1 = str1.replaceAll("��", " ").replaceAll("��", " ")
				.replaceAll("��", " ").replaceAll("��", "").replaceAll(", ", " ")
				.replaceAll(",", " ").replaceAll("[(]", "")
				.replaceAll("[)]", "");

		str1s = str1.split(" ");
		String[] ss;
		for (String s : str1s) {

			if (s.contains("����") || s.equals("��")||(s.contains("��")&&s.contains("ע"))) {
				continue;
			}
			first.setPid(UUID.randomUUID().toString());
			ss = s.split("[0-9]");
			if (ss.length == 0 || StringUtils.isEmpty(ss[0])
					|| s.contains("����")) {
				continue;
			}

			first.setProvince_name(ss[0]);
			first.setProvince_py(priv.get(ss[0]));
			if (ss.length > 1) {

				first.setNum(Integer.parseInt(s.replaceAll(ss[0], "")
						.replaceAll("ע", "").replaceAll("ע��", "")
						.replaceAll("[.]", "").replaceAll("��", "")));

			} else {
				first.setNum(1);
			}
			fd.insertFirstDistribution(first);

		}
	}

	// ����ʡ��ֱϽ�У�������
	private static Map<String, String> priv = new HashMap<String, String>();

	static {

		priv.put("����", "beijing");
		priv.put("�㶫", "guangdong");
		priv.put("ɽ��", "shandong");
		priv.put("����", "jiangsu");
		priv.put("����", "henan");
		priv.put("�Ϻ�", "shanghai");
		priv.put("�ӱ�", "hebei");
		priv.put("�㽭", "zhejiang");
		priv.put("���", "xianggang");
		priv.put("����", "shan3xi");
		priv.put("����", "hunan");
		priv.put("����", "chongqing");
		priv.put("����", "fujian");
		priv.put("���", "tianjin");
		priv.put("����", "yunnan");
		priv.put("�Ĵ�", "sichuan");
		priv.put("����", "guangxi");
		priv.put("����", "anhui");
		priv.put("����", "hainan");
		priv.put("����", "jiangxi");
		priv.put("����", "hubei");
		priv.put("ɽ��", "shan1xi");
		priv.put("����", "liaoning");
		priv.put("̨��", "taiwan");
		priv.put("������", "heilongjiang");
		priv.put("���ɹ�", "neimenggu");
		priv.put("����", "aomen");
		priv.put("����", "guizhou");
		priv.put("����", "gansu");
		priv.put("�ຣ", "qinghai");
		priv.put("�½�", "xinjiang");
		priv.put("����", "xizang");
		priv.put("����", "jilin");
		priv.put("����", "nixia");
		priv.put("����", "shenzhen");

	}
}
