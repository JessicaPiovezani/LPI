package view;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


import BD.DbException;
import controller.CCategoria;
import controller.CMercadoria;
import controller.service.CMAuditada;
import model.Categoria;
import model.Mercadoria;
import model.service.MAuditada;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;


public class VNovaMercadoria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField descricaoMercadoria;
	private JTextField peso;
	VNovaCategoria novaMercadoria = new VNovaCategoria();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VNovaMercadoria frame = new VNovaMercadoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Boolean audita = false;
	Integer idmercadoria = 0;
	List<Categoria>rows;
	private JTextField data;
	private JTextField nomeorgao;
	
	public VNovaMercadoria() {
		final CMercadoria cmercadoria = new CMercadoria();
		final CMAuditada cmauditada = new CMAuditada();
		final CCategoria ccategoria = new CCategoria();
		rows = ccategoria.queryCategoria();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 470);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Image img = new ImageIcon (this.getClass().getResource("/arrow-back-icon.png")).getImage();
		btnVoltar.setIcon(new ImageIcon(img));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBackground(new Color(65, 105, 225));
		btnVoltar.setBounds(471, 11, 137, 42);
		contentPane.add(btnVoltar);
		
		JLabel lblAdicionarMercadoria = new JLabel("Adicionar Mercadoria");
		lblAdicionarMercadoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdicionarMercadoria.setBounds(10, 11, 461, 42);
		contentPane.add(lblAdicionarMercadoria);
		
		
		JLabel lblNewLabel = new JLabel("Categoria de Mercadoria");
		lblNewLabel.setBounds(98, 112, 213, 14);
		contentPane.add(lblNewLabel);
		
		Vector<String> names = new Vector<String>();
		Iterator<Categoria> list = rows.iterator();
		
		while (list.hasNext()) {
			Categoria e = list.next();
			String getCategoriaName = e.getCategoriaName();
			names.addElement(getCategoriaName);
		}
		
		final JComboBox<String> listaCategoria = new JComboBox<String>(names);
		listaCategoria.setBounds(98, 132, 279, 22);
		contentPane.add(listaCategoria);
		
		JButton btnNovaCategoria = new JButton("Nova Categoria");
		btnNovaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaMercadoria.setVisible(true);
				novaMercadoria.setSize(450, 229);
			}
		});
		btnNovaCategoria.setBounds(379, 132, 131, 23);
		contentPane.add(btnNovaCategoria);
		
		descricaoMercadoria = new JTextField();
		descricaoMercadoria.setBounds(98, 191, 412, 23);
		contentPane.add(descricaoMercadoria);
		descricaoMercadoria.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(98, 172, 213, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(98, 237, 102, 14);
		contentPane.add(lblPeso);
		
		peso = new JTextField();
		peso.setBackground(new Color(255, 255, 255));
		peso.setColumns(10);
		peso.setBounds(98, 256, 111, 23);
		contentPane.add(peso);
		
		Choice unPeso = new Choice();
		unPeso.setBounds(209, 257, 78, 20);
		unPeso.add("Kg");
		unPeso.add("g");
		unPeso.add("t");
		contentPane.add(unPeso);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(210, 237, 102, 14);
		contentPane.add(lblUnidade);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(98, 299, 102, 14);
		contentPane.add(lblData);
		
		

		
		MaskFormatter dateMask;
		try {
		    dateMask = new MaskFormatter("##/##/####");
		    //dateMask.setPlaceholderCharacter('/');
		    dateMask.setValidCharacters("0123456789");
		    
		    data = new JFormattedTextField(dateMask);
		    data.setHorizontalAlignment(JTextField.RIGHT);
			data.setEditable(false);
			data.setEnabled(false);
			data.setColumns(10);
			data.setBackground(Color.WHITE);
			data.setBounds(98, 318, 111, 23);
			contentPane.add(data);
			
		} catch (ParseException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		
		
		JLabel lblOrgoIspetor = new JLabel("\u00D3rg\u00E3o inspetor");
		lblOrgoIspetor.setBounds(252, 299, 258, 14);
		contentPane.add(lblOrgoIspetor);
		
		nomeorgao = new JTextField();
		nomeorgao.setEditable(false);
		nomeorgao.setEnabled(false);
		nomeorgao.setColumns(10);
		nomeorgao.setBackground(Color.WHITE);
		nomeorgao.setBounds(252, 318, 258, 23);
		contentPane.add(nomeorgao);
		
		JToggleButton mAuditada = new JToggleButton("Sim");
		JToggleButton mNormal = new JToggleButton("N\u00E3o");	
		mAuditada.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					mNormal.setSelected(false);
					audita = true;
					nomeorgao.setEditable(true);
					nomeorgao.setEnabled(true);
					data.setEditable(true);
					data.setEnabled(true);
			      }
			}
		});
		
		mNormal.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					mAuditada.setSelected(false);
					audita = false;
					nomeorgao.setEditable(false);
					nomeorgao.setEnabled(false);
					data.setEditable(false);
					data.setEnabled(false);
			      }
			}
		});
		
		
		
		mAuditada.setBounds(312, 256, 102, 23);
		contentPane.add(mAuditada);
		
		
		mNormal.setBounds(408, 256, 102, 23);
		contentPane.add(mNormal);
		
		JLabel lblAuditado = new JLabel("Mercadoria Auditada?");
		lblAuditado.setBounds(312, 237, 195, 14);
		contentPane.add(lblAuditado);
		
		JButton btnAddMercadoria = new JButton("Salvar");
		
		btnAddMercadoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (audita) {

					MAuditada mauditada = new MAuditada(idmercadoria.intValue(), listaCategoria.getSelectedItem().toString(), descricaoMercadoria.getText(), 
							unPeso.getSelectedItem(), Float.parseFloat(peso.getText()),audita.booleanValue(), data.getText(), nomeorgao.getText());
				     
				     try {
				    	 cmauditada.nova(mauditada);
							
				     	} catch (DbException | SQLException exp) {
							System.out.println( exp.getMessage());
						}
				     
				     
				} else {
					Mercadoria mercadoria = new Mercadoria(idmercadoria.intValue(), listaCategoria.getSelectedItem().toString(), descricaoMercadoria.getText(), 
							unPeso.getSelectedItem(), Float.parseFloat(peso.getText()),audita.booleanValue());
					
					try {
						cmercadoria.nova(mercadoria);
							
				     	} catch (DbException | SQLException exp) {
							System.out.println( exp.getMessage());
						}
				}
			}
		});
		
		
		btnAddMercadoria.setBackground(new Color(46, 139, 87));
		btnAddMercadoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddMercadoria.setForeground(Color.WHITE);
		Image img1 = new ImageIcon (this.getClass().getResource("/check-1-icon-small.png")).getImage();
		btnAddMercadoria.setIcon(new ImageIcon(img1));
		btnAddMercadoria.setBounds(258, 363, 119, 33);
		contentPane.add(btnAddMercadoria);
		
		
		
	}
}
