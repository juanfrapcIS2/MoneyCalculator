package Application;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

public class FileChooser extends JFileChooser {

    public FileChooser() {
        this.addChoosableFileFilter(withExtension(".db"));
        this.addChoosableFileFilter(withExtension(".txt"));
        this.setCurrentDirectory(new File(System.getProperty("user.home")));
    }
    
    public String open(JFrame frame){
        int retorno = this.showOpenDialog(frame);
        File selectedFile = null;
        if (retorno == JFileChooser.APPROVE_OPTION){
            selectedFile = this.getSelectedFile();
        }
        if(selectedFile.getName().endsWith(".db")){
            return "jdbc:sqlite:" + selectedFile.getName();
        }
        return selectedFile.getAbsolutePath();
    }

    private FileFilter withExtension(String extension) {
        return new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.getName().endsWith(extension);
            }

            @Override
            public String getDescription() {
                return  extension.equals(".db") ? "Base de datos SQLlite" : "Fiechero de texto";
            }
        };
    }

        
    
}
