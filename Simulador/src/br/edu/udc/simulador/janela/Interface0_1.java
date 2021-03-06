package br.edu.udc.simulador.janela;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import br.edu.udc.simulador.controle.Computador;
import br.edu.udc.simulador.janela.view.ViewGrafico;
import br.edu.udc.simulador.janela.view.ViewTabela;

import java.awt.Dimension;

public class Interface0_1 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private Computador computador = Computador.getInstancia();
	private ViewTabela viewTabela;
	private ViewGrafico viewGrafico;
	int i = 10;
	private JTextField textField;

	// TableModel tableModel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Interface0_1 frame = new Interface0_1();
					FrameMemoria memoria = new FrameMemoria();
					frame.setVisible(true);
					memoria.setBounds(600, 100, 450, 200);
					memoria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface0_1() {
		super("Simulador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 300);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// setResizable(false);

		JMenu processos = new JMenu("Processos");
		menuBar.add(processos);
		{

			JMenuItem adicionar = new JMenuItem("Criar");
			adicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CriaProcessoFrame processo = new CriaProcessoFrame();
					processo.setVisible(true);
				}
			});
			processos.add(adicionar);

			JMenuItem importarProcesso = new JMenuItem("Importar processos");
			importarProcesso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CriaProcessoFrame processo = new CriaProcessoFrame();
					processo.setVisible(true);
				}
			});
			processos.add(importarProcesso);

			JMenuItem alterarPrioridade = new JMenuItem("Alterar prioridade");
			processos.add(alterarPrioridade);
			alterarPrioridade.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogAlteraPrioridade alteraPrioridadeDialog = new DialogAlteraPrioridade("Altera prioridade");
					alteraPrioridadeDialog.setVisible(true);
					alteraPrioridadeDialog.getResult();
				}
			});
			JMenuItem finalizar = new JMenuItem("Finalizar");
			processos.add(finalizar);
			finalizar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogFinaliza finalizaProcesso = new DialogFinaliza();
					finalizaProcesso.setVisible(true);
					if (finalizaProcesso.getResult() == 1) {
						System.out.println(finalizaProcesso.getPID());
						computador.finalizarProcesso(finalizaProcesso.getPID());
					}

				}
			});

			JMenuItem pausa = new JMenuItem("Pausar");
			processos.add(pausa);
			pausa.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogPausar pausaProcesso = new DialogPausar();
					pausaProcesso.setVisible(true);
				}
			});
			JMenuItem retomar = new JMenuItem("Retomar");
			processos.add(retomar);
			retomar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogRetomar retomaProcesso = new DialogRetomar();
					retomaProcesso.setVisible(true);
				}
			});
		}
		JMenu hardware = new JMenu("Hardware");
		menuBar.add(hardware);
		{
			JMenuItem alteraClockCpu = new JMenuItem("Altera clock CPU");
			hardware.add(alteraClockCpu);
			alteraClockCpu.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogAlteraE_S1 alteraClock = new DialogAlteraE_S1("Altera numero de Intru�oes CPU");
					
					System.out.print(alteraClock.getValor());
					
					alteraClock.setVisible(true);
				}
			});
			JMenuItem alteraClockEs_1 = new JMenuItem("Altera clock E/S 1");
			hardware.add(alteraClockEs_1);
			alteraClockEs_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogAlteraE_S1 alteraClockES1 = new DialogAlteraE_S1("Altera numero de Intru�oes E/S.1");
					alteraClockES1.setVisible(true);
				}
			});

			JMenuItem alteraClockEs_2 = new JMenuItem("Altera clock E/S 2");
			hardware.add(alteraClockEs_2);
			alteraClockEs_2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogAlteraE_S1 alteraClockES2 = new DialogAlteraE_S1("Altera numero de Intru�oes E/S.2");
					alteraClockES2.setVisible(true);
				}
			});
			JMenuItem alteraClockEs_3 = new JMenuItem("Altera clock E/S 3");
			hardware.add(alteraClockEs_3);
			alteraClockEs_3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DialogAlteraE_S1 alteraClockES3 = new DialogAlteraE_S1("Altera numero de Intru�oes E/S.3");
					alteraClockES3.setVisible(true);

				}
			});
			JMenuItem estrtegiaDeMemoria = new JMenuItem("Pausar/resumir processamento");
			hardware.add(estrtegiaDeMemoria);
			hardware.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					computador.touglePlay();	
				}
			});
			
				
			JMenuItem desfragmenta = new JMenuItem("Desfragmenta");
			hardware.add(desfragmenta);
			desfragmenta.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//TODO desfragmenta
				}
			});
		}
		JMenu Ajuda = new JMenu("Ajuda");
		menuBar.add(Ajuda);

		JMenuItem Manual = new JMenuItem("Manual");
		Ajuda.add(Manual);

		JMenuItem Sobre = new JMenuItem("Sobre");
		Ajuda.add(Sobre);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		ScrollPane scrollpaneTabela = new ScrollPane();
		tabbedPane.addTab("Detalhes", null, scrollpaneTabela, null);
		viewTabela = new ViewTabela();
		scrollpaneTabela.add(viewTabela);
		setPreferredSize(new Dimension(100, 50));

		ScrollPane scrollpane = new ScrollPane();
		tabbedPane.addTab("Grafico", null, scrollpane, null);
		viewGrafico = new ViewGrafico();
		scrollpane.add(viewGrafico);
		SpringLayout layoutgrafico = new SpringLayout();
		viewGrafico.setLayout(layoutgrafico);

		textField = new JTextField(media());
		layoutgrafico.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, viewGrafico);
		layoutgrafico.putConstraint(SpringLayout.WEST, textField, -80, SpringLayout.EAST, viewGrafico);
		layoutgrafico.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, viewGrafico);
		textField.setBackground(getBackground());
		textField.setEditable(false);
		viewGrafico.add(textField);

		textField = new JTextField(mediana());
		layoutgrafico.putConstraint(SpringLayout.NORTH, textField, 30, SpringLayout.NORTH, viewGrafico);
		layoutgrafico.putConstraint(SpringLayout.WEST, textField, -80, SpringLayout.EAST, viewGrafico);
		layoutgrafico.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, viewGrafico);
		textField.setBackground(getBackground());
		textField.setEditable(false);
		viewGrafico.add(textField);

		textField = new JTextField(moda());
		layoutgrafico.putConstraint(SpringLayout.NORTH, textField, 50, SpringLayout.NORTH, viewGrafico);
		layoutgrafico.putConstraint(SpringLayout.WEST, textField, -80, SpringLayout.EAST, viewGrafico);
		layoutgrafico.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, viewGrafico);
		textField.setBackground(getBackground());
		textField.setEditable(false);
		viewGrafico.add(textField);

		this.computador.adicionaView(viewTabela);
	}
	
	public String moda() {
		return String.format("Moda:%d", i);
	}

	public String media() {
		return String.format("media:%d", i);
	}

	public String mediana() {
		return String.format("mediana:%d", i);
	}
}
