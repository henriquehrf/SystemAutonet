/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import com.sun.imageio.plugins.common.I18N;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Henrique
 */

// ajustar aqui!
public  class  LerProperties {
     public static Properties getProp() throws IOException {
		Properties props = new Properties();
//		FileInputStream file = new FileInputStream(
//				"K:\\Setimo Semestre\\Projetos II\\SystemAutonet\\src\\utilitarios\\i18N_pt_BR.properties");
                FileInputStream file = new FileInputStream("src/utilitarios/i18N_pt_BR.properties");
   
		props.load(file);
		return props;

	}
    
}
