package GUI;

import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import DAO.BakeryDAO;
import Vo.BakeryVo;
import java.awt.SystemColor;
import java.awt.Font;

public class SellListUI {
   BakeryDAO dao = null;
   Vector<BakeryVo> Data = null;

   Object selllist[] = { "��ǰ", "����" };
   private JFrame f;
   private JButton b1, b2;
   private JTable t;

   public SellListUI() {

      dao = new BakeryDAO();
      Data = dao.SellList();

      f = new JFrame("�Ǹ���Ȳ");
      f.getContentPane().setBackground(SystemColor.control);
      f.setBounds(600, 300, 400, 350);
      f.getContentPane().setLayout(null);
      f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);

      t = new JTable(dao.SellListArr(dao.SellList()), selllist);
      // t.setBounds(40, 20, 500, 200);

      JScrollPane scrollPane = new JScrollPane(t);
      scrollPane.setBounds(40, 20, 300, 200);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

      b1 = new JButton("��ǰ�� �Ǹ���Ȳ");
      b1.setFont(new Font("���� ���", Font.PLAIN, 12));
      b1.setBackground(SystemColor.inactiveCaption);
      b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new CountListUI();
         }
      });
      b1.setBounds(50, 240, 130, 50);

      b2 = new JButton("Ȯ��");
      b2.setFont(new Font("���� ���", Font.PLAIN, 12));
      b2.setBackground(SystemColor.inactiveCaption);
      b2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
         }
      });
      b2.setBounds(200, 240, 130, 50);

      f.getContentPane().add(b1);
      f.getContentPane().add(b2);
      f.getContentPane().add(scrollPane);
      f.setVisible(true);

   }

   public static void main(String[] args) {
      new SellListUI();
   }
}