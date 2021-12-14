package ec.edu.ups.pruebaCliente.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.prueba.busniess.VehiculoONRemote;
import ec.edu.ups.prueba.model.Vehiculo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtPuerta;
	
	private VehiculoONRemote vehRem;
	private Vehiculo v;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLACA");
		lblNewLabel.setBounds(67, 137, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblModelo = new JLabel("MODELO");
		lblModelo.setBounds(67, 173, 45, 13);
		contentPane.add(lblModelo);
		
		JLabel lblMarca = new JLabel("MARCA");
		lblMarca.setBounds(67, 214, 45, 13);
		contentPane.add(lblMarca);
		
		JLabel lblNoPuertas = new JLabel("No PUERTAS");
		lblNoPuertas.setBounds(67, 260, 65, 13);
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
		btnNewButton.setBounds(166, 362, 85, 21);
		contentPane.add(btnNewButton);
	}
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "testdemo");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "testdemo");  
              
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
		String placa = txtPlaca.getText();
		String marca = txtMarca.getText();
		String modelo = txtModelo.getText();
		String num = txtPuerta.getText();
		int numP= Integer.parseInt(num);
		v.setPlaca(placa);
		v.setMarca(marca);
		v.setModelo(modelo);
		v.setNumeroPuertas(numP);
		
		
		try {
			vehRem.insertar(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
