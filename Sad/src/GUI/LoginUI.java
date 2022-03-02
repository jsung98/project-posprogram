package GUI;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DAO.BakeryDAO;
import Vo.LoginVo;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;

public class LoginUI {
	private JFrame f;
	private JLabel Id, Pwd;
	private TextField tt1, tt2;
	private Label Ids, Pwds;
	private JButton b1;
	public BakeryDAO dao;

	public LoginUI() {

		dao = new BakeryDAO();

		f = new JFrame("Login");
		f.getContentPane().setFont(new Font("���� ���", Font.PLAIN, 12));
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setType(Type.UTILITY);
		f.getContentPane().setBackground(SystemColor.control);
		f.getContentPane().setForeground(Color.BLACK);
		f.setBounds(700, 300, 533, 320);
		f.getContentPane().setLayout(null);

		Id = new JLabel("ID   ");
		Id.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 12));
		Id.setBounds(66, 66, 23, 20);
		Pwd = new JLabel("Password");
		Pwd.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 12));
		Pwd.setBounds(50, 115, 70, 20);

		Ids = new Label("���̵� ã��");
		Ids.setFont(new Font("���� ���", Font.PLAIN, 12));
		Ids.setAlignment(Label.CENTER);
		Ids.setBounds(120, 200, 70, 20);
		Ids.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new IdsearchUI();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		Pwds = new Label("��й�ȣ ã��");
		Pwds.setFont(new Font("���� ���", Font.PLAIN, 12));
		Pwds.setAlignment(Label.CENTER);
		Pwds.setBounds(290, 200, 80, 20);
		Pwds.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PwdsearchUI();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		b1 = new JButton("Login");
		b1.setFont(new Font("Cambria", Font.BOLD, 12));
		b1.setBackground(SystemColor.inactiveCaption);
		b1.setForeground(Color.BLACK);
		b1.setBounds(400, 75, 70, 50);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tt1.getText().equals("")) {
					JOptionPane.showMessageDialog(f, "ID�� �Է����ּ���", "����", JOptionPane.WARNING_MESSAGE);
				} else if (tt2.getText().equals("")) {
					JOptionPane.showMessageDialog(f, "PWD�� �Է����ּ���", "����", JOptionPane.WARNING_MESSAGE);
				} else {
					ArrayList<LoginVo> loginlist = dao.loginlist(tt1.getText());
					if (loginlist.size() == 0) {
						JOptionPane.showMessageDialog(f, "ID �Ǵ� PWD�� �߸��Ǿ����ϴ�", "����", JOptionPane.WARNING_MESSAGE);
					} else {
						LoginVo Data = (LoginVo) loginlist.get(0);
						String spwd = Data.getPwd();
						if (tt2.getText().equals(spwd)) {							
							JOptionPane.showMessageDialog(null,  "�α��εǾ����ϴ�!");
							f.dispose();
							new StartUI();
						} else {
							JOptionPane.showMessageDialog(f, "ID �Ǵ� PWD�� �߸��Ǿ����ϴ�", "����", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});

		tt1 = new TextField(10);
		tt1.setBounds(120, 65, 250, 20);
		tt2 = new TextField(10);
		tt2.setBounds(120, 115, 250, 20);
		tt2.setEchoChar('*');

		f.getContentPane().add(Id);
		f.getContentPane().add(Pwd);
		f.getContentPane().add(tt1);
		f.getContentPane().add(tt2);
		f.getContentPane().add(Ids);
		f.getContentPane().add(Pwds);
		f.getContentPane().add(b1);
		f.setVisible(true);

	}

	public static void main(String[] args) {
		new LoginUI();
	}
}