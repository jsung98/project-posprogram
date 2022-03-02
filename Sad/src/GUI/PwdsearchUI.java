package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.BakeryDAO;
import Vo.PwdsearchVo;
import java.awt.Font;
import java.awt.SystemColor;

public class PwdsearchUI {
   private JFrame f;
   private JLabel lid, lnum;
   private JTextField id, prinum;
   private JButton b1, b2;
   public BakeryDAO dao;

   public PwdsearchUI() {

      dao = new BakeryDAO();

      f = new JFrame("PWD ã��");
      f.setBounds(750, 360, 400, 200);
      f.getContentPane().setLayout(null);
      f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);

      lid = new JLabel("ID");
      lid.setFont(new Font("���� ���", Font.PLAIN, 12));
      lid.setBounds(50, 20, 50, 20);
      lnum = new JLabel("�������(8�ڸ�)");
      lnum.setFont(new Font("���� ���", Font.PLAIN, 12));
      lnum.setBounds(50, 80, 100, 20);

      id = new JTextField(20);
      id.setBounds(50, 40, 120, 25);
      prinum = new JTextField(20);
      prinum.setBounds(50, 100, 120, 25);

      b1 = new JButton("ã��");
      b1.setBackground(SystemColor.inactiveCaption);
      b1.setFont(new Font("���� ���", Font.PLAIN, 12));
      b1.setBounds(250, 40, 70, 30);
      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (id.getText().equals("")) {
               JOptionPane.showMessageDialog(f, "ID�� �Է����ּ���", "����", JOptionPane.WARNING_MESSAGE);
            } else if (prinum.getText().equals("")) {
               JOptionPane.showMessageDialog(f, "��������� �Է����ּ���", "����", JOptionPane.WARNING_MESSAGE);
            } else {
               ArrayList<PwdsearchVo> pwdlist = dao.pwdlist(id.getText());
               if (pwdlist.size() == 0) {
                  JOptionPane.showMessageDialog(f, "ID �Ǵ� ��������� �߸��Ǿ����ϴ�", "����", JOptionPane.WARNING_MESSAGE);
               } else {
                  PwdsearchVo Data = (PwdsearchVo) pwdlist.get(0);
                  int snum = Data.getNum();
                  if (prinum.getText().equals(String.valueOf(snum))) {
                     JOptionPane.showMessageDialog(f, "PWD�� " + Data.getPwd() + " �Դϴ�", "Ȯ��",
                           JOptionPane.INFORMATION_MESSAGE);
                  } else {
                     JOptionPane.showMessageDialog(f, "ID �Ǵ� ��������� �߸��Ǿ����ϴ�", "����", JOptionPane.WARNING_MESSAGE);
                  }
               }
            }
         }
      });
      b2 = new JButton("Ȯ��");
      b2.setBackground(SystemColor.inactiveCaption);
      b2.setFont(new Font("���� ���", Font.PLAIN, 12));
      b2.setBounds(250, 85, 70, 30);
      b2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            f.dispose();
         }
      });

      f.getContentPane().add(lid);
      f.getContentPane().add(lnum);
      f.getContentPane().add(id);
      f.getContentPane().add(prinum);
      f.getContentPane().add(b1);
      f.getContentPane().add(b2);
      f.setVisible(true);

   }

   public static void main(String[] args) {
      new PwdsearchUI();
   }

}