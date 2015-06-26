package vista;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;

import controlador.Conector;
import javax.swing.JScrollPane;

public class TestVistaUsuarios extends JFrame {

	/**
   * 
   */
  private static final long serialVersionUID = 6917697380717321353L;
  private JPanel contentPane;
  private JPanel panelUsuarios;
  private JPanel panelFechas;
  private JPanel panelProteinas;
  private JLabel lblUsuarios;
  private JList listUsuarios;
  private JLabel lblFechas;
  private JList listFechas;
  private JLabel lblProtenas;
  private JList listProteinas;
  private JSeparator separator;
  private JSeparator separator_1;
  private JSeparator separator_2;
  private JSeparator separator_3;
  private Conector c;
  private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	
					TestVistaUsuarios frame = new TestVistaUsuarios();
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
	public TestVistaUsuarios() {
	    	c = new Conector ();
	    	c.conectar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_panelUsuarios = new GridBagConstraints();
		gbc_panelUsuarios.gridheight = 2;
		gbc_panelUsuarios.insets = new Insets(0, 0, 0, 5);
		gbc_panelUsuarios.fill = GridBagConstraints.BOTH;
		gbc_panelUsuarios.gridx = 0;
		gbc_panelUsuarios.gridy = 0;
		contentPane.add(getPanelUsuarios(), gbc_panelUsuarios);
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.fill = GridBagConstraints.VERTICAL;
		gbc_separator_3.gridheight = 2;
		gbc_separator_3.insets = new Insets(0, 0, 5, 5);
		gbc_separator_3.gridx = 1;
		gbc_separator_3.gridy = 0;
		contentPane.add(getSeparator_3(), gbc_separator_3);
		GridBagConstraints gbc_panelFechas = new GridBagConstraints();
		gbc_panelFechas.insets = new Insets(0, 0, 5, 0);
		gbc_panelFechas.fill = GridBagConstraints.BOTH;
		gbc_panelFechas.gridx = 2;
		gbc_panelFechas.gridy = 0;
		contentPane.add(getPanelFechas(), gbc_panelFechas);
		GridBagConstraints gbc_panelProteinas = new GridBagConstraints();
		gbc_panelProteinas.fill = GridBagConstraints.BOTH;
		gbc_panelProteinas.gridx = 2;
		gbc_panelProteinas.gridy = 1;
		contentPane.add(getPanelProteinas(), gbc_panelProteinas);
		c.desconectar();
	}

	public JPanel getPanelUsuarios() {
		if (panelUsuarios == null) {
			panelUsuarios = new JPanel();
			GridBagLayout gbl_panelUsuarios = new GridBagLayout();
			gbl_panelUsuarios.columnWidths = new int[]{0, 0};
			gbl_panelUsuarios.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panelUsuarios.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panelUsuarios.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			panelUsuarios.setLayout(gbl_panelUsuarios);
			GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
			gbc_lblUsuarios.anchor = GridBagConstraints.WEST;
			gbc_lblUsuarios.insets = new Insets(0, 0, 5, 0);
			gbc_lblUsuarios.gridx = 0;
			gbc_lblUsuarios.gridy = 0;
			panelUsuarios.add(getLblUsuarios(), gbc_lblUsuarios);
			GridBagConstraints gbc_separator = new GridBagConstraints();
			gbc_separator.fill = GridBagConstraints.BOTH;
			gbc_separator.insets = new Insets(0, 0, 5, 0);
			gbc_separator.gridx = 0;
			gbc_separator.gridy = 1;
			panelUsuarios.add(getSeparator(), gbc_separator);
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 2;
			panelUsuarios.add(getScrollPane(), gbc_scrollPane);
		}
		return panelUsuarios;
	}
	
	public JPanel getPanelFechas() {
		if (panelFechas == null) {
			panelFechas = new JPanel();
			GridBagLayout gbl_panelFechas = new GridBagLayout();
			gbl_panelFechas.columnWidths = new int[]{0, 0};
			gbl_panelFechas.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panelFechas.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panelFechas.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			panelFechas.setLayout(gbl_panelFechas);
			GridBagConstraints gbc_lblFechas = new GridBagConstraints();
			gbc_lblFechas.anchor = GridBagConstraints.WEST;
			gbc_lblFechas.insets = new Insets(0, 0, 5, 0);
			gbc_lblFechas.gridx = 0;
			gbc_lblFechas.gridy = 0;
			panelFechas.add(getLblFechas(), gbc_lblFechas);
			GridBagConstraints gbc_separator_1 = new GridBagConstraints();
			gbc_separator_1.fill = GridBagConstraints.BOTH;
			gbc_separator_1.insets = new Insets(0, 0, 5, 0);
			gbc_separator_1.gridx = 0;
			gbc_separator_1.gridy = 1;
			panelFechas.add(getSeparator_1(), gbc_separator_1);
			GridBagConstraints gbc_listFechas = new GridBagConstraints();
			gbc_listFechas.fill = GridBagConstraints.BOTH;
			gbc_listFechas.gridx = 0;
			gbc_listFechas.gridy = 2;
			panelFechas.add(getListFechas(), gbc_listFechas);
		}
		return panelFechas;
	}
	
	public JPanel getPanelProteinas() {
		if (panelProteinas == null) {
			panelProteinas = new JPanel();
			GridBagLayout gbl_panelProteinas = new GridBagLayout();
			gbl_panelProteinas.columnWidths = new int[]{0, 0};
			gbl_panelProteinas.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panelProteinas.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panelProteinas.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			panelProteinas.setLayout(gbl_panelProteinas);
			GridBagConstraints gbc_lblProtenas = new GridBagConstraints();
			gbc_lblProtenas.anchor = GridBagConstraints.WEST;
			gbc_lblProtenas.insets = new Insets(0, 0, 5, 0);
			gbc_lblProtenas.gridx = 0;
			gbc_lblProtenas.gridy = 0;
			panelProteinas.add(getLblProtenas(), gbc_lblProtenas);
			GridBagConstraints gbc_separator_2 = new GridBagConstraints();
			gbc_separator_2.fill = GridBagConstraints.BOTH;
			gbc_separator_2.insets = new Insets(0, 0, 5, 0);
			gbc_separator_2.gridx = 0;
			gbc_separator_2.gridy = 1;
			panelProteinas.add(getSeparator_2(), gbc_separator_2);
			GridBagConstraints gbc_listProteinas = new GridBagConstraints();
			gbc_listProteinas.fill = GridBagConstraints.BOTH;
			gbc_listProteinas.gridx = 0;
			gbc_listProteinas.gridy = 2;
			panelProteinas.add(getListProteinas(), gbc_listProteinas);
		}
		return panelProteinas;
	}
	public JLabel getLblUsuarios() {
		if (lblUsuarios == null) {
			lblUsuarios = new JLabel("Usuarios");
		}
		return lblUsuarios;
	}
	public JList getListUsuarios() {
		if (listUsuarios == null) {
			listUsuarios = new JList();
			listUsuarios.setModel(new listaDeUsuarios());
			listUsuarios.setBackground(SystemColor.menu);
		}
		return listUsuarios;
	}
	public JLabel getLblFechas() {
		if (lblFechas == null) {
			lblFechas = new JLabel("Fechas");
		}
		return lblFechas;
	}
	
	public JList getListFechas() {
		if (listFechas == null) {
			listFechas = new JList();
			listFechas.setBackground(SystemColor.menu);
		}
		return listFechas;
	}
	
	public JLabel getLblProtenas() {
		if (lblProtenas == null) {
			lblProtenas = new JLabel("Prote\u00EDnas");
		}
		return lblProtenas;
	}
	
	public JList getListProteinas() {
		if (listProteinas == null) {
			listProteinas = new JList();
			listProteinas.setBackground(SystemColor.menu);
		}
		return listProteinas;
	}
        public JSeparator getSeparator() {
          if (separator == null) {
          	separator = new JSeparator();
          }
          return separator;
        }
        public JSeparator getSeparator_1() {
          if (separator_1 == null) {
          	separator_1 = new JSeparator();
          }
          return separator_1;
        }
        public JSeparator getSeparator_2() {
          if (separator_2 == null) {
          	separator_2 = new JSeparator();
          }
          return separator_2;
        }
        public JSeparator getSeparator_3() {
          if (separator_3 == null) {
          	separator_3 = new JSeparator();
          	separator_3.setOrientation(SwingConstants.VERTICAL);
          }
          return separator_3;
        }
  
        class listaDeUsuarios extends AbstractListModel{

	    private static final long serialVersionUID = -7516169186834814283L;
	    private List<String> lista = new ArrayList();
            
            public listaDeUsuarios(){
        	try{
        	    c = new Conector();
        	    c.conectar();
        	    lista.addAll(c.getUsuarios());
        	    c.desconectar();
        	    c.close();
        	    Collections.sort(lista);
        	}catch(Exception e){
        	    System.out.println("Debe estar conectado a la base de datos Redis!!!");
        	}
            }
            
            

	    public Object getElementAt(int index) {
		return lista.get(index);
	    }

	    public int getSize() {
		return lista.size();
	    }
            
            
        }
  
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getListUsuarios());
		}
		return scrollPane;
	}
}
