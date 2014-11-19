
package pr_samurai2_0;

import prototype.PR_crawlerMultThread;
import prototype.PR_crawlerSingleThread;

/**
 *
 * @author bp12214
 */
public class Pr_Samurai2_0 {

    private static PR_crawlerMultThread craw_thread[];
    private static PR_crawlerMultThread craw_thread2[];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Search s = new Search();
        s.setLocationRelativeTo(null);
        s.setVisible(true);
    
        String ext[] ={"txt","doc","pdf","xls","vsd","ppt","mdb","xml","html","xhtml","mp3","css","csv","java"};
        craw_thread = new PR_crawlerMultThread[ext.length];
        craw_thread2 = new PR_crawlerMultThread[ext.length];
        
//        for(int k=0;k<ext.length;k++){
//            craw_thread[k] = new PR_crawlerMultThread("\\\\corarqibt01\\sft\\Publico", ext[k]);
//            craw_thread[k].start();
//        }
        for(int l=0;l<ext.length;l++){
            craw_thread2[l] = new PR_crawlerMultThread("\\\\corarqibt01\\sft\\Projeto Michelin_Sonda", ext[l]);
            craw_thread2[l].start();
        }
    }
}
