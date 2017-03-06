/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetrmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Fanta Diakité
 */
public class LoginImpl extends UnicastRemoteObject implements LoginInterface, Serializable{

    public LoginImpl() throws RemoteException {
        super();
    }

    
    @Override
    public boolean getLogin(String user, String pwd) throws RemoteException {
        boolean trouver = false;
        try {
            if(user.equals("admin") && pwd.equals("123")){
                return  trouver = true;
            }
            
            else{
                return trouver = false;
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return trouver;
    }
    
}

    

        
    
    

