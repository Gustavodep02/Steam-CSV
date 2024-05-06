package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController implements ISteamController{

	public SteamController() {
		// TODO Auto-generated constructor stub
	}
	
	public void media(String path, String nome, String ano, String mes, Double media) throws IOException {
        File arq = new File(path, nome);
        if (arq.exists() && arq.isFile()) {
            FileInputStream fluxo = new FileInputStream(arq);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            linha = buffer.readLine();
            while (linha != null) {
         	String mediaCSV = linha.split(",")[3];
         	Double avg = Double.parseDouble(mediaCSV);
        	
              if (linha.contains(ano) && linha.contains(mes) && avg >= media) {
                    String name = linha.split(",")[0];
                    String average = linha.split(",")[3];
                System.out.println(name + " | " + average);
                }
                linha = buffer.readLine();
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        }else {
            System.out.println("Arquivo Invalido");
        }

    }

	@Override
	public void createFile(String path, String nome, String ano, String mes) throws IOException {
		File dir = new File(path);
		File arq = new File(path,nome);
		
		if(dir.exists() && dir.isDirectory()) {
			FileWriter fileWriter = new FileWriter(arq);
			PrintWriter print = new PrintWriter(fileWriter);
			String conteudo = geraConteudo(ano, mes);
			print.write(conteudo);
			print.flush();
			fileWriter.close();
		}else {
            System.out.println("Diretorio Invalido");
        }	
		
	}
	
	public String geraConteudo( String ano, String mes) throws IOException {
		String path = "C:\\temp";
		String nome = "SteamCharts.csv";
        File arq = new File(path, nome);
        String conteudo = "";
        if (arq.exists() && arq.isFile()) {
            FileInputStream fluxo = new FileInputStream(arq);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            while (linha != null) {
                if (linha.contains(ano) && linha.contains(mes)) {
                	conteudo += linha.split(",")[0]+"\t";
                    conteudo += linha.split(",")[3]+"\r\n";
                }
                linha = buffer.readLine();
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        }else {
            System.out.println("Arquivo Invalido");
        }
        return conteudo;
    }
}
