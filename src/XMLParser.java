import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //Get the documentbuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            //get document needet to parse
            Document document = builder.parse(new File("students.xml"));
            //Normalize the XML tructure
            document.getDocumentElement().normalize();
            //Get all elements by tag name
            NodeList studentList = document.getElementsByTagName("student");
            for (int i = 0; i < studentList.getLength(); i++) {
                Node student = studentList.item(i);

                if (student.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) student;
                    /*if(studentElement.getAttribute("name").equals("002")) {
                        System.out.println("aaa");
                    }*/
                    System.out.println(studentElement.getAttribute("name"));
                    NodeList studentsDelails = student.getChildNodes();
                    for (int j = 0; j < studentsDelails.getLength(); j++){
                        Node details = studentsDelails.item(j);
                        if(details.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) details;
                            System.out.println("   " + detailElement.getTagName() + "  " + detailElement.getAttribute("value"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
