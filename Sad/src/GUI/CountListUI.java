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

   Object countlist[] = { "제품", "개수", "금액" };
   private JFrame f;
   private JTable t;
   private JLabel l;
   private JButton b1;

   public CountListUI() {
      dao = new BakeryDAO();
      Data = dao.CountList();

      f = new JFrame("제품별 판매현황");
      f.getContentPane().setBackground(SystemColor.control);
      f.setFont(new Font("맑은 고딕", Font.BOLD, 12));
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
      l.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 15));
      l.setText("Today : " + Integer.toString(sum) + "원 입니다");
      l.setBounds(39, 226, 300, 38);
      
      b1 = new JButton("확인");
      b1.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
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