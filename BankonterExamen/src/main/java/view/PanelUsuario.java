package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import controller.UsuarioControlador;
import model.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PanelUsuario extends JPanel {
	private JTextField jtfId;
	private JTextField jtfUsuario;
	private JTextField jtfEmail;
	private JPasswordField passContraseña;
	private Usuario usuario;
	JComboBox<String> jcbColorPreferido;
	
	
	public PanelUsuario(Usuario usuario) {
		setBackground(new Color(136, 138, 133));
		this.usuario = usuario;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestionDeUsuarios = new JLabel("Gestion De Usuarios");
		GridBagConstraints gbc_lblGestionDeUsuarios = new GridBagConstraints();
		gbc_lblGestionDeUsuarios.gridwidth = 2;
		gbc_lblGestionDeUsuarios.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestionDeUsuarios.gridx = 0;
		gbc_lblGestionDeUsuarios.gridy = 0;
		add(lblGestionDeUsuarios, gbc_lblGestionDeUsuarios);
		
		JLabel lblId = new JLabel("ID :");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		jtfId.setEditable(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario : ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 2;
		add(lblUsuario, gbc_lblUsuario);
		
		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 2;
		add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 3;
		add(lblContrasea, gbc_lblContrasea);
		
		passContraseña = new JPasswordField();
		GridBagConstraints gbc_passContraseña = new GridBagConstraints();
		gbc_passContraseña.insets = new Insets(0, 0, 5, 0);
		gbc_passContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_passContraseña.gridx = 1;
		gbc_passContraseña.gridy = 3;
		add(passContraseña, gbc_passContraseña);
		
		JLabel lblEmail = new JLabel("Email :");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 4;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblColorPreferido = new JLabel("Color Preferido:");
		GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
		gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
		gbc_lblColorPreferido.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorPreferido.gridx = 0;
		gbc_lblColorPreferido.gridy = 5;
		add(lblColorPreferido, gbc_lblColorPreferido);
		
		jcbColorPreferido = new JComboBox();
		GridBagConstraints gbc_jcbColorPreferido = new GridBagConstraints();
		gbc_jcbColorPreferido.insets = new Insets(0, 0, 5, 0);
		gbc_jcbColorPreferido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbColorPreferido.gridx = 1;
		gbc_jcbColorPreferido.gridy = 5;
		add(jcbColorPreferido, gbc_jcbColorPreferido);
		jcbColorPreferido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarcolor();
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 6;
		add(btnGuardar, gbc_btnGuardar);
		
		cargarColoresPreferidos();
		cargarDatosUsuario();
		
	}
	
	private void cargarColoresPreferidos() {
		this.jcbColorPreferido.removeAllItems();
		List<String> colores = new ArrayList<String>();
		colores.add("#FF00FF");
		colores.add("#9890A5");
		colores.add("#765456");
		colores.add("#879876");
		for (String color : colores) {
			this.jcbColorPreferido.addItem(color);
		}
	}
	/**
	 * 
	 */
	private void cargarDatosUsuario() {
		this.jtfId.setText("" + usuario.getId());
		this.jtfUsuario.setText( usuario.getNombreUsuario());
		this.passContraseña.setText( usuario.getPassword());
		this.jtfEmail.setText(usuario.getEmail());
		
		for (int i = 0; i < this.jcbColorPreferido.getItemCount(); i++) {
			if (this.jcbColorPreferido.getItemAt(i).equals(this.usuario.getColorPreferido())) {
				this.jcbColorPreferido.setSelectedIndex(i);
			}
		}
		
	}
	/**
	 * 
	 */
	private void guardar() {
		try {
			this.usuario.setNombreUsuario(this.jtfUsuario.getText());
			this.usuario.setColorPreferido((String)this.jcbColorPreferido.getSelectedItem());
			this.usuario.setPassword(this.passContraseña.getText());
			this.usuario.setEmail(this.jtfEmail.getText());
			
			if (this.jtfUsuario.getText().matches(" ")) {
				throw new Exception ("El usuario no puede estar vacio");
			}
			
			if (this.passContraseña.getText().matches(" ")) {
				throw new Exception ("La contraseña no puede estar en blanco");
			}
			
			
			UsuarioControlador.modificar(this.usuario);
			JOptionPane.showMessageDialog(null, "Guardado correctamente");
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
		}
	}
	private void cambiarcolor() {
		if (this.jcbColorPreferido.getSelectedIndex()==1) {
			setBackground(Color.decode("#FF00FF"));
		}
		if (this.jcbColorPreferido.getSelectedIndex()==2) {
			setBackground(Color.decode("#9890A5"));
		}
		if (this.jcbColorPreferido.getSelectedIndex()==3) {
			setBackground(Color.decode("#765456"));
		}
		if (this.jcbColorPreferido.getSelectedIndex()==4) {
			setBackground(Color.decode("#879876"));
		}
	}

}
