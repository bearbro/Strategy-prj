import discount.DiscountStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Map;

public class CalculateJFrame extends JFrame implements ActionListener {
    JComboBox cbxProduct = new JComboBox();
    JComboBox cbxDiscount = new JComboBox();
    JButton calculate = new JButton("确定");
    JLabel priceLable = new JLabel();
    Map<String, Printer> printerList;
    Map<String, String> discountList;

    public void setPrinterList(Map<String, Printer> printerList) {
        this.printerList = printerList;
    }

    public void setDiscountList(Map<String, String> discountList) {
        this.discountList = discountList;
    }

    CalculateJFrame(String sTitle, Map<String, Printer> printerList, Map<String, String> discountList) {
        super(sTitle);
        this.printerList = printerList;
        this.discountList = discountList;
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.LEFT));
        c.add(new JLabel("产品类型"));
        c.add(cbxProduct);
        c.add(new JLabel("折扣"));
        c.add(cbxDiscount);
        c.add(calculate);
        c.add(priceLable);
        calculate.addActionListener(this);
        InitJCheckBox();
        setSize(300, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void InitJCheckBox() {
        for (String printerKey : printerList.keySet()) {
            cbxProduct.addItem(printerKey);
        }
        for (String discountKey : discountList.keySet()) {
            cbxDiscount.addItem(discountKey);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String printerKey = (String) cbxProduct.getSelectedItem();
        Printer printer = printerList.get(printerKey);
        String discountKey = (String) cbxDiscount.getSelectedItem();
        String discountName = (String) discountList.get(discountKey);

        DiscountStrategy discountStrategy = null;
        try {
            discountStrategy = (DiscountStrategy) Class.forName(discountName).newInstance();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        Calculatedprice calculatedprice = new Calculatedprice();
        calculatedprice.setDiscountStrategy(discountStrategy);
        double price = calculatedprice.getPrice(printer.getPrice());
        DecimalFormat df = new DecimalFormat("0.00");
        priceLable.setText("￥" + String.valueOf(df.format(price)));
    }
}
