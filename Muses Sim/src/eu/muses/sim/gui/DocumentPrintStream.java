package eu.muses.sim.gui;

import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class DocumentPrintStream extends PrintStream {

	private Document document;

	public DocumentPrintStream(Document document, OutputStream delegateStream) {
		super(delegateStream);
		this.document = document;
	}

	@Override
	public void print(String string) {
		int offset = document.getLength();
		try {
			document.insertString(offset, string + "\n", null);
		} catch (BadLocationException e) {
		}
		super.print(string); // write to the delegate stream
	}
}
