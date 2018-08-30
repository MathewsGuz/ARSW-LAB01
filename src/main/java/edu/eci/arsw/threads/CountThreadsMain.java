/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
          CountThread obj = new CountThread(0,100);
          CountThread obj1 = new CountThread(100,200);
          CountThread obj2 = new CountThread(200,300);
          obj.start();
          obj1.start();
          obj2.start();
    }
    
}
