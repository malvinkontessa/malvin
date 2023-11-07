/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz51022010;

import java.io.*;
/**
 *
 * @author Asus
 */
public class SimpanBacaDataMahasiswa {
    
    int L = 0, TL = 0;
    
public void SimpanData(String nama_mahasiswa, String nim, String n_akhir, String n_huruf, String keterangan){
        
        try{
            FileOutputStream fout = new FileOutputStream("Data Mahasiswa.dat", true);
            DataOutputStream out = new DataOutputStream(fout);
            out.writeUTF(nama_mahasiswa);
            out.writeUTF(nim);
            out.writeUTF(n_akhir);
            out.writeUTF(n_huruf);
            out.writeUTF(keterangan);
            out.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }
    
    public String BacaData(){
        String nama_mahasiswa, nim, n_akhir, n_huruf, keterangan;
        String temp = "", data = "";
        try{
            FileInputStream fin = new FileInputStream("Data Mahasiswa.dat");
            DataInputStream in = new DataInputStream(fin);
            
            while(in.available() > 0){
                nama_mahasiswa = in.readUTF();
                nim = in.readUTF();
                n_akhir = in.readUTF();
                n_huruf = in.readUTF();
                keterangan = in.readUTF();
                if (n_huruf.equals("E")){
                    TL++;
                }else {
                    L++;
                }
                temp = "Nama Mahasiswa :" + nama_mahasiswa + "\nNIM \t:" + nim + "\nNilai Akhir \t:" + n_akhir + "\nNilai Huruf \t:" + n_huruf + "\nKeterangan \t:" + keterangan + "\n\n";
                data += temp;
            }
            in.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        return(data);
    }
    public int getL(){
        return L;
    }
    public int getTL(){
        return TL;
    }
}
