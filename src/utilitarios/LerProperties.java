/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.util.Properties;

/**
 *
 * @author Henrique
 */
// ajustar aqui!
public class LerProperties {

    public static Properties getProp() {
        FileInputStream file;
        Properties props;
        try {

            props = new Properties();
//            file = new FileInputStream(
//                    "src/utilitarios/i18N_pt_BR.properties")
            
            File dir = new File("K:\\Setimo Semestre\\Projetos II\\SystemAutonet\\src\\utilitarios\\i18N_pt_BR.properties");
            System.out.println();
            if (dir.exists()) {
                System.out.println("SIM, Existe");
                System.out.println(dir.getAbsolutePath());
            } else {
                System.out.println("Não Existe");
                System.out.println(dir.getAbsolutePath());
            }
            file = new FileInputStream(dir);
            props.load(file);
            return props;
//        File i = new File("src/utilitarios/i18N_pt_BR.properties").getAbsoluteFile();
//        if (i.exists()) {
//            System.out.println(" Existe");
//        } else {
//            System.out.println("Não Existe!");
//        }
//        System.out.println("\n\n");
//        System.out.println("->" + i.getAbsolutePath());
//        System.out.println("Acima");
//        FileInputStream file = new FileInputStream("src/utilitarios/i18N_pt_BR.properties");
//        FileInputStream file = new FileInputStream(i.getAbsolutePath());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        // return props;
        return null;

    }

}
