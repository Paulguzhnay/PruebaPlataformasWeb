package ec.edu.ups.pruebaCliente.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import ec.edu.ups.prueba.busniess.VehiculoONRemote;
import ec.edu.ups.prueba.model.Vehiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtPuerta;
	
	private VehiculoONRemote vehRem;
	private JTextField txtPlacaAct;
	private JTextField txtModeloAct;
	private JTextField txtMarcaAct;
	private JTextField txtNumPuertAct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente frame = new VentanaCliente();
					frame.setVisible(true);
					frame.conectar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCliente() {
		try {
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 575);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLACA");
		lblNewLabel.setBounds(67, 137, 77, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblModelo = new JLabel("MODELO");
		lblModelo.setBounds(67, 173, 77, 13);
		contentPane.add(lblModelo);
		
		JLabel lblMarca = new JLabel("MARCA");
		lblMarca.setBounds(67, 214, 77, 13);
		contentPane.add(lblMarca);
		
		JLabel lblNoPuertas = new JLabel("No PUERTAS");
		lblNoPuertas.setBounds(67, 260, 77, 13);
		contentPane.add(lblNoPuertas);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(180, 134, 96, 19);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(180, 170, 96, 19);
		contentPane.add(txtModelo);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(180, 211, 96, 19);
		contentPane.add(txtMarca);
		
		txtPuerta = new JTextField();
		txtPuerta.setColumns(10);
		txtPuerta.setBounds(180, 257, 96, 19);
		contentPane.add(txtPuerta);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ObtenerDatos();
			}
		});
		btnNewButton.setBounds(166, 362, 110, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("PLACA");
		lblNewLabel_1.setBounds(507, 134, 77, 13);
		contentPane.add(lblNewLabel_1);
		
		txtPlacaAct = new JTextField();
		txtPlacaAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BuscarPlacaActualizada();
			}
		});
		txtPlacaAct.setColumns(10);
		txtPlacaAct.setBounds(620, 131, 96, 19);
		contentPane.add(txtPlacaAct);
		
		txtModeloAct = new JTextField();
		txtModeloAct.setColumns(10);
		txtModeloAct.setBounds(620, 167, 96, 19);
		contentPane.add(txtModeloAct);
		
		JLabel lblModelo_1 = new JLabel("MODELO");
		lblModelo_1.setBounds(507, 170, 77, 13);
		contentPane.add(lblModelo_1);
		
		JLabel lblMarca_1 = new JLabel("MARCA");
		lblMarca_1.setBounds(507, 211, 77, 13);
		contentPane.add(lblMarca_1);
		
		txtMarcaAct = new JTextField();
		txtMarcaAct.setColumns(10);
		txtMarcaAct.setBounds(620, 208, 96, 19);
		contentPane.add(txtMarcaAct);
		
		txtNumPuertAct = new JTextField();
		txtNumPuertAct.setColumns(10);
		txtNumPuertAct.setBounds(620, 254, 96, 19);
		contentPane.add(txtNumPuertAct);
		
		JLabel lblNoPuertas_1 = new JLabel("No PUERTAS");
		lblNoPuertas_1.setBounds(507, 257, 77, 13);
		contentPane.add(lblNoPuertas_1);
		
		JLabel lblNewLabel_2 = new JLabel("INGRESAR VEHICULO");
		lblNewLabel_2.setBounds(145, 76, 104, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("ACTUALIZAR VEHICULO");
		lblNewLabel_2_1.setBounds(535, 76, 104, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarDatosVehiculo();
			}
		});
		btnNewButton_1.setBounds(631, 362, 85, 21);
		contentPane.add(btnNewButton_1);
	}
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "pruebatest");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "12345");  
              
            final Context context = new InitialContext(jndiProperties);  

            final String lookupName3 = "ejb:/PruebaPW59/VehiculoON!ec.edu.ups.prueba.busniess.VehiculoONRemote";  
            this.vehRem = (VehiculoONRemote) context.lookup(lookupName3); 
            System.out.println("CONECTADO");
		} catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	
	public void ObtenerDatos () {
		 Vehiculo v= new Vehiculo();

		String placa = txtPlaca.getText();
		String marca = txtMarca.getText();
		String modelo = txtModelo.getText();
		String num = txtPuerta.getText();
		int numP= Integer.parseInt(num);
		System.out.println(placa);
		System.out.println(marca);
		System.out.println(modelo);
		System.out.println(numP);

		v.setPlaca(placa);
		v.setMarca(marca);
		v.setModelo(modelo);
		v.setNumeroPuertas(numP);

		try {
			vehRem.insertar(v);
			JOptionPane.showMessageDialog(null,"VEHICULO AGREGADO");
			txtPlaca.setText(" ");
			txtMarca.setText(" ");
			txtModelo.setText(" ");
			txtPuerta.setText(" ");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

		public void BuscarPlacaActualizada() {
			Vehiculo veh = new Vehiculo();
			String placaA = txtPlacaAct.getText();
			System.out.println(placaA);
			Vehiculo v = this.vehRem.obtenerDatosCliente(placaA);		
			System.out.println(v);
			if (v==null) {
				JOptionPane.showMessageDialog(null,"Su vehiculo no esta registrado, Agruegue el vehiculo");
				txtPlacaAct.setText(" ");
				txtMarcaAct.setText(" ");
				txtModeloAct.setText(" ");
				txtNumPuertAct.setText(" ");	
			}else {

				txtMarcaAct.setText(v.getMarca());
				txtModeloAct.setText(v.getModelo());
				int numPu= v.getNumeroPuertas();
				String numeroP=String.valueOf(numPu);
				txtNumPuertAct.setText(numeroP);
				veh.setMarca(v.getMarca());
				System.out.println(v.getMarca());
				veh.setModelo(v.getModelo());
				System.out.println(v.getModelo());
				veh.setNumeroPuertas(v.getNumeroPuertas());
				System.out.println(v.getNumeroPuertas());
				
			}		
	}
		
		public void ActualizarDatosVehiculo() {
			String placaA = txtPlacaAct.getText();
			String marcaA = txtMarcaAct.getText();
			String modeloA = txtModeloAct.getText();
			String num= txtNumPuertAct.getText();
			int numPA=Integer.parseInt(num);
			Vehiculo v = new Vehiculo();
			v.setPlaca(placaA);
			v.setMarca(marcaA);
			v.setModelo(modeloA);
			v.setNumeroPuertas(numPA);
			
			vehRem.update(v);
			JOptionPane.showMessageDialog(null,"Su vehiculo a sido actualizado");
			txtPlacaAct.setText(" ");
			txtMarcaAct.setText(" ");
			txtModeloAct.setText(" ");
			txtNumPuertAct.setText(" ");
		}

}
