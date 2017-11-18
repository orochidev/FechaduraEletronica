/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javax.swing.JFrame;
import javax.swing.JButton;
import Controle.SalaControle;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Pichau
 */
public class ProjetoFechadura {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        // TODO code application logic here

        int myId = getId();

        SalaControle crud = new SalaControle();
        crud.updateSala();
    }

    public static int getId(){
        System.out.println("Digite o ID da fechadura.");
        return new Scanner(System.in).nextInt();
    }

}
