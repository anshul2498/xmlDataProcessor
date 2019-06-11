package com.companyname.data.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Service
public class TestDataService {

	public String getJson(MultipartFile File) throws IOException, JSONException {
		File xml;
		xml=convert(File);
		String xmlData = FileUtils.readFileToString(xml,
				"UTF-8");
		
		Document doc = convertStringToXMLDocument(xmlData);
		NodeList childNodes = doc.getChildNodes();
		for(int i=0; i<childNodes.getLength();i++){
			doSomething(childNodes.item(i));
		}
		
		JSONObject json= XML.toJSONObject(xmlData);
		Iterator<String> keys= json.keys();
		while(keys.hasNext()) {
			System.out.println(" :: "+keys.next());
		}
		return json.toString();
		
	}
	
	public static File convert(MultipartFile file) throws IOException {

        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;

    }
	
	private static Document convertStringToXMLDocument(String xmlString)
    {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         
        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try
        {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();
             
            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

	public static void doSomething(Node node) {
	    // do something with the current node instead of System.out
	    System.out.println(node.getNodeName());

	    NodeList nodeList = node.getChildNodes();
	    for (int i = 0; i < nodeList.getLength(); i++) {
	        Node currentNode = nodeList.item(i);
	        if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
	            //calls this method for all the children which is Element
	            doSomething(currentNode);
	        }
	    }
	}	
}
