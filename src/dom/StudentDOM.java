package dom;

//import javax.swing.text.Document;
//import javax.swing.text.Element;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class StudentDOM {
    public void Add() {
        try {
            Document d = DOMHelper.getDocument("src\\data\\students.xml");
            Element students = d.getDocumentElement();
            //crate student tag
            Element student = d.createElement("student");
            // create id tag
            Element id = d.createElement("id");
            id.appendChild(d.createTextNode("04"));
            student.appendChild(id);
            //create name tag
            Element name = d.createElement("name");
            name.appendChild(d.createTextNode("name 4"));
            student.appendChild(name);
            //create age tag
            Element age = d.createElement("age");
            age.appendChild(d.createTextNode("24"));
            student.appendChild(id);
            //write to file
            DOMHelper.saveXMLContent(d, "src\\data\\students.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void Delete(String id) {
        try {
            Document d = DOMHelper.getDocument("demo.XMLTest\\students.xml");
            NodeList nl = d.getElementsByTagName("student");
            for(int i = 0; i < nl.getLength(); i++) {
                Element estudent = (Element) nl.item(i);
                if(estudent.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
                    estudent.getParentNode().removeChild(estudent);
                }
            }
            DOMHelper.saveXMLContent(d, "demo.XMLTest\\students.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
