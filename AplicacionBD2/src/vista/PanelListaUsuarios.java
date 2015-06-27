package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JList;

import modelo.Strings;
import controlador.Conector;

import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PanelListaUsuarios extends JPanel {
	private JPanel panel;
	private JPanel panelUsuarios;
	private JLabel label;
	private JSeparator separator;
	private JSeparator separator_1;
	private JPanel panelFechas;
	private JLabel label_1;
	private JSeparator separator_2;
	private JList list;
	private JPanel panelProteinas;
	private JLabel label_2;
	private JSeparator separator_3;
	private JList list_1;
	private Conector conector;

    /**
     * Create the panel.
     */
    public PanelListaUsuarios(Conector c) {
	this.conector = c;
	
    	setLayout(new BorderLayout(0, 0));
    	add(getPanel());

    }

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_panelUsuarios = new GridBagConstraints();
			gbc_panelUsuarios.fill = GridBagConstraints.BOTH;
			gbc_panelUsuarios.gridheight = 2;
			gbc_panelUsuarios.insets = new Insets(0, 0, 0, 5);
			gbc_panelUsuarios.gridx = 0;
			gbc_panelUsuarios.gridy = 0;
			panel.add(getPanelUsuarios(), gbc_panelUsuarios);
			GridBagConstraints gbc_separator_1 = new GridBagConstraints();
			gbc_separator_1.fill = GridBagConstraints.VERTICAL;
			gbc_separator_1.gridheight = 2;
			gbc_separator_1.insets = new Insets(0, 0, 0, 5);
			gbc_separator_1.gridx = 1;
			gbc_separator_1.gridy = 0;
			panel.add(getSeparator_1(), gbc_separator_1);
			GridBagConstraints gbc_panelFechas = new GridBagConstraints();
			gbc_panelFechas.fill = GridBagConstraints.BOTH;
			gbc_panelFechas.insets = new Insets(0, 0, 5, 0);
			gbc_panelFechas.gridx = 2;
			gbc_panelFechas.gridy = 0;
			panel.add(getPanelFechas(), gbc_panelFechas);
			GridBagConstraints gbc_panelProteinas = new GridBagConstraints();
			gbc_panelProteinas.fill = GridBagConstraints.BOTH;
			gbc_panelProteinas.gridx = 2;
			gbc_panelProteinas.gridy = 1;
			panel.add(getPanelProteinas(), gbc_panelProteinas);
		}
		return panel;
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
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.WEST;
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 0;
			gbc_label.gridy = 0;
			panelUsuarios.add(getLabel(), gbc_label);
			GridBagConstraints gbc_separator = new GridBagConstraints();
			gbc_separator.fill = GridBagConstraints.BOTH;
			gbc_separator.insets = new Insets(0, 0, 5, 0);
			gbc_separator.gridx = 0;
			gbc_separator.gridy = 1;
			panelUsuarios.add(getSeparator(), gbc_separator);
		}
		return panelUsuarios;
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Usuarios");
		}
		return label;
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
			separator_1.setOrientation(SwingConstants.VERTICAL);
		}
		return separator_1;
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
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.WEST;
			gbc_label_1.insets = new Insets(0, 0, 5, 0);
			gbc_label_1.gridx = 0;
			gbc_label_1.gridy = 0;
			panelFechas.add(getLabel_1(), gbc_label_1);
			GridBagConstraints gbc_separator_2 = new GridBagConstraints();
			gbc_separator_2.fill = GridBagConstraints.BOTH;
			gbc_separator_2.insets = new Insets(0, 0, 5, 0);
			gbc_separator_2.gridx = 0;
			gbc_separator_2.gridy = 1;
			panelFechas.add(getSeparator_2(), gbc_separator_2);
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 0;
			gbc_list.gridy = 2;
			panelFechas.add(getList(), gbc_list);
		}
		return panelFechas;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Fechas");
		}
		return label_1;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
		}
		return separator_2;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
			list.setBackground(SystemColor.menu);
		}
		return list;
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
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.anchor = GridBagConstraints.WEST;
			gbc_label_2.insets = new Insets(0, 0, 5, 0);
			gbc_label_2.gridx = 0;
			gbc_label_2.gridy = 0;
			panelProteinas.add(getLabel_2(), gbc_label_2);
			GridBagConstraints gbc_separator_3 = new GridBagConstraints();
			gbc_separator_3.fill = GridBagConstraints.BOTH;
			gbc_separator_3.insets = new Insets(0, 0, 5, 0);
			gbc_separator_3.gridx = 0;
			gbc_separator_3.gridy = 1;
			panelProteinas.add(getSeparator_3(), gbc_separator_3);
			GridBagConstraints gbc_list_1 = new GridBagConstraints();
			gbc_list_1.fill = GridBagConstraints.BOTH;
			gbc_list_1.gridx = 0;
			gbc_list_1.gridy = 2;
			panelProteinas.add(getList_1(), gbc_list_1);
		}
		return panelProteinas;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Prote\u00EDnas");
		}
		return label_2;
	}
	public JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
		}
		return separator_3;
	}
	public JList getList_1() {
		if (list_1 == null) {
			list_1 = new JList();
			list_1.setBackground(SystemColor.menu);
		}
		return list_1;
	}
	
	 class listaDeUsuarios extends AbstractListModel{

		    private static final long serialVersionUID = -7516169186834814283L;
		    private List<String> lista = new ArrayList();
	            
	            public listaDeUsuarios(){

	        	    lista.addAll(conector.getUsuarios());
	        	    Collections.sort(lista, Strings.getNaturalComparator());
	            }
	            
		    public Object getElementAt(int index) {
			return lista.get(index);
		    }

		    public int getSize() {
			return lista.size();
		    }            
	        }
	        
	        class listaDeFechas extends AbstractListModel{
	                       
		    private static final long serialVersionUID = -4052141478947131221L;
		    private List<Date> lista = new ArrayList();
	            
	            public listaDeFechas(String nombreUsuario){
	        	    lista.addAll(conector.getFechas(nombreUsuario));

	        	    Collections.sort(lista, new Comparator<Date>(){
				public int compare(Date o1, Date o2) {
				    return o1.compareTo(o2);
				}
	        	    });
	        	    
	        	    while(lista.size()>5){
	        		lista.remove(0);
	        	    }
	            }            

		    public Object getElementAt(int index) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			return df.format(lista.get(index));
		    }

		    public int getSize() {
			return lista.size();
		    }           
	            
	        }
	        
	        class listaDeProteinas extends AbstractListModel{
	            
	            private static final long serialVersionUID = -4052141478947131221L;
		    private List<String> lista = new ArrayList();
	            
	            public listaDeProteinas(String nombreUsuario, String fecha){
	        	
	        	lista.add(conector.getProteinas(nombreUsuario, fecha));
	        	Collections.sort(lista, Strings.getNaturalComparator());

	            }            

		    public Object getElementAt(int index) {
			return lista.get(index);
		    }

		    public int getSize() {
			return lista.size();
		    }            
	        }
}
