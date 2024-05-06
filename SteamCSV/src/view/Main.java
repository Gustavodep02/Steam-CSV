package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ISteamController;
import controller.SteamController;

public class Main {

	public static void main(String[] args) {

		String path = "C:\\temp";
		String nome = "SteamCharts.csv";
		ISteamController arq = new SteamController();
		
		String ano = JOptionPane.showInputDialog("Digite o ano: ");
		String mes = JOptionPane.showInputDialog("Digite o mes: ");
		Double media = Double.parseDouble(JOptionPane.showInputDialog("Digite a media esperada: "));
		
		try {
			arq.media(path, nome, ano, mes, media);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String novoArq = ano+"_"+mes+".txt";
		try {
			arq.createFile(path, novoArq, ano, mes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
