package view;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VMenu extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	VMercadorias mercadorias = new VMercadorias();
	VFretes fretes = new VFretes();
	VInspencoes vinspencoes = new VInspencoes();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMenu frame = new VMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 630);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMercadorias = new JButton("Mercadorias");
		btnMercadorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mercadorias.setVisible(true);
				mercadorias.setSize(876, 630);
			}
		});
		btnMercadorias.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMercadorias.setForeground(new Color(255, 255, 255));
		btnMercadorias.setBackground(new Color(154, 205, 50));
		btnMercadorias.setBounds(46, 399, 232, 72);
		contentPane.add(btnMercadorias);
		
		JButton btnFretamento = new JButton("Fretamentos");
		btnFretamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fretes.setVisible(true);
				fretes.setSize(876, 721);
				
			}
		});
		btnFretamento.setForeground(new Color(255, 255, 255));
		btnFretamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFretamento.setBackground(new Color(218, 112, 214));
		btnFretamento.setBounds(317, 399, 232, 72);
		contentPane.add(btnFretamento);
		
		JButton inspencoes = new JButton("Inspen\u00E7\u00F5es");
		inspencoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vinspencoes.setVisible(true);
				vinspencoes.setSize(876, 630);
			}
		});
		inspencoes.setForeground(new Color(255, 255, 255));
		inspencoes.setFont(new Font("Tahoma", Font.BOLD, 14));
		inspencoes.setBackground(new Color(218, 165, 32));
		inspencoes.setBounds(589, 399, 232, 72);
		contentPane.add(inspencoes);
		
		JLabel lbIconMercad = new JLabel("");
		lbIconMercad.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon (this.getClass().getResource("/shopping-icon.png")).getImage();
		lbIconMercad.setIcon(new ImageIcon(img));
		lbIconMercad.setBounds(46, 249, 232, 139);
		contentPane.add(lbIconMercad);
		
		JLabel lbIconFretamento = new JLabel("");
		lbIconFretamento.setHorizontalAlignment(SwingConstants.CENTER);
		Image img1 = new ImageIcon (this.getClass().getResource("/settings-2-icon.png")).getImage();
		lbIconFretamento.setIcon(new ImageIcon(img1));
		lbIconFretamento.setBounds(317, 249, 232, 139);
		contentPane.add(lbIconFretamento);
		
		JLabel lbIconInspencoes = new JLabel("");
		lbIconInspencoes.setHorizontalAlignment(SwingConstants.CENTER);
		Image img2 = new ImageIcon (this.getClass().getResource("/warning-icon.png")).getImage();
		lbIconInspencoes.setIcon(new ImageIcon(img2));
		lbIconInspencoes.setBounds(589, 249, 232, 139);
		contentPane.add(lbIconInspencoes);
		
		JLabel lblNewLabel = new JLabel("Sistema de Fretamento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel.setBounds(144, 61, 544, 195);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de Fretamento");
		lblNewLabel_1.setForeground(new Color(199, 21, 133));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1.setBounds(142, 62, 544, 195);
		contentPane.add(lblNewLabel_1);
	}
}
