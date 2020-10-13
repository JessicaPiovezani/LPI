package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.service.CFDeamanda;
import controller.service.CFRegular;
import model.service.FDemanda;
import model.service.FRegular;


public class VFretes extends JFrame {
	
	VNovoFrete novofrete = new VNovoFrete();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableFDemanda;
	private JTable tableFRegular;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VFretes frame = new VFretes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	CFDeamanda cfdemanda = new CFDeamanda();
	CFRegular cfregular = new CFRegular();
	List<FRegular> rows1;
	List<FDemanda> rows;
	JScrollPane barraRolagem;
	private JScrollPane barraRolagem_1;
	private JLabel lblFretesSob;
	private JLabel lblNewLabel_2;
	public VFretes() {
		
		rows = cfdemanda.queryFdemanda();
		String[] colunas = {"Mercadoria","Origem", "Destino", "Valor"};
		Object[][] listademanda = new Object[cfdemanda.queryFdemanda().size()][4];
		
		int i = 0;
		
		for(FDemanda cfdemanda : cfdemanda.queryFdemanda()) {
			listademanda[i][0] = cfdemanda.getMercadoria();
			listademanda[i][1] = cfdemanda.getOrigem();
			listademanda[i][2] = cfdemanda.getDestino();
			listademanda[i][3] = cfdemanda.getPreco();
			i++;

		}
		
		rows1 = cfregular.queryFregular();
		Object[][] listaregular = new Object[cfregular.queryFregular().size()][4];
		
		int j = 0;
		
		for(FRegular cfregular : cfregular.queryFregular()) {
			listaregular[j][0] = cfregular.getMercadoria();
			listaregular[j][1] = cfregular.getOrigem();
			listaregular[j][2] = cfregular.getDestino();
			listaregular[j][3] = cfregular.getPreco();
			j++;
		}
		
		
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 721);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNovoFrete = new JButton("Novo Fretamento");
		btnNovoFrete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novofrete.setVisible(true);
				novofrete.setSize(739, 447);
			}
		});
		btnNovoFrete.setHorizontalAlignment(SwingConstants.LEFT);
		Image img = new ImageIcon (this.getClass().getResource("/addition-icon.png")).getImage();
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fretes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 20, 99, 20);
		contentPane.add(lblNewLabel);
		btnNovoFrete.setIcon(new ImageIcon(img));
		btnNovoFrete.setBackground(new Color(169, 169, 169));
		btnNovoFrete.setForeground(new Color(255, 255, 255));
		btnNovoFrete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNovoFrete.setBounds(623, 62, 227, 41);
		
		contentPane.add(btnNovoFrete);
		
		Image img1 = new ImageIcon (this.getClass().getResource("/arrow-back-icon.png")).getImage();
		btnVoltar.setIcon(new ImageIcon(img1));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBackground(new Color(65, 105, 225));
		btnVoltar.setBounds(709, 10, 141, 41);
		contentPane.add(btnVoltar);
		
		tableFDemanda = new JTable(listademanda, colunas);
		tableFDemanda.setSurrendersFocusOnKeystroke(true);
		tableFDemanda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableFDemanda.setBounds(36, 134, 784, 446);
		barraRolagem = new JScrollPane(tableFDemanda);
		barraRolagem.setEnabled(false);
		barraRolagem.setBounds(10, 422, 840, 235);
		contentPane.add(barraRolagem);
		
		tableFRegular = new JTable(listaregular, colunas);
		tableFRegular.setSurrendersFocusOnKeystroke(true);
		tableFRegular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableFRegular.setBounds(36, 134, 784, 446);
		barraRolagem_1 = new JScrollPane(tableFRegular);
		barraRolagem_1.setEnabled(false);
		barraRolagem_1.setBounds(10, 142, 840, 235);
		contentPane.add(barraRolagem_1);
		
		lblFretesSob = new JLabel("Fretes Sob Demanda");
		lblFretesSob.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFretesSob.setBounds(10, 391, 232, 20);
		contentPane.add(lblFretesSob);
		
		lblNewLabel_2 = new JLabel("Fretes Regulares");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 111, 232, 20);
		contentPane.add(lblNewLabel_2);
		
		
	}

}
