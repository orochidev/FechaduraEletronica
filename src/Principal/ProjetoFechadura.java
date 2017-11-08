/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import SalaControle.CRUDSala;
import java.io.IOException;
import java.net.MalformedURLException;
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
    public static void main(String[] args) throws IOException, MalformedURLException, ParseException, InterruptedException {
        // TODO code application logic here
        CRUDSala crud = new CRUDSala();

        crud.updateSala();
    }
    
}
