package com.dom;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;

@Log4j
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
			log.info("name="+document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue());
		}
		log.info(lasting);
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
		
		//遍历子节点
		for(int i =0 ; i < nodes.getLength();i++){
			//获得指定下标的节点
			Node node = nodes.item(i);

			//获得该节点的标签名
			String nodeName = node.getNodeName();
			if("person".equals(nodeName)){
				// 拿到当前标签的所有属性，返回一个namedNodeMap
			/*	NamedNodeMap nodeMap = node.getAttributes();
				Node id = nodeMap.getNamedItem("id");
				log.info(id.getNodeValue());*/
				// 根据属性名，拿到属性值
				if(node.getNodeType() == 1){
					Element e = (Element)node;
					String id = e.getAttribute("id");
					log.info("id--->"+id);
				}
				NodeList nodes2 = node.getChildNodes();
				for(int j = 0 ; j <nodes2.getLength();j++){
						Node node2 = nodes2.item(j);
						String nodeName2 = node2.getNodeName();
						if("name".endsWith(nodeName2)){
							log.info("name-->"+node2.getTextContent());
						}
						if("age".equals(nodeName2)){
							log.info("age--->"+node2.getTextContent());
						}
				}
			}
		}
		log.info("=====================================");
		NodeList list = document.getElementsByTagName("name");
		for(int i = 0; i <list.getLength();i++){
			log.info(list.item(i).getTextContent());
		}
		log.info("=====================================");
		try {
			//Element element = document.getElementById("1");
			//log.info(element.getNodeName());
		} catch (Exception e) {
			log.error("error :" ,e);
		}
	}
}
