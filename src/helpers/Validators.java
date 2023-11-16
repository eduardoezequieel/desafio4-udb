package helpers;

import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class Validators {
    private static String noMaliciousCharactersRegex = "^[\\p{L}a-zA-Z0-9_@./#&+\\- ]*$";
    private static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
    public static String getNoMaliciousCharactersRegex() {
        return noMaliciousCharactersRegex;
    }
    
    public static String getEmailRegex() {
        return emailRegex;
    }
    
    public static boolean checkTextLength(String text, int allowedText) {
        if (text.length() > allowedText) return false;
        
        return true;
    }
    
    public static boolean matchesRegex(String text, String regex) {
        return Pattern.matches(regex, text);
    }
    
    public static void clearTextField(JTextField textField) {
    Document document = textField.getDocument();

    AbstractDocument abstractDocument = (AbstractDocument) document;
    DocumentFilter documentFilter = abstractDocument.getDocumentFilter();
    abstractDocument.setDocumentFilter(null);

    textField.setText("");

    abstractDocument.setDocumentFilter(documentFilter);
}

    
    public static void allowNumbers(JTextField textField, int maxLength) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (isInteger(string) && (fb.getDocument().getLength() + string.length() <= maxLength)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isInteger(text) && (fb.getDocument().getLength() - length + text.length() <= maxLength)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isInteger(String texto) {
                try {
                    Integer.parseInt(texto);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        });
    }
}
