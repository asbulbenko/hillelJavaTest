package xml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Stack;

public class XmlValidation {


    public XmlValidation() {
    }

    public boolean xmlFileInput(Path path) throws IOException {
        String fileString = new String(Files.readAllBytes(path));
        if (fileString.contains("<?xml version=")) {
            return true;
        } else
        return false;
    }

    public boolean xmlFileExtension(Path path){
        String fileName = path.getFileName().toString();
        return fileName.endsWith(".xml") || fileName.endsWith(".fxml");
    }

    public boolean xmlParenthesisCheck(Path path) throws IOException {
        String fileString = new String(Files.readAllBytes(path));
        if (fileString.isEmpty()) {
            System.out.println("Empty string file");
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < fileString.length(); i++) {
            char current = fileString.charAt(i);
            if (current == '<') {
                stack.push(current);
            }

            if (current == '>') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.peek();
                if(current == '>' && last == '<'){
                    stack.pop();
                }else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
