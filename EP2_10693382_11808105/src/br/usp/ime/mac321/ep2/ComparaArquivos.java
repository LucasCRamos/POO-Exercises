package br.usp.ime.mac321.ep2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ComparaArquivos {
	
	//Função retirada do site: https://www.guj.com.br/t/verificar-igualdade-entre-arquivos/55860/5
	public boolean compara(String file1, String file2) {
		
        File f1 = new File(file1);
        File f2 = new File(file2);
        byte[] f1_buf = new byte[1048576];
        byte[] f2_buf = new byte[1048576];
        int len;
        if (f1.length() == f2.length()) {
            try {
                InputStream isf1 = new FileInputStream(f1);
                InputStream isf2 = new FileInputStream(f2);
                try {
                    while (isf1.read(f1_buf) >= 0) {
                        len=isf2.read(f2_buf);
                        for (int j = 0; j < len; j++) {
                            if (f1_buf[j] != f2_buf[j]) {
                                return false; // tamanho igual e conteudo diferente
                            }
                        }
                    }
                } catch (IOException e) {
                }
            } catch (FileNotFoundException e) {
            }
        } else {
            return false; // tamanho e conteudo diferente
       }
        return true; // arquivos iguais
 
	}


}
