package es.maestredam.jug.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonasGUIApp extends JFrame{
	
	private JPanel contentPane;
	private JButton btnHazAlgo;
	private JButton btnLista;
	private JTextField txtRespuesta;
	private ArrayList<String> listaNombres;
	
	
	public PersonasGUIApp() {
		listaNombres = new ArrayList<>();

		//Modifico Propiedades de la ventana
		setBounds(100,100,500,300);
		
		//Que termine la App al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Creo el Panel
		contentPane = new JPanel();
		contentPane.setLayout(null);
		//"Pego" el panel a la ventana
		setContentPane(contentPane);
		//Creo un boton
		btnHazAlgo = new JButton("Mostrar");
		btnHazAlgo.setBounds(126,149,199,23);
		btnLista = new JButton("Ver lista");

		//btnLista.setBounds();
		
		//Creo una caja
		txtRespuesta = new JTextField();
		txtRespuesta.setBounds(26,62,400,50);
		txtRespuesta.setColumns(10);
		
		//"Pego" los dos componentes al Panel
		contentPane.add(btnHazAlgo);
		contentPane.add(txtRespuesta);
		
		
		//DEFINO LOS EVENTOS en los que responder: Clic el botón (solo eso)
		
		//Crear un listener para el "clic" en el botón
		//¿KeyListener? ¿MouseListener? ¿AcctionListener?
		//=>
		
		/**
		btnHazAlgo.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Lo que quiero hacer en el clic
						System.out.println("clic en el botón");
						
						boolean hayNombre = false;
						//Muestro un nombre en la caja
						if (hayNombre) {
							txtRespuesta.setText("");
							hayNombre = false;
						}
						else {
							txtRespuesta.setText("Julio");
							hayNombre= true;
						}
						System.out.printf("hayNombre es %b%n", hayNombre);
						
					}
				}

				);
		**/
		btnHazAlgo.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre = txtRespuesta.getText();
						if (!nombre.isEmpty()) {
							listaNombres.add(nombre);
							System.out.println("Nombre añadido: " + nombre);
							txtRespuesta.setText(""); 
						}else {
							System.out.println("Por favor, escribe un nombre.");
							}
						}
				}
		
				);
		btnLista.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!listaNombres.isEmpty()) {
							System.out.println("Lista actual:" + listaNombres);
							
						}else {
							System.out.println("La lista esta vacía");
						}
					}
					
					
				}
		);
	}
	
	public static void main(String[] args) {
		PersonasGUIApp ventana = new PersonasGUIApp();
		ventana.setVisible(true);
	}

}
