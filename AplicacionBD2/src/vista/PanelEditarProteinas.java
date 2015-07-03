package vista;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Usuario;

import com.toedter.calendar.JCalendar;

import controlador.Conector;

public class PanelEditarProteinas extends JPanel {

    private static final long serialVersionUID = -6219532406666600944L;
    private Conector conector;
    private Usuario usuario;
    private ListasVista lv;
    private JPanel panelLista;
    private JLabel label;
    private JLabel label_2;
    private JButton btnActualizar;
    private JLabel label_3;
    private JScrollPane scrollPane_2;
    private JScrollPane scrollPane_3;
    private JButton btnEditarFechas;
    private JButton btnEditarProteinas;
    private JList listFechas;
    private JList listProteinas;
    private JLabel nombreUsuario;
    private JPanel panelEditarFecha;
    private JLabel lblNuevaFecha;
    private JLabel lblFechaActual;
    private JLabel lblNombreUsuario;
    private JLabel lblFecha;
    private JLabel label_1;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JPanel panel_2;
    private JCalendar calendar;
    private CardLayout cl;
    
    public PanelEditarProteinas(Conector c) {
	this.conector = c;
	lv = new ListasVista(conector);
	setLayout(new CardLayout(0, 0));
	cl = (CardLayout)this.getLayout();
	add(getPanel_1(), "panelListas");
	add(getPanel_1_1(), "panelEditarFecha");
    }
    
    public void setUsuario(Usuario u){
	this.usuario = u;
	nombreUsuario.setText(usuario.getNombre());
	label_1.setText(nombreUsuario.getText());	
    }
	public JPanel getPanel_1() {
		if (panelLista == null) {
			panelLista = new JPanel();
			GridBagLayout gbl_panelLista = new GridBagLayout();
			gbl_panelLista.columnWidths = new int[]{160, 79, 105, 0};
			gbl_panelLista.rowHeights = new int[]{21, 23, 23, 88, 23, 0};
			gbl_panelLista.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panelLista.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			panelLista.setLayout(gbl_panelLista);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.NORTHEAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 0;
			panelLista.add(getLabel(), gbc_label);
			GridBagConstraints gbc_nombreUsuario = new GridBagConstraints();
			gbc_nombreUsuario.anchor = GridBagConstraints.WEST;
			gbc_nombreUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_nombreUsuario.gridx = 1;
			gbc_nombreUsuario.gridy = 0;
			panelLista.add(getLabel_1_1(), gbc_nombreUsuario);
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 0;
			gbc_label_2.gridy = 2;
			panelLista.add(getLabel_2(), gbc_label_2);
			GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
			gbc_btnActualizar.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnActualizar.insets = new Insets(0, 0, 5, 5);
			gbc_btnActualizar.gridx = 1;
			gbc_btnActualizar.gridy = 2;
			panelLista.add(getBtnActualizar(), gbc_btnActualizar);
			GridBagConstraints gbc_label_3 = new GridBagConstraints();
			gbc_label_3.insets = new Insets(0, 0, 5, 0);
			gbc_label_3.gridx = 2;
			gbc_label_3.gridy = 2;
			panelLista.add(getLabel_3(), gbc_label_3);
			GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
			gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane_2.gridx = 0;
			gbc_scrollPane_2.gridy = 3;
			panelLista.add(getScrollPane_2(), gbc_scrollPane_2);
			GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
			gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane_3.gridx = 2;
			gbc_scrollPane_3.gridy = 3;
			panelLista.add(getScrollPane_3(), gbc_scrollPane_3);
			GridBagConstraints gbc_btnEditarFechas = new GridBagConstraints();
			gbc_btnEditarFechas.anchor = GridBagConstraints.NORTH;
			gbc_btnEditarFechas.insets = new Insets(0, 0, 0, 5);
			gbc_btnEditarFechas.gridx = 0;
			gbc_btnEditarFechas.gridy = 4;
			panelLista.add(getBtnEditarFechas(), gbc_btnEditarFechas);
			GridBagConstraints gbc_btnEditarProteinas = new GridBagConstraints();
			gbc_btnEditarProteinas.anchor = GridBagConstraints.NORTH;
			gbc_btnEditarProteinas.gridx = 2;
			gbc_btnEditarProteinas.gridy = 4;
			panelLista.add(getBtnEditarProteinas(), gbc_btnEditarProteinas);
		}
		return panelLista;
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Nombre Usuario: ");
			label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return label;
	}
	public JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Fechas");
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return label_2;
	}
	public JButton getBtnActualizar() {
		if (btnActualizar == null) {
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    listFechas.setModel(lv.getListaFechas(usuario.getNombre()));
				}
			});
		}
		return btnActualizar;
	}
	public JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Proteinas");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return label_3;
	}
	public JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getListFechas());
		}
		return scrollPane_2;
	}
	public JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setViewportView(getListProteinas());
		}
		return scrollPane_3;
	}
	public JButton getBtnEditarFechas() {
		if (btnEditarFechas == null) {
			btnEditarFechas = new JButton("Editar");
			btnEditarFechas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				    cl.show(PanelEditarProteinas.this, "panelEditarFecha");
				    lblFecha.setText(String.valueOf(listFechas.getSelectedValue()));
				}
			});
		}
		return btnEditarFechas;
	}
	public JButton getBtnEditarProteinas() {
		if (btnEditarProteinas == null) {
			btnEditarProteinas = new JButton("Editar");
		}
		return btnEditarProteinas;
	}
	public JList getListFechas() {
		if (listFechas == null) {
			listFechas = new JList();
			listFechas.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
				    listProteinas.setModel(lv.getListaProteinas(usuario.getNombre(), String.valueOf(listFechas.getSelectedValue())));
				}
			});
			listFechas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return listFechas;
	}
	public JList getListProteinas() {
		if (listProteinas == null) {
			listProteinas = new JList();
			listProteinas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return listProteinas;
	}
	public JLabel getLabel_1_1() {
		if (nombreUsuario == null) {
			nombreUsuario = new JLabel();
			nombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return nombreUsuario;
	}
	public JPanel getPanel_1_1() {
		if (panelEditarFecha == null) {
			panelEditarFecha = new JPanel();
			GridBagLayout gbl_panelEditarFecha = new GridBagLayout();
			gbl_panelEditarFecha.columnWidths = new int[]{0, 69, 58, 176, 54, 0};
			gbl_panelEditarFecha.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panelEditarFecha.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panelEditarFecha.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			panelEditarFecha.setLayout(gbl_panelEditarFecha);
			GridBagConstraints gbc_lblNombreUsuario = new GridBagConstraints();
			gbc_lblNombreUsuario.gridwidth = 2;
			gbc_lblNombreUsuario.anchor = GridBagConstraints.EAST;
			gbc_lblNombreUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombreUsuario.gridx = 1;
			gbc_lblNombreUsuario.gridy = 1;
			panelEditarFecha.add(getLabel_1_4(), gbc_lblNombreUsuario);
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 3;
			gbc_label_1.gridy = 1;
			panelEditarFecha.add(getLabel_1(), gbc_label_1);
			GridBagConstraints gbc_lblFechaActual = new GridBagConstraints();
			gbc_lblFechaActual.insets = new Insets(0, 0, 5, 5);
			gbc_lblFechaActual.gridx = 1;
			gbc_lblFechaActual.gridy = 3;
			panelEditarFecha.add(getLabel_1_3(), gbc_lblFechaActual);
			GridBagConstraints gbc_lblFecha = new GridBagConstraints();
			gbc_lblFecha.anchor = GridBagConstraints.WEST;
			gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
			gbc_lblFecha.gridx = 3;
			gbc_lblFecha.gridy = 3;
			panelEditarFecha.add(getLblFecha(), gbc_lblFecha);
			GridBagConstraints gbc_lblNuevaFecha = new GridBagConstraints();
			gbc_lblNuevaFecha.insets = new Insets(0, 0, 5, 5);
			gbc_lblNuevaFecha.gridx = 1;
			gbc_lblNuevaFecha.gridy = 4;
			panelEditarFecha.add(getLabel_1_2(), gbc_lblNuevaFecha);
			GridBagConstraints gbc_calendar = new GridBagConstraints();
			gbc_calendar.insets = new Insets(0, 0, 5, 5);
			gbc_calendar.fill = GridBagConstraints.BOTH;
			gbc_calendar.gridx = 3;
			gbc_calendar.gridy = 4;
			panelEditarFecha.add(getCalendar(), gbc_calendar);
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.insets = new Insets(0, 0, 5, 5);
			gbc_panel_2.fill = GridBagConstraints.BOTH;
			gbc_panel_2.gridx = 3;
			gbc_panel_2.gridy = 6;
			panelEditarFecha.add(getPanel_2(), gbc_panel_2);
		}
		return panelEditarFecha;
	}
	public JLabel getLabel_1_2() {
		if (lblNuevaFecha == null) {
			lblNuevaFecha = new JLabel("Nueva Fecha :");
		}
		return lblNuevaFecha;
	}
	public JLabel getLabel_1_3() {
		if (lblFechaActual == null) {
			lblFechaActual = new JLabel("Fecha Actual:");
		}
		return lblFechaActual;
	}
	public JLabel getLabel_1_4() {
		if (lblNombreUsuario == null) {
			lblNombreUsuario = new JLabel("Nombre Usuario: ");
			lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lblNombreUsuario;
	}
	public JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("");
		}
		return lblFecha;
	}
	public JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel();
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return label_1;
	}
	public JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
		}
		return btnAceptar;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    cl.show(PanelEditarProteinas.this, "panelListas");
				}
			});
		}
		return btnCancelar;
	}
	public JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{75, 25, 0, 0};
			gbl_panel_2.rowHeights = new int[]{23, 0};
			gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
			gbc_btnCancelar.anchor = GridBagConstraints.WEST;
			gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
			gbc_btnCancelar.gridx = 0;
			gbc_btnCancelar.gridy = 0;
			panel_2.add(getBtnCancelar(), gbc_btnCancelar);
			GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
			gbc_btnAceptar.anchor = GridBagConstraints.WEST;
			gbc_btnAceptar.gridx = 2;
			gbc_btnAceptar.gridy = 0;
			panel_2.add(getBtnAceptar(), gbc_btnAceptar);
		}
		return panel_2;
	}
	public JCalendar getCalendar() {
		if (calendar == null) {
			calendar = new JCalendar();
		}
		return calendar;
	}
}
