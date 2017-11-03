

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXParserHandler extends DefaultHandler {
    /*注意DefaultHandler是org.xml.sax.helpers包下的*/
    Printer printer = null;
    String value = null;
    private ArrayList<Printer> PrinterList = new ArrayList<Printer>();//保存Printer对象

    public ArrayList<Printer> getPrinterList() {
        return PrinterList;
    }

    /**
     * 用来标识解析开始
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
//        System.out.println("SAX解析开始");
    }

    /**
     * 用来标识解析结束
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
//        System.out.println("SAX解析结束");
    }

    /**
     * 用来遍历xml文件的开始标签
     * 解析xml元素
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //调用DefaultHandler类的startElement方法
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("printer")) {
            //创建一个Printer对象
            printer = new Printer();
            //开始解析Printer元素的属性
//            System.out.println("======================开始遍历第"+"本书的内容=================");
           /* //❤已知节点的属性名时：比如已知id属性，根据属性名称获取属性值
            String value = attributes.getValue("id");
            System.out.print("Printer的属性值是："+value);*/
            //❤未知节点的属性名时，获取属性名和属性值
            int num = attributes.getLength();
            for (int i = 0; i < num; i++) {
                if (attributes.getQName(i).equals("id")) {//往Printer对象中塞值
                    //                   Printer.setId(attributes.getValue(i));
                }
            }
        }
    }

    /**
     * 用来遍历xml文件的结束标签
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //调用DefaultHandler类的endElement方法
        super.endElement(uri, localName, qName);
        //判断是否针对一本书已经遍历结束
        if (qName.equals("printer")) {
            PrinterList.add(printer);//在清空Printer对象之前先保存
            printer = null;//把Printer清空，方便解析下一个Printer节点
        } else if (qName.equals("brand")) {
//            System.out.println(value);
            printer.setBrand(value);
        } else if (qName.equals("version")) {
            printer.setVersion(value);
        } else if (qName.equals("price")) {
            printer.setPrice(Double.parseDouble(value));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        /**
         * ch 代表节点中的所有内容，即每次遇到一个标签调用characters方法时，数组ch实际都是整个XML文档的内容
         * 如何每次去调用characters方法时我们都可以获取不同的节点属性？这时就必须结合start（开始节点）和length（长度）
         */
        super.characters(ch, start, length);
        /*String */
        value = new String(ch, start, length);//value获取的是文本（开始和结束标签之间的文本）

    }
    /**
     * 获取文本
     * 重写charaters()方法时，
     * String(byte[] bytes,int offset,int length)的构造方法进行数组的传递
     * 去除解析时多余空格
     */

}