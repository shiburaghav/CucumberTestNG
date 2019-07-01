package com.nttd.automation.pages.elements;

import com.nttd.automation.common.FindBy;

public class HomePageElements {
	public static FindBy txtPincode = FindBy.findByID("txtLocateUsSearch", "txtPincode");
	public static FindBy divDropDownButton = FindBy.findByXPath("//span[text()='Branches']//following-sibling::a[@class='jqTransformSelectOpen']", "divDropDownButton");
	public static FindBy divBranches = FindBy.findByXPath("//a[text()='Branches']", "divBranches");
	public static FindBy divATM = FindBy.findByXPath("//a[text()='ATMs']", "divATM");
	public static FindBy btnLocateUs = FindBy.findByID("btnLocateus", "btnLocateUs");
}
