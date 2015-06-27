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

import controlador.Conector;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = -908688069079632214L;
    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu mnOpciones;
    private JMenuItem mntmIniciarSesin;
    private JMenuItem mntmCrearUsuario;
    private JMenuItem mntmEditarUsuario;
    private JMenuItem mntmListarUsuarios;
    private JLabel lblNewLabel;
    private JPanel panelInicio;
    private JMenu mnAyuda;
    private JMenuItem mntmAcercaDe;
    private JMenu mnArchivo;
    private JMenuItem mntmConectarAServidor;
    private JPanel panelInicioSesion;
    private JLabel lblPanelInicioSesion;
    private CardLayout cl;
    private JPanel panelCrearUsuario;
    private JPanel panelListarUsuarios;
    private JPanel panelEditarUsuarios;
    private JMenuItem mntmDesconectar;
    private JLabel lblEstadoConexion;
    private Component horizontalGlue;
    private Conector conector;
    private JLabel lblEstado;

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    Conector c  = new Conector();
		    MainFrame frame = new MainFrame(c);
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public MainFrame(Conector c) {
	
	this.conector = c;
	
    	setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/vista/img/redis-icon.png")));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 640, 480);
	setJMenuBar(getMenuBar_1());
	contentPane = new JPanel();
	contentPane.setBackground(SystemColor.control);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new CardLayout(0, 0));
	
	contentPane.add(getPanelInicio(), "PanelInicio");
	contentPane.add(new PanelIngreso(conector), "PanelInicioSesion");
	
	cl = (CardLayout)contentPane.getLayout();
	contentPane.add(new PanelCrearUsuario(conector), "PanelCrearUsuario");
	contentPane.add(getPanelListarUsuarios(), "PanelListarUsuarios");
	contentPane.add(getPanelEditarUsuarios(), "PanelEditarUsuarios");
	
	ocultarOpciones();
	
    }
    
    	private void ocultarOpciones(){
    	    mnOpciones.setEnabled(false);
    	    mntmIniciarSesin.setEnabled(false);
    	}
    	
    	private void mostrarOpciones(){
    	    mnOpciones.setEnabled(true);
    	    mntmIniciarSesin.setEnabled(true);
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
	public JMenu getMnOpciones() {
		if (mnOpciones == null) {
			mnOpciones = new JMenu("Opciones");
			mnOpciones.add(getMntmCrearUsuario());
			mnOpciones.add(getMntmEditarUsuario());
			mnOpciones.add(getMntmListarUsuarios());
		}
		return mnOpciones;
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
	public JMenuItem getMntmEditarUsuario() {
		if (mntmEditarUsuario == null) {
			mntmEditarUsuario = new JMenuItem("Editar Usuario");
			mntmEditarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    cl.show(contentPane, "PanelEditarUsuario");
				}
			});
		}
		return mntmEditarUsuario;
	}
	public JMenuItem getMntmListarUsuarios() {
		if (mntmListarUsuarios == null) {
			mntmListarUsuarios = new JMenuItem("Listar Usuarios");
			mntmListarUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    cl.show(contentPane, "PanelListarUsuarios");
				}
			});
		}
		return mntmListarUsuarios;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/vista/img/redis.png")));
		}
		return lblNewLabel;
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
	public JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	
	public JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de...");
		}
		return mntmAcercaDe;
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
	
	public JMenuItem getMntmConectarAServidor() {
		if (mntmConectarAServidor == null) {
			mntmConectarAServidor = new JMenuItem("Conectar al Servidor");
			mntmConectarAServidor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    if(conector.conectar() == 1){
					lblEstadoConexion.setText("Conectado");
					lblEstadoConexion.setForeground(Color.GREEN);
					mostrarOpciones();
				    }else{
					JOptionPane.showMessageDialog(null, "No se ha podido establecer conexión!!");
				    }
				   
				}
			});
		}
		return mntmConectarAServidor;
	}
	
	public JPanel getPanel_1() {
		if (panelInicioSesion == null) {
			panelInicioSesion = new JPanel();
			panelInicioSesion.add(getLblPanelInicioSesion());
		}
		return panelInicioSesion;
	}
	
	public JLabel getLblPanelInicioSesion() {
	    
		if (lblPanelInicioSesion == null) {
			lblPanelInicioSesion = new JLabel("Panel Inicio Sesion");
		}
		return lblPanelInicioSesion;
	}
	public JPanel getPanelCrearUsuario() {
		if (panelCrearUsuario == null) {
			panelCrearUsuario = new JPanel();
		}
		return panelCrearUsuario;
	}
	public JPanel getPanelListarUsuarios() {
		if (panelListarUsuarios == null) {
			panelListarUsuarios = new JPanel();
		}
		return panelListarUsuarios;
	}
	public JPanel getPanelEditarUsuarios() {
		if (panelEditarUsuarios == null) {
			panelEditarUsuarios = new JPanel();
		}
		return panelEditarUsuarios;
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
				    }else
					JOptionPane.showMessageDialog(null, "No se pudo desconectar!!");
				}
			});
		}
		return mntmDesconectar;
	}
	public JLabel getLblEstadoConexion() {
		if (lblEstadoConexion == null) {
			lblEstadoConexion = new JLabel("Desconectado");
			lblEstadoConexion.setForeground(new Color(255, 0, 0));
		}
		return lblEstadoConexion;
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

	
}

