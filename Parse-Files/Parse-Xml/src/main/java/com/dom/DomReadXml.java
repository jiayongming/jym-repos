package com.dom;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.SneakyThrows;

public class DomReadXml {
	@Test @SneakyThrows
	public void test1(){
		long lasting = System.currentTimeMillis();
		
		File file = new File("e:/persons.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);
		NodeList nls = document.getElementsByTagName("person");
		for (int i = 0; i < nls.getLength(); i++) {
			System.out.println("name="+document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue());
		}
		System.out.println(lasting);
	}
	
	
	@Test @SneakyThrows
	public void test2() {
	//  实例化一个xml创建工厂类
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//解析xml文件的解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		FileInputStream fis = new FileInputStream("e:/persons.xml");
		Document document = db.parse(fis);
		//默认返回xml文件的根节点
		Element persons = document.getDocumentElement();
		NodeList nodes = persons.getChildNodes();
		
//		System.out.println(nodes.getLength());
		//遍历子节点
		for(int i =0 ; i < nodes.getLength();i++){
			//获得指定下标的节点
			Node node = nodes.item(i);
//			System.out.println(node.getNodeType());
			
			//获得该节点的标签名
			String nodeName = node.getNodeName();
			if("person".equals(nodeName)){
				// 拿到当前标签的所有属性，返回一个namedNodeMap
			/*	NamedNodeMap nodeMap = node.getAttributes();
				Node id = nodeMap.getNamedItem("id");
				System.out.println(id.getNodeValue());*/
				// 根据属性名，拿到属性值
				if(node.getNodeType() == 1){
					Element e = (Element)node;
					String id = e.getAttribute("id");
					System.out.println("id--->"+id);
				}
				NodeList nodes2 = node.getChildNodes();
				for(int j = 0 ; j <nodes2.getLength();j++){
						Node node2 = nodes2.item(j);
						String nodeName2 = node2.getNodeName();
						if("name".endsWith(nodeName2)){
							System.out.println("name-->"+node2.getTextContent());
						}
						if("age".equals(nodeName2)){
							System.out.println("age--->"+node2.getTextContent());
						}
				}
			}
		}
		System.out.println("=====================================");
		NodeList list = document.getElementsByTagName("name");
		for(int i = 0; i <list.getLength();i++){
			System.out.println(list.item(i).getTextContent());
		}
		System.out.println("=====================================");
		try {
			//Element element = document.getElementById("1");
			//System.out.println(element.getNodeName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
