package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VVincularMercadoriaFrete extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VVincularMercadoriaFrete dialog = new VVincularMercadoriaFrete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VVincularMercadoriaFrete() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnVincular = new JButton("Sim");
			btnVincular.setForeground(new Color(255, 255, 255));
			btnVincular.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnVincular.setBackground(new Color(143, 188, 143));
			btnVincular.setBounds(122, 213, 89, 23);
			contentPanel.add(btnVincular);
		}
		{
			JButton btnNVincular = new JButton("N\u00E3o");
			btnNVincular.setForeground(new Color(255, 255, 255));
			btnNVincular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNVincular.setBackground(new Color(240, 128, 128));
			btnNVincular.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNVincular.setBounds(228, 213, 89, 23);
			contentPanel.add(btnNVincular);
		}
		{
			JLabel lblPergunta = new JLabel("Voc\u00EA deseja adicionar essa mercadoria a um fretamento?");
			lblPergunta.setVerticalAlignment(SwingConstants.BOTTOM);
			lblPergunta.setHorizontalAlignment(SwingConstants.CENTER);
			lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPergunta.setBounds(0, 162, 434, 23);
			contentPanel.add(lblPergunta);
		}
		{
			JLabel lblMercadoriaAdicionada = new JLabel("Mercadoria Adicionada com Sucesso!");
			lblMercadoriaAdicionada.setForeground(new Color(34, 139, 34));
			lblMercadoriaAdicionada.setHorizontalAlignment(SwingConstants.CENTER);
			lblMercadoriaAdicionada.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblMercadoriaAdicionada.setBounds(0, 117, 434, 44);
			contentPanel.add(lblMercadoriaAdicionada);
		}
		{
			JLabel lblIconSuccess = new JLabel("");
			lblIconSuccess.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconSuccess.setBounds(122, 23, 195, 100);
			Image img = new ImageIcon (this.getClass().getResource("/like-icon.png")).getImage();
			lblIconSuccess.setIcon(new ImageIcon(img));
			contentPanel.add(lblIconSuccess);
		}
	}

}
