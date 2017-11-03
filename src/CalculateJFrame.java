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
    Map<String, Printer> printerMap;
    Map<String, DiscountStrategy> discountMap;

    public void setPrinterMap(Map<String, Printer> printerMap) {
        this.printerMap = printerMap;
    }

    public void setDiscountMap(Map<String, DiscountStrategy> discountMap) {
        this.discountMap = discountMap;
    }

    CalculateJFrame(String sTitle, Map<String, Printer> printerMap, Map<String, DiscountStrategy> discountMap) {
        super(sTitle);
        this.printerMap = printerMap;
        this.discountMap = discountMap;
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.LEFT));
        c.add(new JLabel("产品类型"));
        c.add(cbxProduct);
        c.add(new JLabel("折扣"));
        c.add(cbxDiscount);
        c.add(calculate);
        c.add(new JLabel("实际售价"));
        c.add(priceLable);
        calculate.addActionListener(this);
        InitJCheckBox();
        setSize(600, 60);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void InitJCheckBox() {
        for (String printerKey : printerMap.keySet()) {
            cbxProduct.addItem(printerKey);
        }
        for (String discountKey : discountMap.keySet()) {
            cbxDiscount.addItem(discountKey);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String printerKey = (String) cbxProduct.getSelectedItem();
        Printer printer = printerMap.get(printerKey);
        String discountKey = (String) cbxDiscount.getSelectedItem();
        DiscountStrategy discountStrategy = discountMap.get(discountKey);
        printer.setDiscountStrategy(discountStrategy);
        double price = printer.getdisPrice();
        DecimalFormat df = new DecimalFormat("0.00");
        priceLable.setText("￥" + String.valueOf(df.format(price)));
    }
}
