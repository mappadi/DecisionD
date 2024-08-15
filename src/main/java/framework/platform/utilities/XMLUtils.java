package framework.platform.utilities;

import framework.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * XMLUtils
 */
public class XMLUtils {

	public static void printNode(NodeList nodeList) {
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				Logger.info("OPEN Node " + tempNode.getNodeName() + " = " + tempNode.getTextContent());
				if (tempNode.hasAttributes()) {
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						Logger.info("Attribute " + node.getNodeName() + " = " + node.getNodeValue());
					}
				}
				if (tempNode.hasChildNodes()) {
					printNode(tempNode.getChildNodes());
				}
				Logger.info("CLOSE Node " + tempNode.getNodeName());
			}
		}
	}

	public static boolean isNodePresentInDocument(Document doc, String nodeName) {
		return doc.getElementsByTagName(nodeName).getLength() > 0;
	}

	public static String getTagContentForElementNumber(Document doc, String tag, int number) {
		String tagContent = "";
		NodeList nodeList = doc.getElementsByTagName(tag);
		if (isNodePresentInDocument(doc, tag)) {
			tagContent = nodeList.item(number).getChildNodes().item(0).getTextContent();
		}
		Logger.debug("Tag content: " + tagContent);
		return tagContent;
	}
}
