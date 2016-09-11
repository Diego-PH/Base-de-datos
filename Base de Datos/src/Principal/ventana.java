package Principal;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Conexion.conexion;

public class ventana extends JFrame implements ActionListener{
	
	//elementos que llevará la ventana 
	private JLabel lbNombre = new JLabel("NOMBRE");
	private JLabel lbPaterno = new JLabel("PATERNO");
	private JLabel lbMaterno = new JLabel("MATERNO");
	
	private JTextField txtNombre = new JTextField();
	private JTextField txtPaterno = new JTextField();
	private JTextField txtMaterno = new JTextField();
	private JTextArea area = new JTextArea();
	
	private JButton btnGenera = new JButton("GENERAR REGISTROS!");
	private JButton btnMuestra= new JButton("MOSTRAR REGISTROS!");
	public Container contenedor =getContentPane();

	
	//constructor 
	public ventana(){
		super.setTitle("REGISTROS");
		super.setSize(690,600);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargar();
	}
	
	
	
	private void cargar() {
		contenedor.setLayout(null);
		
		lbNombre.setBounds(22,20,300,30);
		txtNombre.setBounds(10,55,100,220);
		
		lbPaterno.setBounds(150,20,300,30);
		txtPaterno.setBounds(120,55,100,220);
		
		lbMaterno.setBounds(250,20,300,30);
		txtMaterno.setBounds(235,55,100,220);
		
		btnGenera.setBounds(350,200,300,30);
		btnMuestra.setBounds(350,150, 300, 30);
		
		area.setBounds(22,300,560,200);
		//lbResul.setBounds(10,180,300,30);
		
		contenedor.add(lbNombre);
		contenedor.add(txtNombre);
		contenedor.add(lbPaterno);
		contenedor.add(txtPaterno);
		contenedor.add(lbMaterno);
		contenedor.add(txtMaterno);
		contenedor.add(btnGenera);
		contenedor.add(btnMuestra);
		contenedor.add(area);
		//contenedor.add(lbResul);
		
		btnGenera.addActionListener(this);
		btnMuestra.addActionListener(this);

		
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Object boton = arg0.getSource();
		if(boton==btnMuestra){
			txtNombre.setText("Mostrando...");
			txtPaterno.setText("Mostrando...");
			txtMaterno.setText("Mostrando...");
		}
		if(boton==btnGenera){
			area.setText("Generando combinaciones....");
			conexion cn = new conexion();
			String SQL = null;
			area.setText(cn.obtenerNombre(SQL));
			
			
//			System.out.println("Mostrando los nombres..." + cn.obtenerNombre(SQL));
			
		}
		
		
	}
	



}
