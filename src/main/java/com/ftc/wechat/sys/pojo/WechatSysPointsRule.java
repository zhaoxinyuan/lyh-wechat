package com.ftc.wechat.sys.pojo;

public class WechatSysPointsRule {
	private Integer ruleId;

	private Integer ruleDictid;

	private Double ruleValue;

	private WechatSysPointsDict ruleDict;

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public Integer getRuleDictid() {
		return ruleDictid;
	}

	public void setRuleDictid(Integer ruleDictid) {
		this.ruleDictid = ruleDictid;
	}

	public Double getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(Double ruleValue) {
		this.ruleValue = ruleValue;
	}

	public WechatSysPointsDict getRuleDict() {
		return ruleDict;
	}

	public void setRuleDict(WechatSysPointsDict ruleDict) {
		this.ruleDict = ruleDict;
	}

}