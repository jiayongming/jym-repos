package com.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.model.Person;

public class PersonHandler  extends DefaultHandler{
	public static List<Person> list = null;
	private Person person;
	private String tagName;
	//专门处理文件节点
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println(tagName+"------");
		String str = new String(ch,start,length);
		if("name".equals(tagName)){
			person.setName(str);
		}
		if("age".equals(tagName)){
			person.setAge(Integer.parseInt(str));
		}
		System.out.println("遇到文本节点"+str);
	}
	//当解析xml文件结束的时候触发
	@Override
	public void endDocument() throws SAXException {
		System.out.println("文件解析结束");
		
	}
	
	/**
	 * 	当解析到一个结束标签的时候触发
	 * 	uri: xml文件的唯一标示
	 * localName:不带前缀的标签名
	 * qName:带有前缀的标签名
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if("person".equals(qName)){
			list.add(person);
		}
		tagName="";
//		System.out.println("当前标签解析结束"+uri+"---->"+ localName+"--->"+ qName);
	}
	/**
	 *   文档开始被解析的时候执行,
	 *   一般执行一些初始化工作
	 */
	@Override
	public void startDocument() throws SAXException {
//		System.out.println("开始解析文档");
		list = new ArrayList<Person>();
	}
	/**当解析xml文件时遇到开始标签触发,一般拿到标签的属性，做出相应的处理
	 * attributes:封装了当前标签的所有属性
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
//		System.out.println("开始解析标签"+uri+"-->"+ qName+"--->"+attributes);
//		System.out.println(tagName+"----tagName-----"+qName);
		tagName= qName;
		if("person".equals(qName)){
			person = new Person();
			String id = attributes.getValue("id");
			person.setId(Integer.parseInt(id));
		}
		
		for(int i = 0; i < attributes.getLength();i++){
			System.out.println("-------------"+attributes.getQName(i));
		}
//		System.out.println(person+"----");
	}
	
}
