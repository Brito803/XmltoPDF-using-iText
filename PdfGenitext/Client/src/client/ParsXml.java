package client;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileReader;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.commons.io.FileUtils;


public class ParsXml {
    static String fileName;
    static  Element eElement;

    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
    public static void main(String argv[]) {
        
        try {
            FileReader reader1=new FileReader("config.properties");  
                  
                Properties p=new Properties();  
                p.load(reader1);
            CandidateFile gen=new CandidateFile();
                File directoryPath = new File(p.getProperty("sourcefilepath"));
                      File filesList[] = directoryPath.listFiles();
             for(File src : filesList){ 
            
        File fXmlFile = src;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

      
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        
        NodeList nList = doc.getElementsByTagName("e:Application");


        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
          
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                               
                 eElement = (Element) nNode;
                NodeList cabnl = eElement.getElementsByTagName("e:Candidate");
                Node cabnlNode = cabnl.item(0);
                if (cabnlNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element em=(Element) cabnlNode;
                 if(p.getProperty("EmployeeNumberflag").equals("N")){
                     String datefull=eElement.getElementsByTagName("e:CreationDate").item(0).getTextContent();
                   SimpleDateFormat  inf = new SimpleDateFormat("yyyy-MM-dd");
                     Date date = inf.parse(datefull.substring(0, datefull.indexOf("T")));
                     SimpleDateFormat  outf = new SimpleDateFormat("yyyyMMdd");
                     //System.out.println(outf.format(date));
            fileName=p.getProperty("destfolderpath")+"\\"+eElement.getElementsByTagName("e:ContestNumber").item(0).getTextContent()+"_"+em.getElementsByTagName("e:LastName").item(0).getTextContent().replaceAll("[|\\\\//:?*\"<>]","").trim()+"_"+em.getElementsByTagName("e:FirstName").item(0).getTextContent().replaceAll("[|\\\\//:?*\"<>]","").trim()+"_"+em.getElementsByTagName("e:Number").item(0).getTextContent()+"_Employment Application"+"_"+outf.format(date)+".pdf";
                 }
                 if(p.getProperty("EmployeeNumberflag").equals("Y"))
                    fileName=p.getProperty("destfolderpath")+"\\"+eElement.getElementsByTagName("e:EmployeeNumber").item(0).getTextContent()+"_"+eElement.getElementsByTagName("e:ContestNumber").item(0).getTextContent()+"_Employment Application.pdf";
         
             gen.pdfgen();
                }
                
            }
}}
            
            } 
        
        catch (Exception e) {
        e.printStackTrace();
        }

      }
    

}
