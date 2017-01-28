/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontedados;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Notorius B.I.G
 */
public class FabricaEntityManager {

    public static EntityManagerFactory emf;

    private FabricaEntityManager() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("db_churrasco?zeroDateTimeBehavior=convertToNullPU");
        }
        return emf;

    }

}
