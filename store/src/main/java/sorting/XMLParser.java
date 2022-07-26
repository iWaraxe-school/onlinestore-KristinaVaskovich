package sorting;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParser {
    private static final String FILENAME = "consoleApp/src/main/resources/sorting.xml";

    public Map<String, String> getMap() {
        Map<String, String> fieldAndSort = new LinkedHashMap<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            if (doc.getFirstChild().hasChildNodes()) {
                NodeList nodeList = doc.getFirstChild().getChildNodes();
                for (int count = 0; count < nodeList.getLength(); count++) {
                    Node tempNode = nodeList.item(count);
                    if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                        fieldAndSort.put(tempNode.getNodeName(), tempNode.getTextContent());
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return fieldAndSort;
    }
}
