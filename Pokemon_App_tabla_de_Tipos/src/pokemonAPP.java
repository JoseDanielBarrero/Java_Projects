import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.Icon;

public class pokemonAPP {

	private JFrame frame;
	private boolean estadobtnAcero =false;
	private int[] estadobtn = new int[17];
	JLabel lbltipo1 = new JLabel("");
	JLabel lbltipo2 = new JLabel("");
	private JButton[] botones = new JButton[17];
	private JLabel[] debilidades = new JLabel[12];
	private JLabel[] resistencias = new JLabel[12];
	
	private double[][] tablaTipos = new double[17][17];
	
	private Tipo[] tipos;
	
	

	private Color colorb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pokemonAPP window = new pokemonAPP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pokemonAPP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void iniTablaTipos()
	{
		// Definiciond e la tbala en sus valroes base
		for (int i = 0; i < 17; i++) 
		{
			for (int j = 0; j < 17; j++) 
			{
				tablaTipos[i][j]=1;
				
			}
		
		}
		
		// Definicion de los elementos nulos 
		
		tablaTipos[15][0] = 0;
		tablaTipos[14][16] = 0;
		tablaTipos[11][13] = 0;
		tablaTipos[9][5] = 0;
		tablaTipos[8][5] = 0;
		tablaTipos[5][9] = 0;
		tablaTipos[4][14] = 0;
		
		// Anexo de x2 en al tabla
		
		for (int i = 0; i < tipos.length; i++) 
		{
			for (int j = 0; j < tipos[i].getDebilidades().size(); j++) 
			{
				tablaTipos[i][tipos[i].getDebilidades().get(j)] = 2;
			}
		}
		
		for (int i = 0; i < tipos.length; i++) 
		{
			for (int j = 0; j < tipos[i].getFortalezas().size(); j++) 
			{
				tablaTipos[i][tipos[i].getFortalezas().get(j)] = 0.5;
			}
		}
		
		
		
	}
	public int darSuma()
	{
		int sum = 0;
		for (int i = 0; i < estadobtn.length; i++) {
			sum += estadobtn[i];
		}
		return sum;
	}
	public boolean verificarClick()
	{
		int sum = darSuma();
		
		boolean puede = false;
		
		if(sum <2)
		{
			puede = true;
		}
		else
		{
			iniEstados();
			reiniciarBotones();
		}
		return puede;
	}
	public void iniEstados()
	{
		for (int i = 0; i < estadobtn.length; i++) {
			estadobtn[i]= 0;
		}
	}
	
	private ArrayList<Integer> getTiposActivos()
	{
		ArrayList<Integer> tipos_activos = new ArrayList<Integer>();
		for (int i = 0; i < estadobtn.length; i++) {
			if(estadobtn[i] == 1)
			{
				tipos_activos.add(i);
			}
		}
		
		return tipos_activos;
	}
	public void iniDatos()
	{
		for (int i = 0; i < debilidades.length; i++) {
			debilidades[i] = new  JLabel("");
			resistencias[i] = new  JLabel("");
		}
	}
	public void resetDatos()
	{
		for (int i = 0; i < debilidades.length; i++) {
			debilidades[i].setIcon(new ImageIcon());
			resistencias[i].setIcon(new ImageIcon());
		}
	}
	
	public void resetResis()
	{
		for (int i = 0; i < debilidades.length; i++) {
			
			resistencias[i].setIcon(new ImageIcon());
		}
	}
	
	public void iniTipos()
	{
		Tipo r = new Tipo("Acero", "Images\\Tipo_acero.gif");
		tipos[0] = r;
		tipos[1] = new Tipo("Agua", "Images\\Tipo_agua.gif");
		tipos[2] = new Tipo("Bicho", "Images\\Tipo_bicho.gif");
		tipos[3] = new Tipo("Dragon", "Images\\Tipo_dragon.gif");
		
		tipos[4] = new Tipo("Electrico", "Images\\Tipo_electrico.gif");
		tipos[5] = new Tipo("Fantasma", "Images\\Tipo_fantasma.gif");
		tipos[6] = new Tipo("Fuego", "Images\\Tipo_fuego.gif");
		tipos[7] = new Tipo("Hielo", "Images\\Tipo_hielo.gif");
		
		tipos[8] = new Tipo("Lucha", "Images\\Tipo_lucha.gif");
		tipos[9] = new Tipo("Normal", "Images\\Tipo_normal.gif");
		tipos[10] = new Tipo("Planta", "Images\\Tipo_planta.gif");
		tipos[11] = new Tipo("Psiquico", "Images\\Tipo_psiquico.gif");
		
		tipos[12] = new Tipo("Roca", "Images\\Tipo_roca.gif");
		tipos[13] = new Tipo("Siniestro", "Images\\Tipo_siniestro.gif");
		tipos[14] = new Tipo("Tierra", "Images\\Tipo_tierra.gif");
		tipos[15] = new Tipo("Veneno", "Images\\Tipo_veneno.gif");
		tipos[16] = new Tipo("Volador", "Images\\Tipo_volador.gif");
	
		// Set fortalezas
		
		tipos[0].setDebilidades(7, 12);
		tipos[1].setDebilidades(6,12,14);
		tipos[2].setDebilidades(10,11,13);
		
		tipos[3].setDebilidades(3);
		tipos[4].setDebilidades(1,16);
		tipos[5].setDebilidades(5,11);
		
		tipos[6].setDebilidades(0,2,7,10);
		tipos[7].setDebilidades(3,10,14,16);
		tipos[8].setDebilidades(0,7,9,12,13);
		
		tipos[9].setDebilidades();
		tipos[10].setDebilidades(1,12,14);
		tipos[11].setDebilidades(8,15);
		
		tipos[12].setDebilidades(2,6,7,16);
		tipos[13].setDebilidades(5,11);
		tipos[14].setDebilidades(0,4,6,12,15);
		
		tipos[15].setDebilidades(10);
		tipos[16].setDebilidades(2,8,10);
		
		// Set Debilidades
		
		tipos[0].setFortalezas(0,1,4,6);
		tipos[1].setFortalezas(1,3,10);
		tipos[2].setFortalezas(0,5,6,8,15,16);
		
		tipos[3].setFortalezas(0);
		tipos[4].setFortalezas(3,4,10);
		tipos[5].setFortalezas(0,13);
	
		tipos[6].setFortalezas(1,3,6,12);
		tipos[7].setFortalezas(0,1,6,7);
		tipos[8].setFortalezas(2,11,15,16);
		
		tipos[9].setFortalezas(0,12);
		tipos[10].setFortalezas(0,2,3,6,10,15,16);
		tipos[11].setFortalezas(0,11);
		
		tipos[12].setFortalezas(0,8,14);
		tipos[13].setFortalezas(0,8,13);
		tipos[14].setFortalezas(2,10);
		
		tipos[15].setFortalezas(5,12,14,15);
		tipos[16].setFortalezas(0,4,12);
		
		
	}
	public void iniBotones()
	{
		JButton btnAcero = new JButton(new ImageIcon("Images\\Tipo_acero.gif"));
		JButton btnAgua = new JButton(new ImageIcon("Images\\Tipo_agua.gif"));
		JButton btnBicho = new JButton(new ImageIcon("Images\\Tipo_bicho.gif"));
		JButton btndragon = new JButton(new ImageIcon("Images\\Tipo_dragon.gif"));
		JButton btnelectrico = new JButton(new ImageIcon("Images\\Tipo_electrico.gif"));
		JButton btnfantasma = new JButton(new ImageIcon("Images\\Tipo_fantasma.gif"));
		JButton btnfuego = new JButton(new ImageIcon("Images\\Tipo_fuego.gif"));
		JButton btnhielo = new JButton(new ImageIcon("Images\\Tipo_hielo.gif"));
		JButton btnLucha = new JButton(new ImageIcon("Images\\Tipo_lucha.gif"))	;
		JButton btnNormal = new JButton(new ImageIcon("Images\\Tipo_normal.gif"));
		JButton btnplanta = new JButton(new ImageIcon("Images\\Tipo_planta.gif"));
		JButton btnPsiquico = new JButton(new ImageIcon("Images\\Tipo_psiquico.gif"));	
		JButton btnRoca = new JButton(new ImageIcon("Images\\Tipo_roca.gif"));	
		JButton btnSiniestro = new JButton(new ImageIcon("Images\\Tipo_siniestro.gif"));
		JButton btnTierra = new JButton(new ImageIcon("Images\\Tipo_tierra.gif"));	
		JButton btnVeneno = new JButton(new ImageIcon("Images\\Tipo_veneno.gif"));
		JButton btnVolador = new JButton(new ImageIcon("Images\\Tipo_volador.gif"));
		
		botones[0] = btnAcero;
		botones[1] = btnAgua;
		botones[2] = btnBicho;
		
		botones[3] = btndragon;
		botones[4] = btnelectrico;
		botones[5] = btnfantasma;
		
		botones[6] = btnfuego;
		botones[7] = btnhielo;
		botones[8] = btnLucha;
		
		botones[9] = btnNormal;
		botones[10] = btnplanta;
		botones[11] = btnPsiquico;
		
		botones[12] = btnRoca;
		botones[13] = btnSiniestro;
		botones[14] = btnTierra;
		
		botones[15] = btnVeneno;
		botones[16] = btnVolador;
		

		
	}
	
	public void agregarLabelsDeb(JPanel p)
	{
		for (int i = 0; i < debilidades.length; i++) {
			p.add(debilidades[i]);
		}
	}
	
	public void agregarLabelsRes(JPanel p)
	{
		for (int i = 0; i < resistencias.length; i++) {
			p.add(resistencias[i]);
		}
	}
	public void reiniciarBotones()
	{
		for (int i = 0; i < botones.length; i++) {
			botones[i].setBackground(colorb);
		}
		lbltipo1.setIcon(new ImageIcon());
		lbltipo2.setIcon(new ImageIcon());
		resetDatos();
	}
	

	private void setDatos() {
		
		
		/// Verificar cuantos estados hay activos
		ArrayList<Integer> tipos_activos = getTiposActivos();
		int num_tipos_pokemon = tipos_activos.size();
		int pos_Label_imagenes_deb = 0;
		int pos_Label_imagenes_res = 0;
		if(num_tipos_pokemon ==1)
		{
			
			for (int i = 0; i < tablaTipos[tipos_activos.get(0)].length; i++) 
			{
				if(tablaTipos[i][tipos_activos.get(0)] == 2)
				{
					debilidades[pos_Label_imagenes_deb].setIcon(new ImageIcon(tipos[i].getRutaimg()));
					pos_Label_imagenes_deb++;
					debilidades[pos_Label_imagenes_deb].setIcon(new ImageIcon("Images\\X2.png"));
					pos_Label_imagenes_deb++;
				}
				// cambiar a else if
				else if(tablaTipos[i][tipos_activos.get(0)] == 0.5)
				{
					resistencias[pos_Label_imagenes_res].setIcon(new ImageIcon(tipos[i].getRutaimg()));
					pos_Label_imagenes_res++;
					//resistencias[pos_Label_imagenes_res].setIcon(new ImageIcon("Images\\1_2.png"));
					//pos_Label_imagenes_res++;
				}
				
				else if(tablaTipos[i][tipos_activos.get(0)] == 0)
				{
					if(pos_Label_imagenes_res%2 != 0)
					{
						pos_Label_imagenes_res++;
					}
					resistencias[pos_Label_imagenes_res].setIcon(new ImageIcon(tipos[i].getRutaimg()));
					pos_Label_imagenes_res++;
					if(pos_Label_imagenes_res<11)
					{
						resistencias[pos_Label_imagenes_res].setIcon(new ImageIcon("Images\\X0.png"));
						pos_Label_imagenes_res++;
					}
					
				}
				
				
			}
		}
		else
		{
			resetDatos();
			for (int i = 0; i < 17; i++) 
			{
				double resultado_Dobletipo = tablaTipos[i][tipos_activos.get(0)]*tablaTipos[i][tipos_activos.get(1)];
				if(resultado_Dobletipo == 4)
				{
					debilidades[pos_Label_imagenes_deb].setIcon(new ImageIcon(tipos[i].getRutaimg()));
					pos_Label_imagenes_deb++;
					debilidades[pos_Label_imagenes_deb].setIcon(new ImageIcon("Images\\X4.png"));
					pos_Label_imagenes_deb++;
				}
				else if(resultado_Dobletipo == 2)
				{
					debilidades[pos_Label_imagenes_deb].setIcon(new ImageIcon(tipos[i].getRutaimg()));
					pos_Label_imagenes_deb++;
					debilidades[pos_Label_imagenes_deb].setIcon(new ImageIcon("Images\\X2.png"));
					pos_Label_imagenes_deb++;
				}
				else if(resultado_Dobletipo == 0)
				{
					if(pos_Label_imagenes_res%2 != 0)
					{
						pos_Label_imagenes_res++;
					}
					resistencias[pos_Label_imagenes_res].setIcon(new ImageIcon(tipos[i].getRutaimg()));
					pos_Label_imagenes_res++;
					if(pos_Label_imagenes_res<11)
					{
						resistencias[pos_Label_imagenes_res].setIcon(new ImageIcon("Images\\X0.png"));
						pos_Label_imagenes_res++;
					}
				}
				else if(resultado_Dobletipo <= 0.5)
				{
					resistencias[pos_Label_imagenes_res].setIcon(new ImageIcon(tipos[i].getRutaimg()));
					pos_Label_imagenes_res++;
				}
				
			}
		}
		
		
		
		
		
		
		
	}
	
	private void setDatos_DosTipos(int tipo1, int tipo2)
	{
		
	}
	private void initialize() {
		iniEstados();
		iniBotones();
		iniDatos();
		tipos = new Tipo[17];
		iniTipos();
		iniTablaTipos();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 1));
		
		int estadobtn1 = 0;
		///////////////////////////
		/// Imagenes
		///////////////////////////
		
		JPanel debil = new JPanel();
		debil.setLayout(new GridLayout(6,2));
		agregarLabelsDeb(debil);
		debil.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel resis = new JPanel();
		resis.setLayout(new GridLayout(6,2));
		agregarLabelsRes(resis);
		resis.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		
		
		
		JPanel contenedorAbajo = new JPanel();
		contenedorAbajo.setLayout(new GridLayout(1,2));
		contenedorAbajo.add(debil);
		contenedorAbajo.add(resis);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBounds(100, 100, 450, 200);
		
		JPanel contenedorArriba = new JPanel();;
		contenedorArriba.setLayout(new BorderLayout());
		contenedorArriba.add(panel_1, BorderLayout.CENTER);
		
		JPanel titulos = new JPanel();
		titulos.setLayout(new GridLayout(1,2));
		titulos.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel t1 = new JLabel("    Debil A:");
		t1.setFont(new Font("Audiowide", Font.BOLD, 32));
		
		JLabel t2 = new JLabel(" Resiste A:");
		t2.setFont(new Font("Audiowide", Font.BOLD, 32));
		titulos.add(t1);
		titulos.add(t2);
		
		contenedorArriba.add(titulos, BorderLayout.SOUTH);
		
		frame.getContentPane().add(contenedorArriba);
		frame.getContentPane().add(contenedorAbajo);
		
		
		for (int i = 0; i < botones.length; i++) {
			panel_1.add(botones[i]);
		}
		
		
		colorb = botones[0].getBackground();
		
		/*
		 * Boton tipo Acero
		 */
		botones[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[0] == 0)
					{
						
						botones[0].setBackground(Color.green);
						estadobtn[0] = 1;
						setDatos();
					}
					else
					{
						botones[0].setBackground(colorb);
						estadobtn[0] = 0;
						reiniciarBotones();
						
					}
					
				}
				
			}

			
		});
		
		
		
		/**
		 * Boton Tipo Agua
		 */
		botones[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[1] == 0)
					{
						
						botones[1].setBackground(Color.green);
						estadobtn[1] = 1;
						setDatos();
					}
					else
					{
						botones[1].setBackground(colorb);
						estadobtn[1] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Bicho
		 */
		botones[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[2] == 0)
					{
						
						botones[2].setBackground(Color.green);
						estadobtn[2] = 1;
						setDatos();
					}
					else
					{
						botones[2].setBackground(colorb);
						estadobtn[2] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Dragon
		 */
		botones[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[3] == 0)
					{
						
						botones[3].setBackground(Color.green);
						estadobtn[3] = 1;
						setDatos();
					}
					else
					{
						botones[3].setBackground(colorb);
						estadobtn[3] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Electrico
		 */
		botones[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[4] == 0)
					{
						
						botones[4].setBackground(Color.green);
						estadobtn[4] = 1;
						setDatos();
					}
					else
					{
						botones[4].setBackground(colorb);
						estadobtn[4] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Fantasma
		 */
		botones[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[5] == 0)
					{
						
						botones[5].setBackground(Color.green);
						estadobtn[5] = 1;
						setDatos();
					}
					else
					{
						botones[5].setBackground(colorb);
						estadobtn[5] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Fuego
		 */
		botones[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[6] == 0)
					{
						
						botones[6].setBackground(Color.green);
						estadobtn[6] = 1;
						setDatos();
					}
					else
					{
						botones[6].setBackground(colorb);
						estadobtn[6] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Hielo
		 */
		botones[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[7] == 0)
					{
						
						botones[7].setBackground(Color.green);
						estadobtn[7] = 1;
						setDatos();
					}
					else
					{
						botones[7].setBackground(colorb);
						estadobtn[7] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Lucha
		 */
		botones[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[8] == 0)
					{
						
						botones[8].setBackground(Color.green);
						estadobtn[8] = 1;
						setDatos();
					}
					else
					{
						botones[8].setBackground(colorb);
						estadobtn[8] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Normal
		 */
		botones[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[9] == 0)
					{
						
						botones[9].setBackground(Color.green);
						estadobtn[9] = 1;
						setDatos();
					}
					else
					{
						botones[9].setBackground(colorb);
						estadobtn[9] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Planta
		 */
		botones[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[10] == 0)
					{
						
						botones[10].setBackground(Color.green);
						estadobtn[10] = 1;
						setDatos();
					}
					else
					{
						botones[10].setBackground(colorb);
						estadobtn[10] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Psiquico
		 */
		botones[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[11] == 0)
					{
						
						botones[11].setBackground(Color.green);
						estadobtn[11] = 1;
						setDatos();
					}
					else
					{
						botones[11].setBackground(colorb);
						estadobtn[11] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Roca
		 */
		botones[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[12] == 0)
					{
						
						botones[12].setBackground(Color.green);
						estadobtn[12] = 1;
						setDatos();
					}
					else
					{
						botones[12].setBackground(colorb);
						estadobtn[12] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Siniestro
		 */
		botones[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[13] == 0)
					{
						
						botones[13].setBackground(Color.green);
						estadobtn[13] = 1;
						setDatos();
					}
					else
					{
						botones[13].setBackground(colorb);
						estadobtn[13] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Tierra
		 */
		botones[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[14] == 0)
					{
						
						botones[14].setBackground(Color.green);
						estadobtn[14] = 1;
						setDatos();
					}
					else
					{
						botones[14].setBackground(colorb);
						estadobtn[14] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Veneno
		 */
		botones[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[15] == 0)
					{
						
						botones[15].setBackground(Color.green);
						estadobtn[15] = 1;
						setDatos();
					}
					else
					{
						botones[15].setBackground(colorb);
						estadobtn[15] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
		/**
		 * Boton Tipo Volador
		 */
		botones[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(verificarClick() )
				{
					if(estadobtn[16] == 0)
					{
						
						botones[16].setBackground(Color.green);
						estadobtn[16] = 1;
						setDatos();
					}
					else
					{
						botones[16].setBackground(colorb);
						estadobtn[16] = 0;
						reiniciarBotones();
					}
				}
				
			}
		});
		
	}

}
