package controller;

import java.io.IOException;

public interface ISteamController {
	public void media(String path, String nome, String ano, String mes, Double media) throws IOException;
	public void createFile(String path, String nome, String ano, String mes) throws IOException;
}
