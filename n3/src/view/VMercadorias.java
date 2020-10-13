package view;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.CMercadoria;
import model.Mercadoria;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VMercadorias extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VNovaMercadoria novaMercadoria = new VNovaMercadoria();
	private JPanel contentPane;
	private JTable tableMercadorias;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMercadorias frame = new VMercadorias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	CMercadoria cmercadoria = new CMercadoria();
	List<Mercadoria>rows;
	JScrollPane barraRolagem;

	public VMercadorias() {
		
		rows = cmercadoria.queryMeradoria();
		String[] colunas = {"Tipo", "Descrição", "Peso", "", "Auditada"};
		Object[][] listamercadorias = new Object[cmercadoria.queryMeradoria().size()][5];
		
		int i = 0;
		
		for(Mercadoria mercadoria : cmercadoria.queryMeradoria()) {
			listamercadorias[i][0] = mercadoria.getTipo();
			listamercadorias[i][1] = mercadoria.getDescricao();
			listamercadorias[i][2] = mercadoria.getPeso();
			listamercadorias[i][3] = mercadoria.getUnPeso();
			if (mercadoria.getAuditada()){
				listamercadorias[i][4] = "Sim";
			}
			else {
				listamercadorias[i][4] = "Não";
			}
			i++;
			System.out.println(mercadoria.getDescricao());
		}
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 630);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNovaMercadoria = new JButton("Nova Mercadoria");
		btnNovaMercadoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaMercadoria.setVisible(true);
				novaMercadoria.setSize(634, 535);
			}
		});
		btnNovaMercadoria.setHorizontalAlignment(SwingConstants.LEFT);
		Image img = new ImageIcon (this.getClass().getResource("/addition-icon.png")).getImage();
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mercadorias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 20, 99, 20);
		contentPane.add(lblNewLabel);
		btnNovaMercadoria.setIcon(new ImageIcon(img));
		btnNovaMercadoria.setBackground(new Color(169, 169, 169));
		btnNovaMercadoria.setForeground(new Color(255, 255, 255));
		btnNovaMercadoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovaMercadoria.setBounds(665, 90, 185, 41);
		contentPane.add(btnNovaMercadoria);
		
		Image img1 = new ImageIcon (this.getClass().getResource("/arrow-back-icon.png")).getImage();
		btnVoltar.setIcon(new ImageIcon(img1));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBackground(new Color(65, 105, 225));
		btnVoltar.setBounds(709, 10, 141, 41);
		contentPane.add(btnVoltar);
		
		tableMercadorias = new JTable(listamercadorias, colunas);
		tableMercadorias.setSurrendersFocusOnKeystroke(true);
		tableMercadorias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableMercadorias.setBounds(36, 134, 784, 446);
		barraRolagem = new JScrollPane(tableMercadorias);
		barraRolagem.setEnabled(false);
		barraRolagem.setBounds(10, 142, 840, 438);
		contentPane.add(barraRolagem);
		
		
	}
}
