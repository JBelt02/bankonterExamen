package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JToolBar;

import controller.ContratoControlador;
import controller.TipocontratoControlador;
import controller.UsuarioControlador;
import model.Contrato;
import model.Tipocontrato;
import model.Usuario;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField jtfFecha;
	JComboBox<Usuario> jcbUsuario;
	JRadioButton radioCuentaBancaria;
	JRadioButton radioTarjetaDebito;
	JRadioButton radioTarjetaCredito;
	JRadioButton radioPrestamo;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public VentanaPrincipal() {
		setResizable(false);
		setBounds(100, 100, 450, 330);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		  
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.gridwidth = 3;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		getContentPane().add(toolBar, gbc_toolBar);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarContratoEnPantalla(controller.ContratoControlador.findFirst());
			}
		});
		btnPrimero.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/view/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarContratoEnPantalla(controller.ContratoControlador.findPrevious(Integer.parseInt(jtfId.getText())));
			}
		});
		btnAnterior.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/view/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarContratoEnPantalla(controller.ContratoControlador.findNext(Integer.parseInt(jtfId.getText())));
			}
		});
		btnSiguiente.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/view/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarContratoEnPantalla(controller.ContratoControlador.findLast());
			}
		});
		btnUltimo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/view/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		btnNuevo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/view/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/view/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/view/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JLabel lblGestionDeContratos = new JLabel("Gestion De contratos");
		GridBagConstraints gbc_lblGestionDeContratos = new GridBagConstraints();
		gbc_lblGestionDeContratos.gridwidth = 3;
		gbc_lblGestionDeContratos.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestionDeContratos.gridx = 0;
		gbc_lblGestionDeContratos.gridy = 1;
		getContentPane().add(lblGestionDeContratos, gbc_lblGestionDeContratos);
		
		JLabel lblNewLabel = new JLabel("Id : ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEditable(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 2;
		getContentPane().add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato: ");
		GridBagConstraints gbc_lblTipoDeContrato = new GridBagConstraints();
		gbc_lblTipoDeContrato.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeContrato.gridx = 0;
		gbc_lblTipoDeContrato.gridy = 3;
		getContentPane().add(lblTipoDeContrato, gbc_lblTipoDeContrato);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		radioCuentaBancaria = new JRadioButton("Cuenta Bancaria");
		GridBagConstraints gbc_radioCuentaBancaria = new GridBagConstraints();
		gbc_radioCuentaBancaria.insets = new Insets(0, 0, 5, 5);
		gbc_radioCuentaBancaria.gridx = 0;
		gbc_radioCuentaBancaria.gridy = 0;
		panel.add(radioCuentaBancaria, gbc_radioCuentaBancaria);
		
		radioTarjetaDebito = new JRadioButton("Tarjeta Debito");
		GridBagConstraints gbc_radioTarjetaDebito = new GridBagConstraints();
		gbc_radioTarjetaDebito.insets = new Insets(0, 0, 5, 5);
		gbc_radioTarjetaDebito.gridx = 0;
		gbc_radioTarjetaDebito.gridy = 1;
		panel.add(radioTarjetaDebito, gbc_radioTarjetaDebito);
		
		radioTarjetaCredito = new JRadioButton("Tarjeta Credito");
		GridBagConstraints gbc_radioTarjetaCredito = new GridBagConstraints();
		gbc_radioTarjetaCredito.insets = new Insets(0, 0, 5, 5);
		gbc_radioTarjetaCredito.gridx = 0;
		gbc_radioTarjetaCredito.gridy = 2;
		panel.add(radioTarjetaCredito, gbc_radioTarjetaCredito);
		
		radioPrestamo = new JRadioButton("Prestamo");
		GridBagConstraints gbc_radioPrestamo = new GridBagConstraints();
		gbc_radioPrestamo.insets = new Insets(0, 0, 0, 5);
		gbc_radioPrestamo.gridx = 0;
		gbc_radioPrestamo.gridy = 3;
		panel.add(radioPrestamo, gbc_radioPrestamo);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion : ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 4;
		getContentPane().add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 5;
		getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		jcbUsuario = new JComboBox();
		GridBagConstraints gbc_jcbUsuario = new GridBagConstraints();
		gbc_jcbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuario.gridx = 1;
		gbc_jcbUsuario.gridy = 5;
		getContentPane().add(jcbUsuario, gbc_jcbUsuario);
		
		JButton btnGestionUsuario = new JButton("Gestion de Usuario");
		btnGestionUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirDialogoUsuario();
			}
		});
		GridBagConstraints gbc_btnGestionUsuario = new GridBagConstraints();
		gbc_btnGestionUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnGestionUsuario.gridx = 2;
		gbc_btnGestionUsuario.gridy = 5;
		getContentPane().add(btnGestionUsuario, gbc_btnGestionUsuario);
		
		JLabel lblNewLabel_2 = new JLabel("Saldo (€)");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 2;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 6;
		getContentPane().add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblLimite = new JLabel("Limite (€)");
		GridBagConstraints gbc_lblLimite = new GridBagConstraints();
		gbc_lblLimite.anchor = GridBagConstraints.EAST;
		gbc_lblLimite.insets = new Insets(0, 0, 5, 5);
		gbc_lblLimite.gridx = 0;
		gbc_lblLimite.gridy = 7;
		getContentPane().add(lblLimite, gbc_lblLimite);
		
		jtfLimite = new JTextField();
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 2;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 7;
		getContentPane().add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);
		
		JLabel lblFechaDeFirma = new JLabel("Fecha de Firma : ");
		GridBagConstraints gbc_lblFechaDeFirma = new GridBagConstraints();
		gbc_lblFechaDeFirma.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFirma.insets = new Insets(0, 0, 0, 5);
		gbc_lblFechaDeFirma.gridx = 0;
		gbc_lblFechaDeFirma.gridy = 8;
		getContentPane().add(lblFechaDeFirma, gbc_lblFechaDeFirma);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 8;
		getContentPane().add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(this.radioCuentaBancaria);
		radioGroup.add(this.radioTarjetaDebito);
		radioGroup.add(this.radioTarjetaCredito);
		radioGroup.add(this.radioPrestamo);
		
		cargarUsuarios ();
		
		cargarContratoEnPantalla(controller.ContratoControlador.findFirst());
	}
	/**
	 * 
	 */
	private void cargarUsuarios () {
		this.jcbUsuario.removeAllItems();
		
		List<Usuario> usuarios = UsuarioControlador.findAll();
		for (Usuario usuario : usuarios) {
			this.jcbUsuario.addItem(usuario);
		}
	}
	private void cargarContratoEnPantalla(Contrato p ) {
		if (p != null) {
			this.jtfId.setText("" + p.getId());
			this.jtfDescripcion.setText(p.getDescripcion());
			this.jtfSaldo.setText("" + p.getSaldo());
			this.jtfLimite.setText("" + p.getLimite());
			// Selecciono la marca correcta
			for (int  i = 0; i < this.jcbUsuario.getItemCount(); i++) {
				if (p.getUsuario().getId() == this.jcbUsuario.getItemAt(i).getId()) {
					this.jcbUsuario.setSelectedIndex(i);
				}
			}
			if (p.getTipocontrato().getId() == 1) this.radioCuentaBancaria.setSelected(true);
			if (p.getTipocontrato().getId() == 2) this.radioTarjetaDebito.setSelected(true);
			if (p.getTipocontrato().getId() == 3) this.radioTarjetaCredito.setSelected(true);
			if (p.getTipocontrato().getId() == 4) this.radioPrestamo.setSelected(true);
		
			
			// Pongo la fecha
			if (p.getFechaFirma() != null) {
				this.jtfFecha.setText(sdf.format(p.getFechaFirma()));
			}
			else {
				this.jtfFecha.setText("");
			}
		}
	}
	
	/**
	 * 
	 */
	private void abrirDialogoUsuario() {
		JDialog dialogo = new JDialog();
		// El usuario no puede redimensionar el di�logo
		dialogo.setResizable(true);
		// t�tulo del d�alogo
		dialogo.setTitle("Gestión de Usuarios");
		// Introducimos el panel creado sobre el di�logo
		dialogo.setContentPane(new PanelUsuario((Usuario) this.jcbUsuario.getSelectedItem()));
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}
	
	/**
	 * 
	 */
	private void nuevo() {
		this.jtfId.setText("0");
		this.jcbUsuario.setSelectedIndex(0);
		this.jtfDescripcion.setText("");
		this.jtfSaldo.setText("");
		this.jtfLimite.setText("");
		this.radioCuentaBancaria.setSelected(true);
		this.jtfFecha.setText("");
	}
	
	/**
	 * 
	 */
	private void guardar() {
		try {
			Contrato u = cargarContratoDesdePantalla();
			
			if (u.getDescripcion().matches("{4,}")) {
				throw new Exception("La descripcion debetener " +
						"una longitud mínima de 4");
			}
			
			ContratoControlador.guardar(u);
			jtfId.setText("" + u.getId());
			JOptionPane.showMessageDialog(null, "Guardado correcto");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al guardar: " + e1.getMessage());
		}
	}
	/**
	 * 
	 * @param p
	 */
	private Contrato cargarContratoDesdePantalla () throws Exception {
		
		Contrato p = new Contrato();
		p.setId(Integer.parseInt(this.jtfId.getText()));
		p.setDescripcion(this.jtfDescripcion.getText());
		p.setSaldo(Float.parseFloat(jtfSaldo.getText()));
		p.setLimite(Float.parseFloat(jtfLimite.getText()));
		p.setUsuario((Usuario) this.jcbUsuario.getSelectedItem());
		
		
			if (this.radioCuentaBancaria.isSelected()) p.setTipocontrato(TipocontratoControlador.findById(1));
			if (this.radioTarjetaDebito.isSelected()) p.setTipocontrato(TipocontratoControlador.findById(2));
			if (this.radioTarjetaCredito.isSelected()) p.setTipocontrato(TipocontratoControlador.findById(3));
			if (this.radioPrestamo.isSelected()) p.setTipocontrato(TipocontratoControlador.findById(4));
	
//			if (this.radioCuentaBancaria.isSelected()) p.setTipocontrato(TipocontratoControlador.findById(p.getTipocontrato().getId()));;
//			if (this.radioTarjetaDebito.isSelected()) p.setTipocontrato(TipocontratoControlador.findById(p.getTipocontrato().getId()));
//			if (this.radioTarjetaCredito.isSelected()) p.setTipocontrato(TipocontratoControlador.findById(p.getTipocontrato().getId())) ;
//			if (this.radioPrestamo.isSelected()) p.setTipocontrato(TipocontratoControlador.findById(p.getTipocontrato().getId()));

		
		try {
			if (!this.jtfFecha.getText().trim().equals("")) {
				p.setFechaFirma(sdf.parse(this.jtfFecha.getText()));
			}
			
		}
		catch(Exception ex) {
			throw new Exception ("La fecha introducida: " + this.jtfFecha.getText() + 
					" no tiene el formato correcto dd/MM/yyyy");
		}

		return p;
	}
	/**
	 * 
	 */
	private void eliminar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Realmente desea eliminar?", "Eliminación", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	try {
	    		Contrato cActual = cargarContratoDesdePantalla();
	    	  	ContratoControlador.eliminar(cActual);
	    	  
	    	  	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    	  
				// Cargo otro registro en pantalla
				Contrato cAnterior = ContratoControlador.findPrevious(cActual.getId());
				if (cAnterior != null) {
					cargarContratoEnPantalla(cAnterior);
				}
				else {
					Contrato pSiguiente = ContratoControlador.findNext(cActual.getId());
					if (pSiguiente != null) {
						cargarContratoEnPantalla(pSiguiente);
					}
					else { // No quedan registros, has eliminado el único
						nuevo();
					}
				}
    		} catch (Exception e) {
    			JOptionPane.showMessageDialog(null, "Error al eliminar");
    		}          
	    }

	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
