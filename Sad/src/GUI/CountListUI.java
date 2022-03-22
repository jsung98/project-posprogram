package GUI;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import DAO.BakeryDAO;
import Vo.BakeryVo;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dialog.ModalExclusionType;
import java.awt.SystemColor;

public class CountListUI {
   BakeryDAO dao = null;
   Vector<BakeryVo> Data = null;

   Object countlist[] = { "��ǰ", "����", "�ݾ�" };
   private JFrame f;
   private JTable t;
   private JLabel l;
   private JButton b1;

   public CountListUI() {
      dao = new BakeryDAO();
      Data = dao.CountList();

      f = new JFrame("��ǰ�� �Ǹ���Ȳ");
      f.getContentPane().setBackground(SystemColor.control);
      f.setFont(new Font("���� ���", Font.BOLD, 12));
      f.setBounds(1000, 300, 400, 350);
      f.getContentPane().setLayout(null);
      f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
      

      t = new JTable(dao.CountListArr(dao.CountList()), countlist);
      // t.setBounds(50, 20, 500, 200);

      JScrollPane scrollPane = new JScrollPane(t);
      scrollPane.setBounds(39, 24, 300, 170);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

      int sum = 0;
      for (int i = 0; i < Data.size(); i++) {
         sum += Data.get(i).getPrice2();
      }
      l = new JLabel();
      l.setFont(new Font("���� ��� Semilight", Font.BOLD, 15));
      l.setText("Today : " + Integer.toString(sum) + "�� �Դϴ�");
      l.setBounds(39, 226, 300, 38);
      
      b1 = new JButton("Ȯ��");
      b1.setFont(new Font("���� ���", Font.PLAIN, 12));
      b1.setBackground(SystemColor.inactiveCaption);
      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
         }
      });
      b1.setBounds(230, 220, 100, 50);

      f.getContentPane().add(l);
      f.getContentPane().add(scrollPane);
      f.getContentPane().add(b1);
      f.setVisible(true);

   }

   public static void main(String[] args) {
      new CountListUI();
   }
}