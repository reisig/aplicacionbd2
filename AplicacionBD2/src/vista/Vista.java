package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;
import controlador.Conector;

public class Vista extends JFrame {

    private static final long serialVersionUID = -908688069079632214L;
    public static CardLayout cl;
    public static Usuario user = null;
    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu mnOpciones;
    private JMenuItem mntmIniciarSesin;
    private JMenuItem mntmCrearUsuario;
    private JMenuItem mntmListarUsuarios;
    private JLabel lblNewLabel;
    private JPanel panelInicio;
    private JMenu mnAyuda;
    private JMenuItem mntmAcercaDe;
    private JMenu mnArchivo;
    private JMenuItem mntmConectarAServidor;
    private JLabel lblPanelInicioSesion;
    private JMenuItem mntmDesconectar;
    private JLabel lblEstadoConexion;
    private Component horizontalGlue;
    private Conector conector;
    private JLabel lblEstado;
    private PanelIngreso panelIngreso;
    private PanelListaUsuarios panelListaUsuarios;
    private PanelEditarUsuario panelEditarUsuario;
    private PanelCrearUsuario panelCrearUsuario;
    private PanelEditarProteinas panelEditarProteinas;
    private JMenu mnEditarUsuario;
    private JMenuItem mntmCambiarNombrecontrasea;
    private JMenuItem mntmCambiarFechasproteinas;
    
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    Conector c  = new Conector();
		    Vista frame = new Vista(c);
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }



    public Vista(Conector c) {
	
	this.conector = c;
	
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Vista.class.getResource("/vista/img/redis-icon.png")));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 640, 480);
	setJMenuBar(getMenuBar_1());
	contentPane = new JPanel();
	contentPane.setBackground(SystemColor.control);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new CardLayout(0, 0));

	contentPane.add(getPanelInicio(), "PanelInicio");
	cl = (CardLayout)contentPane.getLayout();
	
	panelIngreso = new PanelIngreso(conector, user);
	panelListaUsuarios = new PanelListaUsuarios(conector);
	panelEditarUsuario = new PanelEditarUsuario(conector, null);
	panelCrearUsuario = new  PanelCrearUsuario(conector);
	panelEditarProteinas = new PanelEditarProteinas(conector);
	
	contentPane.add(panelEditarProteinas, "PanelEditarProteinas");
	contentPane.add(panelCrearUsuario, "PanelCrearUsuario");
	contentPane.add(panelListaUsuarios, "PanelListaUsuarios");
	contentPane.add(panelEditarUsuario, "PanelEditarUsuarios");
	contentPane.add(panelIngreso, "PanelInicioSesion");
	
	setLocationRelativeTo(null);
	
	ocultarOpciones();
	
    }
    
    	public Component getHorizontalGlue() {
		if (horizontalGlue == null) {
			horizontalGlue = Box.createHorizontalGlue();
		}
		return horizontalGlue;
	}
    	
    	public JLabel getLblEstado() {
		if (lblEstado == null) {
			lblEstado = new JLabel("Estado:");
		}
		return lblEstado;
	}
    
	public JLabel getLblEstadoConexion() {
		if (lblEstadoConexion == null) {
			lblEstadoConexion = new JLabel("Desconectado");
			lblEstadoConexion.setForeground(new Color(255, 0, 0));
		}
		return lblEstadoConexion;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Vista.class.getResource("/vista/img/redis.png")));
		}
		return lblNewLabel;
	}
	public JLabel getLblPanelInicioSesion() {
	    
		if (lblPanelInicioSesion == null) {
			lblPanelInicioSesion = new JLabel("Panel Inicio Sesion");
		}
		return lblPanelInicioSesion;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnArchivo());
			menuBar.add(getMnOpciones());
			menuBar.add(getMnAyuda());
			menuBar.add(getHorizontalGlue());
			menuBar.add(getLblEstado());
			menuBar.add(getLblEstadoConexion());
		}
		return menuBar;
	}
	public JMenu getMnArchivo() {
		if (mnArchivo == null) {
			mnArchivo = new JMenu("Archivo");
			mnArchivo.add(getMntmIniciarSesin());
			mnArchivo.add(getMntmConectarAServidor());
			mnArchivo.add(getMntmDesconectar());
		}
		return mnArchivo;
	}
	public JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	public JMenu getMnOpciones() {
		if (mnOpciones == null) {
			mnOpciones = new JMenu("Opciones");
			mnOpciones.add(getMntmCrearUsuario());
			mnOpciones.add(getMntmListarUsuarios());
			mnOpciones.add(getMnEditarUsuario());
		}
		return mnOpciones;
	}
	public JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de...");
		}
		return mntmAcercaDe;
	}
	public JMenuItem getMntmConectarAServidor() {
		if (mntmConectarAServidor == null) {
			mntmConectarAServidor = new JMenuItem("Conectar al Servidor");
			mntmConectarAServidor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    if(conector.conectar() == 1){
					lblEstadoConexion.setText("Conectado");
					lblEstadoConexion.setForeground(Color.GREEN);
					mostrarOpciones();
					mntmConectarAServidor.setEnabled(false);
					mntmDesconectar.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Conexi�n exitosa!", "�xito", JOptionPane.INFORMATION_MESSAGE);					
				    }else{
					JOptionPane.showMessageDialog(null, "No se ha podido establecer conexi�n!!");
				    }
				   
				}
			});
		}
		return mntmConectarAServidor;
	}
	
	public JMenuItem getMntmCrearUsuario() {
		if (mntmCrearUsuario == null) {
			mntmCrearUsuario = new JMenuItem("Crear Usuario");
			mntmCrearUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    cl.show(contentPane, "PanelCrearUsuario");
				}
			});
		}
		return mntmCrearUsuario;
	}
	
	public JMenuItem getMntmDesconectar() {
		if (mntmDesconectar == null) {
			mntmDesconectar = new JMenuItem("Desconectar...");
			mntmDesconectar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    if (conector.desconectar()==1){
					lblEstadoConexion.setText("Desconectado");
					lblEstadoConexion.setForeground(Color.RED);
					cl.show(contentPane, "PanelInicio");
					ocultarOpciones();
					mntmConectarAServidor.setEnabled(true);
					mntmDesconectar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Desconectado del Servidor", 
						"Desconectado", JOptionPane.INFORMATION_MESSAGE);
				    }else
					JOptionPane.showMessageDialog(null, "No se pudo desconectar!!");
				}
			});
			mntmDesconectar.setEnabled(false);
		}
		return mntmDesconectar;
	}
	
	public JMenuItem getMntmIniciarSesin() {
		if (mntmIniciarSesin == null) {
			mntmIniciarSesin = new JMenuItem("Iniciar Sesi\u00F3n");
			mntmIniciarSesin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				    cl.show(contentPane, "PanelInicioSesion");
				    
				}
			});
		}
		return mntmIniciarSesin;
	}
	
	public JMenuItem getMntmListarUsuarios() {
		if (mntmListarUsuarios == null) {
			mntmListarUsuarios = new JMenuItem("Listar Usuarios");
			mntmListarUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    panelListaUsuarios.setUsuarios();
				    cl.show(contentPane, "PanelListaUsuarios");
				}
			});
		}
		return mntmListarUsuarios;
	}


	public JPanel getPanelInicio() {
		if (panelInicio == null) {
			panelInicio = new JPanel();
			panelInicio.setBackground(SystemColor.window);
			GridBagLayout gbl_panelInicio = new GridBagLayout();
			gbl_panelInicio.columnWidths = new int[]{0, 0};
			gbl_panelInicio.rowHeights = new int[]{0, 0};
			gbl_panelInicio.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panelInicio.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panelInicio.setLayout(gbl_panelInicio);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panelInicio.add(getLblNewLabel(), gbc_lblNewLabel);
		}
		return panelInicio;
	}

	private void mostrarOpciones(){
    	    mnOpciones.setEnabled(true);
    	    mntmIniciarSesin.setEnabled(true);
    	}
	private void ocultarOpciones(){
    	    mnOpciones.setEnabled(false);
    	    mntmIniciarSesin.setEnabled(false);
    	}

	
	public JMenu getMnEditarUsuario() {
		if (mnEditarUsuario == null) {
			mnEditarUsuario = new JMenu("Editar Usuario");
			mnEditarUsuario.add(getMntmCambiarNombrecontrasea());
			mnEditarUsuario.add(getMntmCambiarFechasproteinas());
		}
		return mnEditarUsuario;
	}
	public JMenuItem getMntmCambiarNombrecontrasea() {
		if (mntmCambiarNombrecontrasea == null) {
			mntmCambiarNombrecontrasea = new JMenuItem("Cambiar Nombre/Contrase\u00F1a");
			mntmCambiarNombrecontrasea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				    if(user!=null)
					cl.show(contentPane, "PanelEditarUsuarios");
				    else
					JOptionPane.showMessageDialog(null, "Primero debe Iniciar Sesi�n", "Error", JOptionPane.ERROR_MESSAGE);
				}
			});
		}
		return mntmCambiarNombrecontrasea;
	}
	public JMenuItem getMntmCambiarFechasproteinas() {
		if (mntmCambiarFechasproteinas == null) {
			mntmCambiarFechasproteinas = new JMenuItem("Cambiar Fechas/Proteinas");
			mntmCambiarFechasproteinas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    if(user!=null){
					cl.show(contentPane, "PanelEditarProteinas");
					panelEditarProteinas.setUsuario(Vista.user);
				    }else{
					JOptionPane.showMessageDialog(null, "Primero debe Iniciar Sesi�n", "Error", JOptionPane.ERROR_MESSAGE);
				    }
				}
			});
		}
		return mntmCambiarFechasproteinas;
	}
}

