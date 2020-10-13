package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.DbException;
import controller.CCategoria;
import model.Categoria;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VNovaCategoria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField categorianame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VNovaCategoria frame = new VNovaCategoria();
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
	Integer idcategoria = 0;
	
	public VNovaCategoria() {
		final CCategoria ccategoria = new CCategoria();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 229);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		categorianame = new JTextField();
		categorianame.setColumns(10);
		categorianame.setBackground(Color.WHITE);
		categorianame.setBounds(57, 81, 329, 23);
		contentPane.add(categorianame);
		
		JButton btnAddCategoria = new JButton("Salvar");
		btnAddCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categoria categoria = new Categoria(idcategoria.intValue(),categorianame.getText());
				try {
			    	 ccategoria.nova(categoria);
			    	 ccategoria.queryCategoria();
			    	 dispose();
						
				} 
				catch (DbException | SQLException exp) {
						System.out.println( exp.getMessage());
				}
						
			}
		});
		btnAddCategoria.setForeground(Color.WHITE);
		btnAddCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		Image img1 = new ImageIcon (this.getClass().getResource("/check-1-icon-small.png")).getImage();
		btnAddCategoria.setIcon(new ImageIcon(img1));
		btnAddCategoria.setBackground(new Color(46, 139, 87));
		btnAddCategoria.setBounds(157, 128, 119, 33);
		contentPane.add(btnAddCategoria);
		
		
		
		JLabel lblNomeDaCategoria = new JLabel("Nome da Categoria");
		lblNomeDaCategoria.setBounds(57, 62, 329, 14);
		contentPane.add(lblNomeDaCategoria);
		
		JLabel lblAdicionarCategoria = new JLabel("Adicionar Categoria");
		lblAdicionarCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdicionarCategoria.setBounds(10, 11, 298, 33);
		contentPane.add(lblAdicionarCategoria);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		Image img = new ImageIcon (this.getClass().getResource("/arrow-back-icon-small.png")).getImage();
		btnVoltar.setIcon(new ImageIcon(img));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBackground(new Color(65, 105, 225));
		btnVoltar.setBounds(305, 11, 119, 33);
		contentPane.add(btnVoltar);
	}

}
