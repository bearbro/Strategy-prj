import discount.DiscountStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, SAXException, ParserConfigurationException {
        Map<String, Printer> printerMap = new HashMap<>();
        Map<String, DiscountStrategy> discountMap = new HashMap<>();

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        DiscountStrategy discountStrategy;

        String[] strategyNames = context.getBeanNamesForType(DiscountStrategy.class);
        for (String strategyName : strategyNames) {
            discountStrategy = (DiscountStrategy) context.getBean(strategyName);
            discountMap.put(discountStrategy.getName(), discountStrategy);
        }
        Printer printer;
        String[] printerNames = context.getBeanNamesForType(Printer.class);
        for (String printerName : printerNames) {
            printer = (Printer) context.getBean(printerName);
            printerMap.put(printer.getBrand()+"|"+printer.getVersion()+"| ￥"+printer.getPrice(), printer);
        }

        CalculateJFrame frame = new CalculateJFrame("计算", printerMap, discountMap);


    }

}
//C:\\Users\\bear\\Desktop\\printers.xml
//参考 http://www.cnblogs.com/Qian123/p/5231303.html#_label1