/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetrmi;

import java.rmi.*;
import java.rmi.RemoteException;

/**
 *
 * @author Fanta Diakité
 */
public interface LoginInterface extends Remote{
    public boolean getLogin(String user, String pwd) throws RemoteException;
}
