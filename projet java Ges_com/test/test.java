
import DAO.ProduitBD;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProduitBD prodCat = new ProduitBD();
        List<String> lProdCat = prodCat.getCategorietbyIdCat();
        
        for (String c:lProdCat){
            System.out.println(c);
        }
    }
    
}
