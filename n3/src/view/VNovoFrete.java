package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import BD.DbException;
import controller.CMercadoria;
import controller.service.CFDeamanda;
import controller.service.CFRegular;
import controller.service.CMAuditada;
import model.Mercadoria;
import model.service.FDemanda;
import model.service.FRegular;
import model.service.MAuditada;

import javax.swing.JComboBox;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Choice;

public class VNovoFrete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VNovoFrete frame = new VNovoFrete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String opcaofrete = null;
	private JTextField destino;
	private JTextField origem;
	private JTextField distancia;
	private JTextField frequencia;
	private JTextField dataColeta;
	private JTextField dataEntrega;
	
	List<Mercadoria>rows;
	List<MAuditada>arows;

	public VNovoFrete() {
		final CFRegular cfregular = new CFRegular();
		final CFDeamanda cfdemanda = new CFDeamanda();
		final CMercadoria cmercadoria = new CMercadoria();
		final CMAuditada cmauditada = new CMAuditada();
		rows = cmercadoria.queryMeradoria();
		arows = cmauditada.queryMeradoriaAuditada();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 447);
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
		btnVoltar.setBounds(576, 11, 137, 42);
		contentPane.add(btnVoltar);
		
		JLabel lblAdicionarfrete = new JLabel("Adicionar Fretamento");
		lblAdicionarfrete.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdicionarfrete.setBounds(10, 11, 556, 42);
		contentPane.add(lblAdicionarfrete);
		
		JLabel lblTipoDeFrete = new JLabel("Tipo de Frete");
		lblTipoDeFrete.setBounds(67, 95, 213, 14);
		contentPane.add(lblTipoDeFrete);
		
		JLabel lblMercadoria = new JLabel("Mercadoria");
		lblMercadoria.setBounds(386, 96, 213, 14);
		contentPane.add(lblMercadoria);
		
		Vector<String> names = new Vector<String>();
		Iterator<Mercadoria> list = rows.iterator();
		Iterator<MAuditada> alist = arows.iterator();
		
		while (list.hasNext()) {
			Mercadoria e = list.next();
			String getMercadoria = e.getDescricao();
			names.addElement(getMercadoria);
		}
		
		
		while (alist.hasNext()) {
			MAuditada j = alist.next();
			String getMAuditada = j.getDescricao();
			names.addElement(getMAuditada);
		}
		
		final JComboBox<String> listaMercadorias = new JComboBox<String>(names);
		listaMercadorias.setBounds(386, 112, 279, 22);
		contentPane.add(listaMercadorias);

		
		JLabel lblDescrio = new JLabel("Origem");
		lblDescrio.setBounds(67, 146, 279, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblDescrio_1 = new JLabel("Destino");
		lblDescrio_1.setBounds(386, 146, 279, 14);
		contentPane.add(lblDescrio_1);
		
		destino = new JTextField();
		destino.setColumns(10);
		destino.setBounds(386, 165, 279, 23);
		contentPane.add(destino);
		
		origem = new JTextField();
		origem.setColumns(10);
		origem.setBounds(67, 165, 279, 23);
		contentPane.add(origem);
		
		JLabel lblDistanciaEmKm = new JLabel("Distancia em KM");
		lblDistanciaEmKm.setBounds(67, 199, 279, 14);
		contentPane.add(lblDistanciaEmKm);
		
		distancia = new JTextField();
		distancia.setColumns(10);
		distancia.setBounds(67, 218, 279, 23);
		contentPane.add(distancia);
		
		JLabel lblDataColeta = new JLabel("Data Coleta");
		lblDataColeta.setBounds(386, 224, 102, 14);
		contentPane.add(lblDataColeta);
		
		JLabel lblPrevisoDeEntrega = new JLabel("Previs\u00E3o de Entrega");
		lblPrevisoDeEntrega.setBounds(533, 224, 123, 14);
		contentPane.add(lblPrevisoDeEntrega);
		
		
		MaskFormatter dateMask;
		try {
		    dateMask = new MaskFormatter("##/##/####");
		    //dateMask.setPlaceholderCharacter('/');
		    dateMask.setValidCharacters("0123456789");
		    
		    dataEntrega = new JFormattedTextField(dateMask);
		    dataEntrega.setEditable(false);
		    dataEntrega.setEnabled(false);
		    dataEntrega.setHorizontalAlignment(JTextField.RIGHT);
		    dataEntrega.setColumns(10);
		    dataEntrega.setBackground(Color.WHITE);
		    dataEntrega.setBounds(533, 243, 132, 23);
			contentPane.add(dataEntrega);
		    
		    dataColeta = new JFormattedTextField(dateMask);
		    dataColeta.setEditable(false);
		    dataColeta.setEnabled(false);
		    dataColeta.setHorizontalAlignment(JTextField.RIGHT);
		    dataColeta.setColumns(10);
		    dataColeta.setBackground(Color.WHITE);
		    dataColeta.setBounds(386, 243, 132, 23);
			contentPane.add(dataColeta);
			
		} catch (ParseException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		
		
		JLabel lblQuantidadeDeOperaes = new JLabel("Qntd. de Opera\u00E7\u00F5es");
		lblQuantidadeDeOperaes.setBounds(67, 282, 132, 14);
		contentPane.add(lblQuantidadeDeOperaes);
		
		JFormattedTextField quantidade = new JFormattedTextField((Object) null);
		quantidade.setEditable(false);
		quantidade.setEnabled(false);
		quantidade.setColumns(10);
		quantidade.setBackground(Color.WHITE);
		quantidade.setBounds(67, 301, 132, 23);
		contentPane.add(quantidade);
		
		JLabel lblFrequncia = new JLabel("Frequ\u00EAncia");
		lblFrequncia.setBounds(209, 282, 102, 14);
		contentPane.add(lblFrequncia);
		
		Choice unFrequencia = new Choice();
		unFrequencia.setEnabled(false);
		unFrequencia.setBounds(268, 301, 78, 20);
		unFrequencia.add("Semanal");
		unFrequencia.add("Mensal");
		unFrequencia.add("Semestral");
		unFrequencia.add("Anual");
		contentPane.add(unFrequencia);
		
		frequencia = new JTextField();
		frequencia.setEnabled(false);
		frequencia.setEditable(false);
		frequencia.setColumns(10);
		frequencia.setBackground(Color.WHITE);
		frequencia.setBounds(209, 301, 58, 23);
		contentPane.add(frequencia);
		
		JToggleButton fRegular = new JToggleButton("Regular");
		JToggleButton fDemanda = new JToggleButton("Sob Demanda");	
		fRegular.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					fDemanda.setSelected(false);
					dataEntrega.setEditable(false);
				    dataEntrega.setEnabled(false);
				    dataColeta.setEditable(false);
				    dataColeta.setEnabled(false);
					opcaofrete = "fregular";
					quantidade.setEditable(true);
					quantidade.setEnabled(true);
					unFrequencia.setEnabled(true);
					frequencia.setEnabled(true);
					frequencia.setEditable(true);
			      }
			}
		});
		
		fDemanda.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					fRegular.setSelected(false);
					quantidade.setEditable(false);
					quantidade.setEnabled(false);
					unFrequencia.setEnabled(false);
					frequencia.setEnabled(false);
					frequencia.setEditable(false);
					opcaofrete = "fdemanda";
					dataEntrega.setEditable(true);
				    dataEntrega.setEnabled(true);
				    dataColeta.setEditable(true);
				    dataColeta.setEnabled(true);
					
			      }
			}
		});
		fRegular.setBounds(67, 112, 137, 23);
		contentPane.add(fRegular);
		
		
		fDemanda.setBounds(209, 112, 137, 23);
		contentPane.add(fDemanda);
		
		JLabel lblNewLabel = new JLabel("Fretes Regulares:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(67, 257, 184, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFretesSobDemanda = new JLabel("Fretes Sob Demanda:");
		lblFretesSobDemanda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFretesSobDemanda.setBounds(386, 199, 184, 14);
		contentPane.add(lblFretesSobDemanda);
		
		JButton btnAddMercadoria = new JButton("Salvar");
		
		btnAddMercadoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (opcaofrete == "fregular") {

					Integer idFrete = 0;
					String preco = "0";
					FRegular fregular = new FRegular(idFrete.intValue(), opcaofrete.toString(), origem.getText(), destino.getText(), Double.parseDouble(distancia.getText()), Integer.parseInt(quantidade.getText()), 
							Integer.parseInt(frequencia.getText()), unFrequencia.getSelectedItem(), listaMercadorias.getSelectedItem().toString(), Double.parseDouble(preco));
				     
				     try {
				    	 cfregular.nova(fregular);
							
				     	} catch (DbException | SQLException exp) {
							System.out.println( exp.getMessage());
						}
				     
				     
				} else {
					Integer idFrete = 0;
					String preco = "0";
					FDemanda fdemanda = new FDemanda(idFrete.intValue(), opcaofrete.toString(), origem.getText(), destino.getText(), Double.parseDouble(distancia.getText()), 
							dataColeta.getText(), dataEntrega.getText(),listaMercadorias.getSelectedItem().toString(), Double.parseDouble(preco));
					
					try {
						cfdemanda.nova(fdemanda);
							
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
		btnAddMercadoria.setBounds(304, 349, 119, 33);
		contentPane.add(btnAddMercadoria);
		
	}

}
