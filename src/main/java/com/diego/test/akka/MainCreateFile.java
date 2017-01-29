package com.diego.test.akka;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainCreateFile {

	private final Long NUMBER_OF_LINES = 10000000L;
	private final String LINE = "la casa de mi tio es de madera de pino de la buena que te cagas, y encima no se rompe ni se rasga, pero lo mejor de todo es que siempre me lo podria fumar";

	public static void main(String[] args) {
		MainCreateFile main = new MainCreateFile();
		main.boot();
	}

	public void boot() {
		Charset charset = Charset.forName("UTF-8");
		Path p = Paths.get("/Users/diegozarcogomez/Documents/file.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(p, charset)) {
			for (long i = 0; i < NUMBER_OF_LINES; i++) {
				writer.write(LINE);
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
}
