package Tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Random;

// This class implements methods, that are used in program to ger some random values
// Al get methods should return String[], even if there is only one element
// All get methods should give complete requested info without any additional naming generation
// functionality outside EpicRandomizer

public class EpicRandomizer {
    public class incorrectLanguageException extends Exception {
        public incorrectLanguageException(String message) {
            super(message);
        }
    }

    public String[] getEngTxtbTtlAuthDeg() {
        String courseAuthor = "";
        String courseTitle = "";
        String courseDegree = "";
        String xmlFilePath = "src/main/java/DataFiles/Coursera.xml";
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("row");

            if (nodeList.getLength() > 0) {
                int randomIndex = new Random().nextInt(nodeList.getLength());
                Element row = (Element) nodeList.item(randomIndex);
                courseTitle = row.getElementsByTagName("course").item(0).getTextContent();
                courseAuthor = row.getElementsByTagName("university").item(0).getTextContent();
                courseDegree = row.getElementsByTagName("degree").item(0).getTextContent();
            } else {
                System.out.println("No rows found in the XML file.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] titleAuthorCombo = {courseTitle, courseAuthor, courseDegree};
        return titleAuthorCombo;
    }

    public String[] getRusTxtbTtl() {
        String courseTitle = "";
        String xmlFilePath = "src/main/java/DataFiles/RussianDepartments.xml";
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("row");

            if (nodeList.getLength() > 0) {
                int randomIndex = new Random().nextInt(nodeList.getLength());
                Element row = (Element) nodeList.item(randomIndex);
                courseTitle = row.getElementsByTagName("department").item(0).getTextContent();
                courseTitle += ". " + row.getElementsByTagName("type").item(0).getTextContent() + ".";
            } else {
                System.out.println("No rows found in the XML file.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] titleAuthorCombo = {courseTitle};
        return titleAuthorCombo;
    }

    // This method is common for both Eng and Rus literature, director tells which language is used
    public String[] getFicbTtlYaerGenre(String lang) {
        String bookTitle = "";
        String bookYear = "";
        String bookGenre = "";
        String xmlFilePath = "";
        try {
            if (lang.equals("ru")) {
                xmlFilePath = "src/main/java/DataFiles/RussianFictionBooks.xml";
            } else if (lang.equals("en")) {
                xmlFilePath = "src/main/java/DataFiles/EnglishFictionBooks.xml";
            } else {
                throw new incorrectLanguageException("no such language");
            }
        } catch (Exception incorrectLanguageException) {
            incorrectLanguageException.printStackTrace();
        }
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("row");

            if (nodeList.getLength() > 0) {
                int randomIndex = new Random().nextInt(nodeList.getLength());
                Element row = (Element) nodeList.item(randomIndex);
                bookTitle = row.getElementsByTagName("title").item(0).getTextContent();
                bookYear = row.getElementsByTagName("year").item(0).getTextContent();
                bookGenre = row.getElementsByTagName("genre").item(0).getTextContent();
            } else {
                System.out.println("No rows found in the XML file.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] titleYearGenre = {bookTitle, bookYear, bookGenre};
        return titleYearGenre;
    }
}
