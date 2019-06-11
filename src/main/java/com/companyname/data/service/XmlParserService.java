package com.companyname.data.service;
import java.util.TreeMap;

import javax.lang.model.element.Element;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParserService {
	
	public static void parser(Document doc)
	{
		
		TreeMap<Integer,Object> hmap = new TreeMap<>();		
		NodeList childNodes = doc.getChildNodes();
		for(int i=0; i<childNodes.getLength();i++){
			doSomething(childNodes.item(i));
		}               
	}
	
//	public static void doSomething(Node node) {
//	    // do something with the current node instead of System.out
//	    System.out.println(node.getNodeName());
//	    System.out.println(node.getNodeValue());
//
//	    NodeList nodeList = node.getChildNodes();
//	    for (int i = 0; i < nodeList.getLength(); i++) {
//	        Node currentNode = nodeList.item(i);
//	        if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
//	            //calls this method for all the children which is Element
//	            //doSomething(currentNode);
//	        }
//	    }
	
	public static getParent(Document xmlDoc)
	{
		Node root = null;

	    NodeList list = xmlDoc.getChildNodes();
	    for (int i = 0; i < list.getLength(); i++) {
	      if (list.item(i) instanceof Element) {
	        root = (Element) list.item(i);
	        break;
	      }else {
	    	  root=list.item(0);
	      }
	    }
	    
	    
	    
	
	}}
