package com.yc.clw.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.clw.bean.ClwCountry;
import com.yc.clw.bean.ClwGeners;
import com.yc.clw.bean.ClwMovielist;
import com.yc.clw.bean.ClwNews;

@Component
public class GenersAndCountryAction implements IGenersAndCountryAction{

	@Override
	public List<ClwGeners> lessthangetGeners() {
		List<ClwGeners> list = new ArrayList<ClwGeners>();
		list.add(new ClwGeners(1,"动作"));
		list.add(new ClwGeners(2,"喜剧"));
		return list;
	}

	@Override
	public List<ClwGeners> betweengetGeners() {
		List<ClwGeners> list = new ArrayList<ClwGeners>();
		list.add(new ClwGeners(1,"恐怖"));
		list.add(new ClwGeners(2,"惊悚"));
		return list;
	}

	@Override
	public List<ClwGeners> greatthangetGeners() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClwCountry> greaterthangetcountry() {
		List<ClwCountry> list = new ArrayList<ClwCountry>();
		list.add(new ClwCountry(1,"中国"));
		list.add(new ClwCountry(2,"美国"));
		return list;
	}

	@Override
	public List<ClwCountry> lessthangetcounttry() {
		List<ClwCountry> list = new ArrayList<ClwCountry>();
		list.add(new ClwCountry(1,"法国"));
		list.add(new ClwCountry(2,"英国"));
		return list;
	}

	@Override
	public List<ClwCountry> betweengetcounttry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClwMovielist> getClwMovielist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClwMovielist> getnewmovie() {
		List<ClwMovielist> list = new ArrayList<>();
		list.add(new ClwMovielist(1, "肖申克的救赎", "故事发生在1947年，银行家安迪（Andy）被指控枪杀了妻子及其情人，\r\n" + 
				" 安迪被判无期徒刑，这意味着他将在肖申克监狱中渡过余生。\r\n" + 
				"瑞德（Red）1927年因谋杀罪被判无期徒刑，数次假释都未获成功。他成为了肖申克监狱中的“权威人物”，只要你付得起钱，他几乎有办法搞到任何你想要的东西：香烟、糖果、酒，甚至是大麻。每当有新囚犯来的时候，大家就赌谁会在第一个夜晚哭泣。瑞德认为弱不禁风、书生气十足的安迪一定会哭，结果安迪的沉默使他输掉了两包烟，但同时也使瑞德对他另眼相看", 3, 5, "images/timg.jpg"));
		list.add(new ClwMovielist(2, "教父", "维托·唐·科莱昂是黑手党首领，常干违法的勾当。但同时他也是许多弱小平民的保护神，深得人们爱戴。他还有一个准则，就是决不贩毒害人。为此他拒绝了毒枭素洛佐的要求，并因此激化了与纽约其它几个黑手党家族的矛盾。圣诞前夕，素洛佐劫持了教父的教子汤姆，并派人暗杀教父。教父中枪入院。素洛佐要汤姆设法使逊尼同意毒品买卖，重新谈判。逊尼有勇无谋，他发誓报仇，却无计可施。　\r\n" + 
				"　　迈克去医院探望父亲，他发现保镖已被收买，而警方亦和素洛佐串通一气。各家族间的火拼一触即发。迈克制定了一个计策诱使素洛佐和警长前来谈判。在一家小餐馆内，迈克用事先藏在厕所内的手枪击毙了素洛佐和警长。　\r\n" + 
				"　　迈克逃到了西西里，在那里他娶了美丽的阿波萝妮亚为妻，过着田园诗般的生活。而此时，纽约各个黑手党家族间的仇杀却越来越激烈。逊尼也被康妮的丈夫卡洛出卖，被人打得千疮百孔。教父伤愈复出，安排各家族间的和解。听到噩耗的迈克也受到了袭击。被收买的保镖法布里奇奥在迈克的车上装了炸弹。迈克虽幸免于难，却痛失爱妻。", 3, 5, "images/jiaofu.jpg"));
		return list;
	}
	
	@Override
	public List<ClwNews> getfindall() {
		return null;
	}

	@Override
	public List<ClwNews> latestnew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClwNews getclwnews(@RequestParam("id")Integer id) {
		return null;
	}

	@Override
	public List<ClwMovielist> getgenresmovie(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClwMovielist> getcountrmovie(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
