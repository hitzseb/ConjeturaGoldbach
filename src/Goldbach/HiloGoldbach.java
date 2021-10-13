/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Goldbach;

import javax.swing.JTextArea;

/**
 *
 * @author Sebastian
 */
public class HiloGoldbach extends Thread implements Primo {

    int num = 10000;
    JTextArea ta;
    
    @Override
    public boolean esPrimo(int num) {
        for (int i = 2; i < num; i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    
    
    public HiloGoldbach(JTextArea ta) {
        this.ta = ta;
    }

    @Override
    public void run() {
        for (int i = 4; i <= num; i += 2)
        {
            loop:
            for (int j = 2; j < num; j++)
            {
                if (esPrimo(j))
                {
                    for (int k = 2; k <= num; k++)
                    {
                        if (esPrimo(k))
                        {
                            if (j + k == i)
                            {
                                ta.append("  " + i + "    =    " + j + " + " + k + "\n");
                                break loop;
                            }
                        }
                    }
                }
            }
        }
    }
    
}
