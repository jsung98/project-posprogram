package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class StartUI {
	private JFrame f;
	private JButton b1, b2, b3;

	public StartUI() {
		f = new JFrame("StartUI");
		f.getContentPane().setBackground(new Color(204, 255, 255));
		f.setBounds(600, 150, 700, 700);
		f.getContentPane().setLayout(null);

		b1 = new JButton("\uD310\uB9E4");
		b1.setBackground(new Color(255, 204, 204));
		b1.setFont(new Font("���� ���", Font.PLAIN, 50));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainUI();
				f.dispose();
			}
		});
		b1.setBounds(86, 136, 200, 300);
		b2 = new JButton("����");
		b2.setBackground(new Color(255, 204, 204));
		b2.setFont(new Font("���� ���", Font.PLAIN, 50));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new SettingUI();
			}
		});
		b2.setBounds(400, 136, 200, 300);

		b3 = new JButton("�α׾ƿ�");
		b3.setBackground(SystemColor.activeCaption);
		b3.setFont(new Font("���� ���", Font.BOLD, 20));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new LoginUI();
			}
		});
		b3.setBounds(245, 529, 170, 100);

		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		f.getContentPane().add(b3);
		f.setVisible(true);

	}

	public static void main(String[] args) {
		new StartUI();
	}
}