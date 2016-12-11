package miw.upm.es.klondike.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import miw.upm.es.klondike.controller.Error;

public class IO {
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			this.write(title);
			try {
				input = bufferedReader.readLine();
				ok = true;
			} catch (Exception ex) {
				this.writeError("de cadena de caracteres");
			}
		} while (!ok);
		return input;
	}

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch (Exception ex) {
				this.writeError("entero");
			}
		} while (!ok);
		return input;
	}

	public char readChar(String title) {
		char charValue = ' ';
		boolean ok = false;
		do {
			String input = this.readString(title);
			if (input.length() != 1) {
				this.writeError("caracter");
			} else {
				charValue = input.charAt(0);
				ok = true;
			}
		} while (!ok);
		return charValue;
	}

	public void writeln() {
		System.out.println();
		flushOutpus();
	}

	public void write(String string) {
		System.out.print(string);
		flushOutpus();
	}

	public void writeln(String string) {
		System.out.println(string);
		flushOutpus();
	}

	public void writeError(Error error) {
		System.err.println("ERROR!! " + error.toString());
		flushOutpus();
	}

	private void writeError(String formato) {
		System.err.println("ERROR DE FORMATO! " + "Introduzca un valor con formato " + formato + ".");
		flushOutpus();
	}

	public void writeEmpty() {
		write("<vacío>");
		flushOutpus();
	}

	private void flushOutpus() {
		System.err.flush();
		System.out.flush();
	}
}
