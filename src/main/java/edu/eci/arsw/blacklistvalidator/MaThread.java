/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;

/**
 *
 * @author 2108310
 */
public class MaThread extends Thread{
    int inicio;
    int fin;
    LinkedList<Integer> blackListOcur = new LinkedList();
    String ippdres;
    int rango;
    int ocurrencesCount=0;
    HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
    
    public MaThread(String ipaddress, int I,int F,int n ){
        ippdres=ipaddress;
        inicio=I;
        fin=F;
        rango=n;

    }
    
    @Override
    public void run(){
         for (int i=inicio;i<fin && i<rango ;i++){
            ocurrencesCount++;
            if (skds.isInBlackListServer(i, ippdres) && blackListOcur.size()<5){
                
                blackListOcur.add(i);

            }
        }
    }

    public int getOcurrencesCount() {
        return ocurrencesCount;
    }

    public void setOcurrencesCount(int ocurrencesCount) {
        this.ocurrencesCount = ocurrencesCount;
    }

    public LinkedList<Integer> getBlackListOcur() {
        return blackListOcur;
    }

    public void setBlackListOcur(LinkedList<Integer> blackListOcur) {
        this.blackListOcur = blackListOcur;
    }
}
