import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, SAXException, ParserConfigurationException {
        Map<String, Printer> printerList = new HashMap();
        Map<String, String> discountList = new HashMap();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        //创建SAXParserHandler对象
        SAXParserHandler handler = new SAXParserHandler();
        parser.parse("printers.xml", handler);
        for (Printer printer : handler.getPrinterList()) {
            printerList.put(printer.getBrand()+"|"+printer.getVersion()+"|"+printer.getPrice(),printer);
        }



        CalculateJFrame frame = new CalculateJFrame("计算", printerList, discountList);



    }

}
//C:\\Users\\bear\\Desktop\\printers.xml
//参考 http://www.cnblogs.com/Qian123/p/5231303.html#_label1